package model.Cards.Minion;

import model.Battles.Battle;
import model.Cell;
import model.Menus.Account;
import view.Request;

public class Iraj extends Minion {
    public Iraj() {
        super("Iraj", 20, 6, 500, 4, 1, 3);
    }

    public Iraj(Iraj iraj) {
        super(iraj);
    }

    public Minion duplicate() {
        Iraj iraj = new Iraj(this);
        return iraj;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power :  .";
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request, int activeTime) {

    }

    public String getDesc() {
        return "Nothing";
    }
}