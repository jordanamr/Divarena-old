package org.divarena.game.cards;

import lombok.Getter;
import lombok.Setter;

public class CoachCard extends AbstractCard {

    @Getter @Setter
    private long uid;
    @Getter @Setter
    private byte flags;

    public CoachCard(int id, String name, int type, int value) {
        super(id, name, type, value);
    }

    public CoachCard clone() {
        return new CoachCard(id, name, type, value);
    }
}
