package model.Item;

import model.Battles.Battle;
import model.Buffs.HolyBuff;
import model.Buffs.PowerBuff;
import model.Cell;
import model.Menus.Account;
import view.Request;

import java.util.ArrayList;

public abstract class CollectibleItem extends Item {
    private static ArrayList<CollectibleItem> collectibleItems = new ArrayList<>();

    static {
        new BladesOfAgility();
        new ChineseSword();
        new DeathCurse();
        new Devastation();
        new DoubleEntendreArrow();
        new Elexir();
        new ManaElectuary();
        new PerpetuityElectuary();
        new RandomDamage();
    }

    public abstract void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime);

    public CollectibleItem(String name) {
        this.setName(name);
        collectibleItems.add(this);
    }

    public CollectibleItem(CollectibleItem collectibleItem) {
        this.setName(collectibleItem.getName());
    }

    public static ArrayList<CollectibleItem> getCollectibleItems() {
        return collectibleItems;
    }

    public CollectibleItem duplicate() {
        return null;
    }
}

enum CollectibleItemWork {
    DEVASTATION("Increase 6HP a force"),
    DOUBLE_ENTENDRE_ARROW("Increase 2AP of a ranged or hybrid force"),
    ELIXIR("Increase 3HP and apply 1 powerBuff and add 3AP for minion"),
    MANA_ELECTUARY("Increase mana 3units in the next turn"),
    PERPETUITY_ELECTUARY("Apply 10 holyBuff for insider accident force for 2 turn"),
    DEATH_CURSE("Give a ability to a accident minion that enter 8 hit to a random force that in the nearest distance to it"),
    RANDOM_DAMAGE("Give 2AP to a random force"),
    BLADES_OF_AGILITY("add 6AP to a random force"),
    CHINESE_SWORD("add 5AP to the melee forces");
    private String effect;

    public String getMessage() {
        return effect;
    }

    CollectibleItemWork(String effect) {
        this.effect = effect;
    }

}

class Devastation extends CollectibleItem {

    public Devastation() {
        super("Devastation");
    }

    public Devastation(Devastation devastation) {
        super(devastation);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (cell.getMinion() != null) {
            cell.getMinion().incrementHp(6);
        }
        if (cell.getHero() != null) {
            cell.getHero().incrementHp(6);
        }
    }

    public CollectibleItem duplicate() {
        Devastation devastation = new Devastation(this);
        return devastation;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.DEVASTATION.getMessage();
        return details;
    }
}

class DoubleEntendreArrow extends CollectibleItem {

    public DoubleEntendreArrow() {
        super("DoubleEntendreArrow");
    }

    public DoubleEntendreArrow(DoubleEntendreArrow doubleEntendreArrow) {
        super(doubleEntendreArrow);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (cell.getMinion() != null) {
            if (cell.getMinion().getTypeOfHit().equals("Hybrid") ||
                    cell.getMinion().getTypeOfHit().equals("Ranged"))
                cell.getMinion().incrementHp(2);
        }
        if (cell.getHero() != null) {
            if (cell.getHero().getTypeOfHit().equals("Hybrid") ||
                    cell.getHero().getTypeOfHit().equals("Ranged"))
                cell.getHero().incrementHp(6);
        }
    }

    public CollectibleItem duplicate() {
        DoubleEntendreArrow doubleEntendreArrow = new DoubleEntendreArrow(this);
        return doubleEntendreArrow;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.DOUBLE_ENTENDRE_ARROW.getMessage();
        return details;
    }
}

class Elexir extends CollectibleItem {

    public Elexir() {
        super("Elexir");
    }

    public Elexir(Elexir elexir) {
        super(elexir);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (cell.getMinion() != null) {
            elexirHelper(cell);
        } else {
            for (ArrayList<Cell> cells : battle.getMap()) {
                for (Cell cell1 : cells) {
                    if (battle.getFirstPlayer().getUserName().equals(player.getUserName())) {
                        if (cell1.getMinion() != null && battle.getFirstPlayer().getMainDeck().isContain(cell1.getMinion())) {
                            elexirHelper(cell1);
                        }
                    } else {
                        if (cell1.getMinion() != null && battle.getSecondPlayer().getMainDeck().isContain(cell1.getMinion())) {
                            elexirHelper(cell1);
                        }
                    }
                }
            }
        }
    }

    private void elexirHelper(Cell cell1) {
        cell1.getMinion().incrementAp(3);
        PowerBuff powerBuff = new PowerBuff(3, true);
        powerBuff.setCasting(powerBuff, null, null, cell1.getMinion());
        powerBuff.setTurnCounter(1);
    }

    public CollectibleItem duplicate() {
        Elexir elexir = new Elexir(this);
        return elexir;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.ELIXIR.getMessage();
        return details;
    }
}

class ManaElectuary extends CollectibleItem {

