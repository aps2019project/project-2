package DuelystServer.model.Card.Minion;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

public class Giv extends Minion {
    public Giv() {
        super("Giv", 7, 5, 450, 4, 1, 5);
        super.setTimeOfActivationOfSpecialPower(6);
    }

    public Giv(Giv giv) {
        super(giv);
    }

    public Minion duplicate() {
        Giv giv = new Giv(this);
        return giv;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : " + SpecialPower.GIV.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {

    }

    public String getDesc() {
        return SpecialPower.GIV.getMessage();
    }

}
