package org.divarena;

import com.github.simplenet.Server;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.divarena.database.DivarenaDatabase;
import org.divarena.logging.UncaughtExceptionLogger;
import org.divarena.network.ArenaClient;
import org.divarena.game.instances.Instance;
import org.divarena.game.instances.WorldInstance;

import java.io.File;
import java.util.*;

@Slf4j
public class Divarena {

    public static final boolean debug = true;
    private static Divarena instance = null;

    public static Divarena getInstance() {
        if (instance == null) instance = new Divarena();
        return instance;
    }

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionLogger());
        Divarena.getInstance().start();
    }

    @Getter
    private Config config;
    @Getter
    private DivarenaDatabase database;
    @Getter
    private final List<ArenaClient> clients;
    private final Map<Integer, WorldInstance> worldInstances;

    private Divarena() {
        clients = Collections.synchronizedList(new ArrayList<>());
        worldInstances = Collections.synchronizedMap(new HashMap<>());
    }

    private void start() {
        log.info("Loading config...");
        config = ConfigFactory.parseFile(new File("divarena.conf"));

        log.info("Connecting to database...");
        database = new DivarenaDatabase(config.getString("database.address"), config.getString("database.username"),
                config.getString("database.password"), config.getString("database.name"), config.getInt("database.poolSize"));
        database.connect();

        log.info("Loading WorldInstance ID 0...");
        worldInstances.put(0, new WorldInstance(0));

        Server server = new Server();
        server.onConnect(netClient -> {
            String clientIp;
            try {
                clientIp = netClient.getChannel().getRemoteAddress().toString().substring(1).split(":")[0];
            } catch (Exception ex) {
                log.error("An error occurred while parsing an user IP", ex);
                if (netClient.getChannel().isOpen()) netClient.close();
                return;
            }

            this.clients.add(new ArenaClient(netClient, clientIp));
        });
        server.bind(config.getString("network.bind.ip"), config.getInt("network.bind.port"));
    }

    public Instance getWorldInstance(int id) {
        return worldInstances.get(id);
    }

    public void removeClient(ArenaClient client) {
        clients.remove(client);
    }

    public Optional<ArenaClient> getClientByCoachName(String coachName) {
        return clients.stream().filter(coach -> coach.getCoachName().equalsIgnoreCase(coachName)).findAny();
    }
}
