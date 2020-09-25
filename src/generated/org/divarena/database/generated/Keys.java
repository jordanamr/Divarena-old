/*
 * This file is generated by jOOQ.
 */
package org.divarena.database.generated;


import org.divarena.database.generated.tables.Accounts;
import org.divarena.database.generated.tables.Coaches;
import org.divarena.database.generated.tables.records.AccountsRecord;
import org.divarena.database.generated.tables.records.CoachesRecord;
import org.jooq.Identity;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>divarena_db</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<AccountsRecord, Integer> IDENTITY_ACCOUNTS = Identities0.IDENTITY_ACCOUNTS;
    public static final Identity<CoachesRecord, Integer> IDENTITY_COACHES = Identities0.IDENTITY_COACHES;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AccountsRecord> KEY_ACCOUNTS_PRIMARY = UniqueKeys0.KEY_ACCOUNTS_PRIMARY;
    public static final UniqueKey<AccountsRecord> KEY_ACCOUNTS_USERNAME = UniqueKeys0.KEY_ACCOUNTS_USERNAME;
    public static final UniqueKey<CoachesRecord> KEY_COACHES_PRIMARY = UniqueKeys0.KEY_COACHES_PRIMARY;
    public static final UniqueKey<CoachesRecord> KEY_COACHES_NAME = UniqueKeys0.KEY_COACHES_NAME;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<AccountsRecord, Integer> IDENTITY_ACCOUNTS = Internal.createIdentity(Accounts.ACCOUNTS, Accounts.ACCOUNTS.ID);
        public static Identity<CoachesRecord, Integer> IDENTITY_COACHES = Internal.createIdentity(Coaches.COACHES, Coaches.COACHES.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<AccountsRecord> KEY_ACCOUNTS_PRIMARY = Internal.createUniqueKey(Accounts.ACCOUNTS, "KEY_accounts_PRIMARY", new TableField[] { Accounts.ACCOUNTS.ID }, true);
        public static final UniqueKey<AccountsRecord> KEY_ACCOUNTS_USERNAME = Internal.createUniqueKey(Accounts.ACCOUNTS, "KEY_accounts_username", new TableField[] { Accounts.ACCOUNTS.USERNAME }, true);
        public static final UniqueKey<CoachesRecord> KEY_COACHES_PRIMARY = Internal.createUniqueKey(Coaches.COACHES, "KEY_coaches_PRIMARY", new TableField[] { Coaches.COACHES.ID, Coaches.COACHES.ACCOUNT_ID }, true);
        public static final UniqueKey<CoachesRecord> KEY_COACHES_NAME = Internal.createUniqueKey(Coaches.COACHES, "KEY_coaches_name", new TableField[] { Coaches.COACHES.NAME }, true);
    }
}
