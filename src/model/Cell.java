package model;

import model.Battles.Battle;
import model.Buffs.Buff;
import model.Cards.Card;
import model.Cards.Hero;
import model.Cards.Minion;
import model.Item.CollectableItem;
import model.Menus.Account;

import java.util.ArrayList;
import java.util.Base64;

public class Cell {
    private int x, y;
    private boolean flag;
    private Hero hero;
    private Minion minion;
    private CollectableItem collectableItem;
    private int whichPlayerIsInCell;//0 for first player  1 for second player
    private ArrayList<Buff> cellEffect = new ArrayList<>();

    public int getWhichPlayerIsInCell() {
        return whichPlayerIsInCell;
    }

    public void setWhichPlayerIsInCell(int whichPlayerIsInCell) {
        this.whichPlayerIsInCell = whichPlayerIsInCell;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean hasFlag() {
        return flag;
    }

    public CollectableItem getCollectableItem() {
        return collectableItem;
    }

    public void addCellEffect(Buff buff) {
        this.cellEffect.add(buff);
    }

    public ArrayList<Buff> getCellEffect() {
        return cellEffect;
    }

    public Cell rightCell(ArrayList<ArrayList<Cell>> map) {
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if (map.get(i).get(j).equals(this)) {
                    return map.get(i).get(j + 1);
                }
            }
        }
        return null;
    }

    public Cell leftCell(ArrayList<ArrayList<Cell>> map) {
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if (map.get(i).get(j).equals(this)) {
                    return map.get(i).get(j - 1);
                }
            }
        }
        return null;
    }

    public Cell downCell(ArrayList<ArrayList<Cell>> map) {
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if (map.get(i).get(j).equals(this)) {
                    return map.get(i + 1).get(j);
                }
            }
        }
        return null;
    }

    public Cell upCell(ArrayList<ArrayList<Cell>> map) {
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if (map.get(i).get(j).equals(this)) {
                    return map.get(i - 1).get(j);
                }
            }
        }
        return null;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero, int whichPlayerIsInCell) {
        this.hero = hero;
        this.whichPlayerIsInCell = whichPlayerIsInCell;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Minion getMinion() {
        return minion;
    }

    public void setMinion(Minion minion, int whichPlayerIsInCell) {
        this.minion = minion;
        this.whichPlayerIsInCell = whichPlayerIsInCell;
    }


    public Cell(int x, int y, boolean flag, int indexOfCollect) {
        this.x = x;
        this.y = y;
        this.flag = flag;
        if (indexOfCollect != -1) {
            this.collectableItem = CollectableItem.getCollectableItems().get(indexOfCollect).duplicate();
        }

    }

    public int manhataniDistance(int x, int y) {
        return abs(this.x - x) + abs(this.y - y);
    }

    public int abs(int x) {
        if (x > 0)
            return x;
        return -x;
    }

    public void moveCardPos(int x, int y, Battle battle) {
        int who = battle.getMap().get(x).get(y).whichPlayerIsInCell;
        if (this.hero != null) {
            battle.getMap().get(y - 1).get(x - 1).setHero(this.hero, who);
            this.hero = null;
        } else {
            battle.getMap().get(y - 1).get(x - 1).setMinion(this.minion, who);
            this.minion = null;
        }
    }

    public Cell getCellOfCard(Card card, Battle battle) {
        for (int i = 0; i < 5; i++) {
            for (Cell cell : battle.getMap().get(i)) {
                if (cell.getMinion() != null && cell.getMinion().getCardId().equals(card.getCardId()))
                    return cell;
                else if (cell.getHero() != null && cell.getHero().getCardId().equals(card.getCardId()))
                    return cell;
            }
        }
        return null;

    }
}