/*
 * This file is generated by jOOQ.
 */
package org.divarena.database.generated;


import org.divarena.database.generated.tables.Accounts;
import org.divarena.database.generated.tables.CoachCards;
import org.divarena.database.generated.tables.Coaches;
import org.divarena.database.generated.tables.FighterCards;
import org.divarena.database.generated.tables.records.AccountsRecord;
import org.divarena.database.generated.tables.records.CoachCardsRecord;
import org.divarena.database.generated.tables.records.CoachesRecord;
import org.divarena.database.generated.tables.records.FighterCardsRecord;
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
    public static final Identity<CoachCardsRecord, Integer> IDENTITY_COACH_CARDS = Identities0.IDENTITY_COACH_CARDS;
    public static final Identity<CoachesRecord, Integer> IDENTITY_COACHES = Identities0.IDENTITY_COACHES;
    public static final Identity<FighterCardsRecord, Integer> IDENTITY_FIGHTER_CARDS = Identities0.IDENTITY_FIGHTER_CARDS;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AccountsRecord> KEY_ACCOUNTS_PRIMARY = UniqueKeys0.KEY_ACCOUNTS_PRIMARY;
    public static final UniqueKey<AccountsRecord> KEY_ACCOUNTS_USERNAME = UniqueKeys0.KEY_ACCOUNTS_USERNAME;
    public static final UniqueKey<CoachCardsRecord> KEY_COACH_CARDS_PRIMARY = UniqueKeys0.KEY_COACH_CARDS_PRIMARY;
    public static final UniqueKey<CoachesRecord> KEY_COACHES_PRIMARY = UniqueKeys0.KEY_COACHES_PRIMARY;
    public static final UniqueKey<CoachesRecord> KEY_COACHES_NAME = UniqueKeys0.KEY_COACHES_NAME;
    public static final UniqueKey<FighterCardsRecord> KEY_FIGHTER_CARDS_PRIMARY = UniqueKeys0.KEY_FIGHTER_CARDS_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<AccountsRecord, Integer> IDENTITY_ACCOUNTS = Internal.createIdentity(Accounts.ACCOUNTS, Accounts.ACCOUNTS.ID);
        public static Identity<CoachCardsRecord, Integer> IDENTITY_COACH_CARDS = Internal.createIdentity(CoachCards.COACH_CARDS, CoachCards.COACH_CARDS.ID);
        public static Identity<CoachesRecord, Integer> IDENTITY_COACHES = Internal.createIdentity(Coaches.COACHES, Coaches.COACHES.ID);
        public static Identity<FighterCardsRecord, Integer> IDENTITY_FIGHTER_CARDS = Internal.createIdentity(FighterCards.FIGHTER_CARDS, FighterCards.FIGHTER_CARDS.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<AccountsRecord> KEY_ACCOUNTS_PRIMARY = Internal.createUniqueKey(Accounts.ACCOUNTS, "KEY_accounts_PRIMARY", new TableField[] { Accounts.ACCOUNTS.ID }, true);
        public static final UniqueKey<AccountsRecord> KEY_ACCOUNTS_USERNAME = Internal.createUniqueKey(Accounts.ACCOUNTS, "KEY_accounts_username", new TableField[] { Accounts.ACCOUNTS.USERNAME }, true);
        public static final UniqueKey<CoachCardsRecord> KEY_COACH_CARDS_PRIMARY = Internal.createUniqueKey(CoachCards.COACH_CARDS, "KEY_coach_cards_PRIMARY", new TableField[] { CoachCards.COACH_CARDS.ID }, true);
        public static final UniqueKey<CoachesRecord> KEY_COACHES_PRIMARY = Internal.createUniqueKey(Coaches.COACHES, "KEY_coaches_PRIMARY", new TableField[] { Coaches.COACHES.ID, Coaches.COACHES.ACCOUNT_ID }, true);
        public static final UniqueKey<CoachesRecord> KEY_COACHES_NAME = Internal.createUniqueKey(Coaches.COACHES, "KEY_coaches_name", new TableField[] { Coaches.COACHES.NAME }, true);
        public static final UniqueKey<FighterCardsRecord> KEY_FIGHTER_CARDS_PRIMARY = Internal.createUniqueKey(FighterCards.FIGHTER_CARDS, "KEY_fighter_cards_PRIMARY", new TableField[] { FighterCards.FIGHTER_CARDS.ID }, true);
    }
}
