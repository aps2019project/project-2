package model.Cards.Minion;

import model.Battles.Battle;
import model.Cell;
import model.Menus.Account;
import view.Request;

public class TuranianStoneHook extends Minion {
    public TuranianStoneHook() {
        super("TuranianStoneHook", 2, 4, 600, 1, 1, 7);
    }

    public TuranianStoneHook(TuranianStoneHook turanianStoneHook) {
        super(turanianStoneHook);
    }

    public Minion duplicate() {
        TuranianStoneHook turanianStoneHook = new TuranianStoneHook(this);
        return turanianStoneHook;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : - ";
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        //nothing
    }

    public String getDesc() {
        return " Nothing";
    }
}