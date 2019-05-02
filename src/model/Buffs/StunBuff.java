package model.Buffs;

import model.Cards.*;
import model.Cell;

import java.util.ArrayList;

public class StunBuff extends Buff {

    public void stun(Hero hero) {
        hero.setStunning(true);
        hero.getOwnBuffs().add(this);
    }

    public void stun(Minion minion) {
        minion.setStunning(true);
        minion.getOwnBuffs().add(this);

    }

    private StunBuff stunBuff;
    private Cell cell;
    private Hero hero;
    private Minion minion;

    public void setCasting(StunBuff stunBuff,Cell cell,Hero hero,Minion minion) {
        this.stunBuff = stunBuff;
        this.cell = cell;
        this.hero = hero;
        this.minion = minion;
    }

    public Cell getCell() {
        return cell;
    }

    public Hero getHero() {
        return hero;
    }

    public Minion getMinion() {
        return minion;
    }

    @Override
    public void castBuff() {
        if (this.hero != null){
            stun(this.hero);
        }
        if (this.minion != null){
            stun(this.minion);
        }
    }

    @Override
    public void dispel(Hero hero) {
        hero.setStunning(false);
        hero.getOwnBuffs().remove(this);
    }

    @Override
    public void dispel(Minion minion) {
        minion.setStunning(false);
        minion.getOwnBuffs().remove(this);
    }

    public StunBuff getStunBuff() {
        return stunBuff;
    }

}