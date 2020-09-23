package org.divarena;

import com.github.simplenet.Server;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.divarena.database.DivarenaDatabase;
import org.divarena.logging.UncaughtExceptionLogger;
import org.divarena.network.ArenaClient;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class Divarena {

    public static final boolean debug = false;
    private static Divarena instance = null;

    private static Divarena getInstance() {
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

    private Divarena() {
        clients = Collections.synchronizedList(new ArrayList<>());
    }

    private void start() {
        log.info("Loading config...");
        config = ConfigFactory.parseFile(new File("divarena.conf"));

        log.info("Connecting to database...");
        database = new DivarenaDatabase(config.getString("database.address"), config.getString("database.username"),
                config.getString("database.password"), config.getString("database.name"), config.getInt("database.poolSize"));
        database.connect();

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
}
