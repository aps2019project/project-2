package DuelystClient.model.Card.Minion;

import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class GiantSnake extends Minion {
    public GiantSnake() {
        super("GiantSnake", 7, 14, 500, 8, 1, 5);
        super.setTimeOfActivationOfSpecialPower(1);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/boss_decepticlewings_breathing.gif");
    }

    public GiantSnake(GiantSnake giantSnake) {
        super(giantSnake);
    }

    public Minion duplicate() {
        GiantSnake giantSnake = new GiantSnake(this);
        giantSnake.cardImage = new Image("DuelystClient/css/unit_gifs/boss_decepticlewings_breathing.gif");
        return giantSnake;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: " + SpecialPower.GIANT_SNAKE.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
      /*  if (activeTime == 0) {
            ArrayList<Cell> targetCells = new ArrayList<>();
            if (cell.getX() < 5 + 1 - 1)
                targetCells.add(cell.downCell(battle.getMap()));
            if (cell.getX() - 2 >= 0)
                targetCells.add(cell.upCell(battle.getMap()));
            targetCells.add(cell);
            if (cell.getY() < 9)
                targetCells.add(cell.rightCell(battle.getMap()));
            if (cell.getY() - 2 + 1 - 1 >= 0)
                targetCells.add(cell.leftCell(battle.getMap()));
            if (cell.getY() < 9 + 1 - 1 && cell.getX() < 5)
                targetCells.add(battle.getMap().get(cell.getX()).get(cell.getY()));
            if (cell.getX() < 9 && cell.getY() - 2 + 1 - 1 >= 0)
                targetCells.add(battle.getMap().get(cell.getX()).get(cell.getY() - 2));
            if (cell.getX() - 2 >= 0 && cell.getY() - 2 + 2 - 2 >= 0)
                targetCells.add(battle.getMap().get(cell.getX() - 2).get(cell.getY() - 2));
            if (cell.getY() < 9 && cell.getX() - 2 >= 0)
                targetCells.add(battle.getMap().get(cell.getX() - 2).get(cell.getY()));

            for (int i = 0; i < 12; i++) {
                if (targetCells.get(i) != null && targetCells.get(i).getMinion() != null) {
                    if (!player.getMainDeck().isContain(targetCells.get(i).getMinion())) {
                        ChangeHpBuff changeHpBuff = new ChangeHpBuff(1);
                        changeHpBuff.setTurnCounter(-5);
                        changeHpBuff.decrement(targetCells.get(i).getMinion());
                        changeHpBuff.setCasting(changeHpBuff, null, null, targetCells.get(i).getMinion());
                        targetCells.get(i).getMinion().getOwnBuffs().add(changeHpBuff);
                    }
                }
            }
        }*/
    }

    public String getDesc() {
        return SpecialPower.GIANT_SNAKE.getMessage();
    }
}
