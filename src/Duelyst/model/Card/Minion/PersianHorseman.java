package Duelyst.model.Card.Minion;
import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Cell;
public class PersianHorseman extends Minion {
    public PersianHorseman() {
        super("PersianHorseman", 6, 10, 200, 4, 0, 0);
    }

    public PersianHorseman(PersianHorseman persianHorseman) {
        super(persianHorseman);
    }

    public Minion duplicate() {
        PersianHorseman persianHorseman = new PersianHorseman(this);
        return persianHorseman;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : -.";
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
        //nothing
    }

    public String getDesc() {
        return " Nothing";
    }
}