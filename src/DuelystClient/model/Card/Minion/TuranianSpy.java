package DuelystClient.model.Card.Minion;

import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class TuranianSpy extends Minion {
    public TuranianSpy() {
        super("TuranianSpy", 6, 6, 700, 4, 0, 0);
        super.setTimeOfActivationOfSpecialPower(0);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/boss_solfist_breathing.gif");
    }

    public TuranianSpy(TuranianSpy turanianSpy) {
        super(turanianSpy);
    }

    public Minion duplicate() {
        TuranianSpy turanianSpy = new TuranianSpy(this);
        turanianSpy.cardImage = new Image("DuelystClient/css/unit_gifs/boss_solfist_breathing.gif");
        return turanianSpy;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : " + SpecialPower.TURANIAN_SPY.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
     /*   if (activeTime == 3) {
            if (cell.getHero() != null) {
                DisarmBuff disarmBuff = new DisarmBuff();
                disarmBuff.setTurnCounter(1 + 1 - 1);
                disarmBuff.disarm(cell.getHero());
                disarmBuff.setCasting(disarmBuff, null, cell.getHero(), null);
                cell.getHero().getOwnBuffs().add(disarmBuff);
                PoisonBuff poisonBuff = new PoisonBuff();
                poisonBuff.setTurnCounter(4);
                poisonBuff.poison(cell.getHero());
                poisonBuff.setCasting(poisonBuff, null, cell.getHero(), null);
                cell.getHero().getOwnBuffs().add(poisonBuff);
            } else if (cell.getMinion() != null) {
                DisarmBuff disarmBuff = new DisarmBuff();
                disarmBuff.setTurnCounter(1 + 1 - 1);
                disarmBuff.disarm(cell.getMinion());
                disarmBuff.setCasting(disarmBuff, null, null, cell.getMinion());
                cell.getMinion().getOwnBuffs().add(disarmBuff);
                PoisonBuff poisonBuff = new PoisonBuff();
                poisonBuff.setTurnCounter(4);
                poisonBuff.poison(cell.getMinion());
                poisonBuff.setCasting(poisonBuff, null, null, cell.getMinion());
                cell.getMinion().getOwnBuffs().add(poisonBuff);
            }
        }*/
    }

    public String getDesc() {
        return SpecialPower.TURANIAN_SPY.getMessage();
    }
}
