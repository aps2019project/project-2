package DuelystServer.model.Card.Minion;
import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

public class BlackBogey extends Minion {
    public BlackBogey() {
        super("BlackBogey", 10, 14, 300, 9, 2, 7);
    }

    public BlackBogey(BlackBogey blackBogey) {
        super(blackBogey);
    }

    public Minion duplicate() {
        BlackBogey blackBogey = new BlackBogey(this);
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
