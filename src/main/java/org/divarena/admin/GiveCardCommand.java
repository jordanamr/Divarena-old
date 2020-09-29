package org.divarena.admin;

import org.divarena.Divarena;
import org.divarena.game.cards.CoachCard;
import org.divarena.network.ArenaClient;
import org.divarena.protocol.server.coach.CoachInventoryUpdateMessage;

public class GiveCardCommand extends Command {

    public GiveCardCommand(String alias) {
        super(alias);
    }

    @Override
    public void execute(ArenaClient client, String[] args) {
        if (args.length == 0) {
            log(client, "Utilisation: givecard [id]");
            return;
        }

        if (args[0].equalsIgnoreCase("all")) {
            CoachInventoryUpdateMessage invUpdate = new CoachInventoryUpdateMessage();
            Divarena.getInstance().getCoachCards().values().forEach(card -> {
                CoachCard newCard = card.clone();
                newCard.setUid(Divarena.getInstance().getNextCoachCardUID());
                client.getCoach().getInventory().add(newCard);
                invUpdate.getInventoryAddedItems().put(newCard, (short) 1);
            });
            client.sendMessage(invUpdate);
            log(client, Divarena.getInstance().getCoachCards().size() + " cartes ont été ajoutées à votre inventaire");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(args[0]);
        } catch (NumberFormatException ex) {
            error(client, "ID de carte invalide.");
            return;
        }
        CoachCard card = Divarena.getInstance().getNewCoachCard(id);
        if (card == null) {
            error(client, "Carte ID '" + id + "' introuvable.");
            return;
        }
        long uid = Divarena.getInstance().getNextCoachCardUID();
        card.setUid(uid);
        client.getCoach().getInventory().add(card);

        CoachInventoryUpdateMessage invUpdate = new CoachInventoryUpdateMessage();
        invUpdate.getInventoryAddedItems().put(card, (short) 1);
        client.sendMessage(invUpdate);

        log(client, "Carte ID '" + id + "' ajoutée à votre inventaire avec l'UID " + uid);
    }
}
