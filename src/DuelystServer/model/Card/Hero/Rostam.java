package DuelystServer.model.Card.Hero;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

public class Rostam extends Hero {
    public Rostam() {
        super("Rostam", 7, 55, 8000, 2);
        super.setCoolDownTime(0);
        super.setRange(4);
    }

    public Rostam(Rostam rostam) {
        super(rostam);
    }

    public Hero duplicate() {
        Rostam rostam = new Rostam(this);
        return rostam;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : -. - CoolDown Time : -.";
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player) {
       // request.setError(ErrorType.DONT_HAVE_SPECIAL_POWER);
    }

    public String getDesc() {
        return "Nothing" + " - CoolDown Time : -.";
    }
}