    public ManaElectuary() {
        super("ManaElectuary");
    }

    public ManaElectuary(ManaElectuary manaElectuary) {
        super(manaElectuary);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        //todo .........
    }

    public CollectibleItem duplicate() {
        ManaElectuary manaElectuary = new ManaElectuary(this);
        return manaElectuary;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.MANA_ELECTUARY.getMessage();
        return details;
    }
}

class PerpetuityElectuary extends CollectibleItem {

    public PerpetuityElectuary() {
        super("PerpetuityElectuary");
    }

    public PerpetuityElectuary(PerpetuityElectuary perpetuityElectuary) {
        super(perpetuityElectuary);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (cell.getHero() != null) {
            for (int i = 0; i < 10; i++) {
                HolyBuff holyBuff = new HolyBuff();
                holyBuff.setCasting(holyBuff, null, cell.getHero(), null);
                holyBuff.setTurnCounter(2);
                holyBuff.castBuff();
                player.getMainDeck().getHero().getOwnBuffs().add(holyBuff);
            }
        }
        if (cell.getMinion() != null) {
            for (int i = 0; i < 10; i++) {
                HolyBuff holyBuff = new HolyBuff();
                holyBuff.setCasting(holyBuff, null, null, cell.getMinion());
                holyBuff.setTurnCounter(2);
                holyBuff.castBuff();
                player.getMainDeck().getHero().getOwnBuffs().add(holyBuff);
            }
        }
    }

    public CollectibleItem duplicate() {
        PerpetuityElectuary perpetuityElectuary = new PerpetuityElectuary(this);
        return perpetuityElectuary;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.PERPETUITY_ELECTUARY.getMessage();
        return details;
    }
}

class DeathCurse extends CollectibleItem {

    public DeathCurse() {
        super("DeathCurse");
    }

    public DeathCurse(DeathCurse deathCurse) {
        super(deathCurse);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        for (ArrayList<Cell> cells : battle.getMap()) {
            for (Cell cell1 : cells) {
                if (cell1.getMinion() != null) {
                    if (activeTime == 2) {
                        Cell cell2 = nearestEnemyForces(cell);
                        if (cell2.getHero() != null)
                            cell2.getHero().decrementHp(8 - cell2.getHero().getHolyCounter());
                        if (cell2.getMinion() != null)
                            cell2.getMinion().decrementHp(8 - cell2.getHero().getHolyCounter());
                    }
                }
            }
        }
    }

    public CollectibleItem duplicate() {
        DeathCurse deathCurse = new DeathCurse(this);
        return deathCurse;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.DEATH_CURSE.getMessage();
        return details;
    }
}

class RandomDamage extends CollectibleItem {

    public RandomDamage() {
        super("RandomDamage");
    }

    public RandomDamage(RandomDamage randomDamage) {
        super(randomDamage);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (cell.getMinion() != null)
            cell.getMinion().incrementAp(2);
        if (cell.getHero() != null) {
            cell.getHero().incrementAp(2);
        }
    }

    public CollectibleItem duplicate() {
        RandomDamage randomDamage = new RandomDamage(this);
        return randomDamage;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.RANDOM_DAMAGE.getMessage();
        return details;
    }
}

class BladesOfAgility extends CollectibleItem {

    public BladesOfAgility() {
        super("BladesOfAgility");
    }

    public BladesOfAgility(BladesOfAgility bladesOfAgility) {
        super(bladesOfAgility);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (cell.getMinion() != null) {
            cell.getMinion().incrementAp(6);
        }
        if (cell.getHero() != null) {
            cell.getHero().incrementAp(6);
        }
    }

    public CollectibleItem duplicate() {
        BladesOfAgility bladesOfAgility = new BladesOfAgility(this);
        return bladesOfAgility;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.BLADES_OF_AGILITY.getMessage();
        return details;
    }
}

class ChineseSword extends CollectibleItem {

    public ChineseSword() {
        super("chineseSword");
    }

    public ChineseSword(ChineseSword chineseSword) {
        super(chineseSword);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        for (ArrayList<Cell> cells : battle.getMap()) {
            for (Cell cell1 : cells) {
                if (cell1.getMinion() != null && player.getMainDeck().isContain(cell1.getMinion())) {
                    if (cell1.getMinion().getTypeOfHit().equals("Melee")) {
                        cell1.getMinion().incrementAp(5);
                    }
                }
                if (cell1.getHero() != null && player.getMainDeck().isContain(cell1.getHero())) {
                    if (cell1.getHero().getTypeOfHit().equals("Melee")) {
                        cell1.getMinion().incrementAp(5);
                    }
                }
            }
        }
    }

    public CollectibleItem duplicate() {
        ChineseSword chineseSword = new ChineseSword(this);
        return chineseSword;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.CHINESE_SWORD.getMessage();
        return details;
    }
}
