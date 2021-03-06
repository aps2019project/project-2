package DuelystClient.model.Card.Minion;
import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class WhiteWolf extends Minion {
    public WhiteWolf() {
        super("WhiteWolf", 2, 8, 400, 5, 0, 0);
        super.setTimeOfActivationOfSpecialPower(0);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/boss_umbra_breathing.gif");
    }

    public WhiteWolf(WhiteWolf whiteWolf) {
        super(whiteWolf);
    }

    public Minion duplicate() {
        WhiteWolf whiteWolf = new WhiteWolf(this);
        whiteWolf.cardImage = new Image("DuelystClient/css/unit_gifs/boss_umbra_breathing.gif");
        return whiteWolf;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " +
                this.getHp() + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit()
                + " - Special power: " + SpecialPower.WHITE_WOLF.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
      /*  if (activeTime == 3) {
            if (cell.getMinion() != null && !player.getMainDeck().isContain(cell.getMinion())) {
                ArrayList<Integer> units = new ArrayList<>();
                units.add(6);
                units.add(4);
                MultiStageBuff multiStageBuff = new MultiStageBuff(units, cell.getMinion());
                multiStageBuff.setTurnCounter(2);
                cell.getMinion().getOwnBuffs().add(multiStageBuff);
            }
        }*/
    }

    public String getDesc() {
        return SpecialPower.WHITE_WOLF.getMessage();
    }
}
