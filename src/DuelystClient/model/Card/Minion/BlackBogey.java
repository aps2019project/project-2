package DuelystClient.model.Card.Minion;
import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class BlackBogey extends Minion {
    public BlackBogey() {
        super("BlackBogey", 10, 14, 300, 9, 2, 7);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/boss_chaosknight_breathing.gif");
    }

    public BlackBogey(BlackBogey blackBogey) {
        super(blackBogey);
    }

    public Minion duplicate() {
        BlackBogey blackBogey = new BlackBogey(this);
        blackBogey.cardImage = new Image("DuelystClient/css/unit_gifs/boss_chaosknight_breathing.gif");
        return blackBogey;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power :-.";
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
