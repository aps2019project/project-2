package DuelystServer.model.Card.Minion;
import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

public class PersianArcher extends Minion {
    public PersianArcher() {
        super("PersianArcher", 4, 6, 300, 2, 2, 7);
    }

    public PersianArcher(PersianArcher persianArcher) {
        super(persianArcher);
    }

    public Minion duplicate() {
        PersianArcher persianArcher = new PersianArcher(this);
        return persianArcher;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " – Special power : - .";
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
