package model.Cards.Minion;

import model.Battles.Battle;
import model.Buffs.PowerBuff;
import model.Cell;
import model.Menus.Account;
import view.Request;

public class Elf extends Minion {
    public Elf() {
        super("Elf", 4, 10, 500, 5, 1, 4);
        super.setTimeOfActivationOfSpecialPower(4);
    }

    public Elf(Elf elf) {
        super(elf);
    }

    public Minion duplicate() {
        Elf elf = new Elf(this);
        return elf;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : " + SpecialPower.ELF.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (activeTime == 1) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 9; j++) {
                    if (battle.getMap().get(i).get(j).getMinion() != null) {
                        if (player.getMainDeck().isContain(battle.getMap().get(i).get(j).getMinion())) {
                            PowerBuff powerBuff = new PowerBuff(1, true);
                            powerBuff.setTurnCounter(-4);
                            powerBuff.incrementAp(battle.getMap().get(i).get(j).getMinion());
                            powerBuff.setCasting(powerBuff, null, null, battle.getMap().get(i).get(j).getMinion());
                            battle.getMap().get(i).get(j).getMinion().getOwnBuffs().add(powerBuff);
                        }
                    }
                }
            }
        }
    }

    public String getDesc() {
        return SpecialPower.ELF.getMessage();
    }
}