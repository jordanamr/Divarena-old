/*
 * This file is generated by jOOQ.
 */
package org.divarena.database.generated;


import java.util.Arrays;
import java.util.List;

import org.divarena.database.generated.tables.Accounts;
import org.divarena.database.generated.tables.Coaches;
import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DivarenaDb extends SchemaImpl {

    private static final long serialVersionUID = -817191867;

    /**
     * The reference instance of <code>divarena_db</code>
     */
    public static final DivarenaDb DIVARENA_DB = new DivarenaDb();

    /**
     * The table <code>divarena_db.accounts</code>.
     */
    public final Accounts ACCOUNTS = Accounts.ACCOUNTS;

    /**
     * The table <code>divarena_db.coaches</code>.
     */
    public final Coaches COACHES = Coaches.COACHES;

    /**
     * No further instances allowed
     */
    private DivarenaDb() {
        super("divarena_db", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            Accounts.ACCOUNTS,
            Coaches.COACHES);
    }
}
