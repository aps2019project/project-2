package DuelystClient.model.Card.Minion;
import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class PersianGladiator extends Minion {
    public PersianGladiator() {
        super("PersianGladiator", 6, 24, 600, 9, 0, 0);
        super.setTimeOfActivationOfSpecialPower(0);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/boss_manaman_breathing.gif");
    }

    public PersianGladiator(PersianGladiator persianGladiator) {
        super(persianGladiator);
    }

    public Minion duplicate() {
        PersianGladiator persianGladiator = new PersianGladiator(this);
        persianGladiator.cardImage = new Image("DuelystClient/css/unit_gifs/boss_manaman_breathing.gif");
        return persianGladiator;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : " + SpecialPower.PERSIAN_GLADIATOR.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
      /*  if (activeTime == 3) {
            if (cell.getHero() != null) {
                cell.getHero().decrementHp(this.getNumberOfAttacks() + 5 - cell.getHero().getHolyCounter());
            } else if (cell.getMinion() != null) {
                cell.getMinion().decrementHp(this.getNumberOfAttacks() + 5 - cell.getMinion().getHolyCounter());
            }
        }*/
    }

    public String getDesc() {
        return SpecialPower.PERSIAN_GLADIATOR.getMessage();
    }
}
