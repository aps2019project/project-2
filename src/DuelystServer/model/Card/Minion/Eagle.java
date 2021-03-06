package DuelystServer.model.Card.Minion;
import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

public class Eagle extends Minion {
    public Eagle() {
        super("Eagle", 2, 0, 200, 2, 1, 3);
        super.setTimeOfActivationOfSpecialPower(4);
    }

    public Eagle(Eagle eagle) {
        super(eagle);
    }

    public Minion duplicate() {
        Eagle eagle = new Eagle(this);
      /*  PowerBuff powerBuff = new PowerBuff(12, false);
        powerBuff.setTurnCounter(-4);
        powerBuff.incrementHp(eagle);
        powerBuff.setCasting(powerBuff, null, null, eagle);
        eagle.getOwnBuffs().add(powerBuff);*/
        return eagle;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: " + SpecialPower.EAGLE.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
        //already set
    }

    public String getDesc() {
        return SpecialPower.EAGLE.getMessage();
    }
}
