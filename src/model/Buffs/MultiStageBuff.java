package model.Buffs;

import model.Cards.Hero;
import model.Cards.Minion;
import model.Cell;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.ArrayList;

public class MultiStageBuff extends Buff {
    private Minion minion;
    private ArrayList<Integer> units;

    public MultiStageBuff(ArrayList<Integer> units, Minion minion) {
        this.units = units;
        this.minion = minion;
    }

    public void decrementHp(int unit) {
        this.minion.decrementHp(unit);
    }

    @Override
    public void castBuff() {
        decrementHp(this.units.get(0));
        this.units.remove(0);
    }

    @Override
    public void dispel(Minion minion) {
        //@jaber_coder handle it
    }

    @Override
    public void dispel(Hero hero) {
        //doesn't have this method
    }
}