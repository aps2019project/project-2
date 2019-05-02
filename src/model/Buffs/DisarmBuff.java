package model.Buffs;

import model.Cards.*;
import model.Cell;

import java.util.ArrayList;

public class DisarmBuff extends Buff {

    public void disarm(Hero hero) {
        hero.setCounterAttack(false);
        hero.getOwnBuffs().add(this);
    }

    public void disarm(Minion minion) {
        minion.setCounterAttack(false);
        minion.getOwnBuffs().add(this);
    }

    private DisarmBuff disarmBuff;
    private Cell cell;
    private Hero hero;
    private Minion minion;

    public void setCasting(DisarmBuff disarmBuff,Cell cell,Hero hero,Minion minion) {
        this.disarmBuff = disarmBuff;
        this.cell = cell;
        this.hero = hero;
        this.minion = minion;
    }

    @Override
    public void castBuff() {
        if (this.minion != null)
            disarm(this.minion);
        if (this.hero != null)
            disarm(this.hero);
    }

    @Override
    public void dispel(Hero hero) {
        hero.setCounterAttack(true);
        hero.getOwnBuffs().remove(this);
    }

    @Override
    public void dispel(Minion minion) {
        minion.setCounterAttack(true);
        minion.getOwnBuffs().remove(this);
    }

    public DisarmBuff getDisarmBuff() {
        return disarmBuff;
    }
}