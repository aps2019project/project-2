package DuelystServer.model.Card.Hero;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Card.Minion.SpecialPower;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

//import DuelystServer.model.Buff.HolyBuff;

public class Esfandyar extends Hero {
    public Esfandyar() {
        super("Esfandyar", 3, 35, 12000, 2);
        super.setCoolDownTime(0);
        super.setMp(0);
        super.setRange(3);
    }

    public Esfandyar(Esfandyar esfandyar) {
        super(esfandyar);
    }

    public Hero duplicate() {
        Esfandyar esfandyar = new Esfandyar(this);
        /*for (int i = 0; i < 3; i++) {
            HolyBuff holyBuff = new HolyBuff();
            holyBuff.setTurnCounter(-4);
            holyBuff.holy(esfandyar);
            holyBuff.setCasting(holyBuff, null, esfandyar, null);
            esfandyar.getOwnBuffs().add(holyBuff);
        }*/
        return esfandyar;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + SpecialPower.ESFANDYAR.getMessage();
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player) {
        //Its Special Power was set before
    }

    public String getDesc() {
        return SpecialPower.ESFANDYAR.getMessage();
    }
}
