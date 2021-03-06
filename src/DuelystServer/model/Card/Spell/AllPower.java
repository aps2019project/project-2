package DuelystServer.model.Card.Spell;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import DuelystServer.model.ErrorType;
import javafx.scene.image.Image;

public class AllPower extends Spell {

    public AllPower() {
        super("AllPower", 4, 2000);
    }

    public AllPower(AllPower allPower) {
        super(allPower);
    }

    @Override
    public ErrorType castSpell(Battle battle, Cell cell, Account player) {
        /*for (ArrayList<Cell> cells : battle.getMap()) {
            for (Cell cell1 : cells) {
                if (cell1.getHero() != null) {
                    if (player.getMainDeck().isContain(cell1.getHero())) {
                        PowerBuff powerBuff = new PowerBuff(2, true);
                        powerBuff.setTurnCounter(-5);
                        powerBuff.incrementAp(cell1.getHero());
                        powerBuff.setCasting(powerBuff, null, cell1.getHero(), null);
                        cell1.getHero().getOwnBuffs().add(powerBuff);
                    }
                }
                if (cell1.getMinion() != null) {
                    if (player.getMainDeck().isContain(cell1.getMinion())) {
                        PowerBuff powerBuff = new PowerBuff(2, true);
                        powerBuff.setTurnCounter(-5);
                        powerBuff.incrementAp(cell1.getMinion());
                        powerBuff.setCasting(powerBuff, null, null, cell1.getMinion());
                        cell1.getMinion().getOwnBuffs().add(powerBuff);
                    }
                }
            }
        }*/

        return null;
    }

    public Spell duplicate() {
        AllPower allPower = new AllPower(this);
        return allPower;
    }

    @Override
    public String getDesc() {
        return SpellWork.ALL_POWER.getMessage();
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.ALL_POWER.getMessage();
        return details;
    }

}
