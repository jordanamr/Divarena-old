package org.divarena.database;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.mariadb.jdbc.MariaDbPoolDataSource;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class DivarenaDatabase {

    private static DivarenaDatabase INSTANCE = null;

    public static DivarenaDatabase getInstance() {
        if (INSTANCE == null) throw new IllegalStateException();
        return INSTANCE;
    }

    private String url;
    @Getter
    private MariaDbPoolDataSource pool;
    @Getter
    private DSLContext dsl;

    public DivarenaDatabase(String server, String username, String password, String database, int poolSize) {
        this.url = String.format("jdbc:mariadb://%s/%s?user=%s&password=%s&maxPoolSize=%s", server, database, username, password, poolSize);
        INSTANCE = this;
    }

    public void connect() {
        pool = new MariaDbPoolDataSource(url);
        this.dsl = DSL.using(pool, SQLDialect.MARIADB);
        log.info("Successfully connected to game database.");
    }

    public Connection getConnection() throws SQLException {
        return pool.getConnection();
    }
}
