package org.divarena.game.cards;

import lombok.Getter;

public abstract class AbstractCard {

    @Getter
    protected int id;
    @Getter
    protected String name;
    @Getter
    protected int type;
    @Getter
    protected int value;

    protected AbstractCard(int id, String name, int type, int value) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.value = value;
    }
}
