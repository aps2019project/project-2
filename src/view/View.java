package view;

import model.*;
import model.Battles.Battle;
import model.Cards.Card;
import model.Cards.Hero;
import model.Cards.Minion;
import model.Cards.Spell;
import model.Item.UsableItem;
import model.Menus.Account;
import model.Menus.Collection;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Base64;

public class View {
    private static final View VIEW = new View();

    private View() {
    }

    public static View getInstance() {
        return VIEW;
    }

    public void printError(ErrorType error) {
        if (error == null) return;
        System.out.println(error.getMessage());
    }

    public void printLeaderBoard() {
        for (int i = 0; i < Account.getAllUser().size(); i++) {
            System.out.println((i + 1) + "- UserName : " + Account.getAllUser().get(i).getUserName() + "- Wins : " + Account.getAllUser().get(i).getWins());
        }
    }

    public void printDeckValidation(String name) {
        System.out.println(name + " is a valid deck.");
    }

    public void printObjectId(ArrayList<Long> id) {
        for (int i = 0; i < id.size(); i++) {
            System.out.println((i + 1) + " - " + id.get(i));
        }
    }

    public void showCollection(Collection collection) {
        int index = 1;
        System.out.print("Heroes :\n");
        for (Hero hero : collection.getHeroes()) {
            System.out.println("\t" + index + " : " + hero.showDetails() + " - Sell Cost : " + hero.getCostOfBuy());
            index++;
        }
        index = 1;
        System.out.print("Items :\n");
        for (UsableItem usableItem : collection.getUsableItems()) {
            System.out.println("\t" + index + " : " + usableItem.showDetails() + " - Sell Cost : " + usableItem.getCostOfBuy());
            index++;
        }
        index = 1;
        System.out.print("Cards :\n");
        for (Spell spell : collection.getSpells()) {
            System.out.println("\t" + index + " : " + spell.showDetails() + " - Sell Cost : " + spell.getCostOfBuy());
            index++;
        }
        for (Minion minion : collection.getMinions()) {
            System.out.println("\t" + index + " : " + minion.showDetails() + " - Sell Cost : " + minion.getCostOfBuy());
            index++;
        }
    }

    public void printDeckDetails(Deck deck, int counter, boolean allOrNot) {
        if (allOrNot)
            System.out.println(counter + " : " + deck.getName());

        if (deck.getHero() != null)
            System.out.println("Heroes :\n1 : " + deck.getHero().showDetails());
        else
            System.out.println("Heroes :");

        if (deck.getUsableItem() == null)
            System.out.println("Items :");
        else
            System.out.println("Items :\n1 : " + deck.getUsableItem().showDetails());
        System.out.print("Cards :\n");
        int index = 1;
        for (Spell spell : deck.getSpells()) {
            System.out.println("\t" + index + " : " + spell.showDetails());
            index++;
        }
        for (Minion minion : deck.getMinions()) {
            System.out.println("\t" + index + " : " + minion.showDetails());
            index += 1;
        }
    }

    public void showShop() {
        int index = 1;
        System.out.println("Heroes :");
        for (Hero hero : Hero.getHeroes()) {
            String heroInfo = hero.showDetails() + " - Buy Cost : " + hero.getCostOfBuy();
            System.out.print(index + " : ");
            System.out.println(heroInfo);
            index++;
        }
        index = 1;
        System.out.println("Items :");
        for (UsableItem usableItem : UsableItem.getUsableItems()) {
            String itemInfo = usableItem.showDetails() + " - Buy Cost : " + usableItem.getCostOfBuy();
            System.out.print(index + " : ");
            System.out.println(itemInfo);
            index += 1;
        }
        index = 1;
        System.out.println("Cards :");
        for (Minion minion : Minion.getMinions()) {
            String minionInfo = minion.showDetails();
            System.out.print(index + " : ");
            System.out.println(minionInfo + " - Buy Cost : " + minion.getCostOfBuy());
            index++;
        }
        for (Spell spell : Spell.getSpells()) {
            String spellInfo = spell.showDetails();
            System.out.print(index + " : ");
            System.out.println(spellInfo + " - Buy Cost : " + spell.getCostOfBuy());
            index += 1;
        }
    }

    public void showCollectionMenu() {
        String helpstr = "1 : Exit\n" +
                "2 : Show\n" +
                "3 : Search\n" +
                "4 : Save\n" +
                "5 : Create Deck\n" +
                "6 : Delete Deck\n" +
                "7 : Add Card To Deck\n" +
                "8 : Remove Card From Deck\n" +
                "9 : Validate Deck\n" +
                "10 : Select Deck\n" +
                "11 : Show All Decks\n" +
                "12 : Show Deck\n" +
                "13 : Help";
        System.out.println(helpstr);
    }

    public void showShopMenu() {
        String helpstr = "1 : Exit\n" +
                "2 : Show Collection\n" +
                "3 : Search\n" +
                "4 : Search Collection\n" +
                "5 : Buy\n" +
                "6 : Sell\n" +
                "7 : Show\n" +
                "8 : Help";
        System.out.println(helpstr);
    }

    public void showMainMenu() {
        String helpstr = "1 : Collection\n" +
                "2 : Shop\n" +
                "3 : Battle\n" +
                "4 : Log Out\n" +
                "5 : Help";
        System.out.println(helpstr);
    }

    public void showAccountMenu() {
        String helpstr = "1 : create account [your username]\n" +
                "2 : login [your username]\n" +
                "3 : show leaderboard\n" +
                "4 : Search Collection\n" +
                "5 : save\n" +
                "6 : logout\n" +
                "7 : help";
        System.out.println(helpstr);
    }

    public void showGraveYardMenu() {
        String helpstr = "1 : show info [cardId]\n" +
                "2 : show cards\n" +
                "3 : exit";
        System.out.println(helpstr);

    }
    public void showCollectableMenu(){
        String helpstr = "1 : show info\n" +
                "2 : Use [location x, y]\n" +
                "3 : exit";
        System.out.println(helpstr);
    }

    public void showDetailedInfoHeroMode(Battle battle) {
        System.out.println("Hero of first Player : " + battle.getFirstPlayerDeck().getHero().getName() + " - HP : " + battle.getFirstPlayerDeck().getHero().getHp());
        System.out.println("Hero of Second Player : " + battle.getSecondPlayerDeck().getHero().getName() + " - HP : " + battle.getSecondPlayerDeck().getHero().getHp());
    }

    public void showDetailedInfoOneFlagMode(Battle battle) {

    }

    public void showDetailedInfoFlagsMode(Battle battle) {

    }

    public void showSingleOrMultiMenu() {
        String helpstr = "1 : Single Player\n" +
                "2 : Multi player\n";
        System.out.println(helpstr);
    }

    public void showGameInfo(Battle battle) {
        System.out.println("Mana of player " + battle.getFirstPlayer().getUserName() + " : " + battle.getFirstPlayer().getMana());
        System.out.println("Mana of player " + battle.getSecondPlayer().getUserName() + " : " + battle.getSecondPlayer().getMana());
    }

    public void showMinions(Battle battle, boolean reversed) {
        int whichPlayer;
        if ((battle.getTurn() % 2 == 0 && !reversed) || (battle.getTurn() % 2 == 1 && reversed)) {
            whichPlayer = 2;
        } else
            whichPlayer = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (whichPlayer == 1 && battle.getMap().get(i).get(j).getMinion() != null) {
                    if (battle.getMap().get(i).get(j).getMinion().getCardId().contains(battle.getFirstPlayer().getUserName())) {
                        printMinionInfo(battle, i, j);
                    }

                } else if (whichPlayer == 2 && battle.getMap().get(i).get(j).getMinion() != null) {
                    if (battle.getMap().get(i).get(j).getMinion().getCardId().contains(battle.getSecondPlayer().getUserName())) {
                        printMinionInfo(battle, i, j);
                    }

                }
                else if  (whichPlayer == 2 && battle.getMap().get(i).get(j).getHero() != null) {
                    if (battle.getMap().get(i).get(j).getHero().getCardId().contains(battle.getSecondPlayer().getUserName())) {
                        printHeroInfo(battle, i, j);

                    }

                }
                else if  (whichPlayer == 1 && battle.getMap().get(i).get(j).getHero() != null) {
                    if (battle.getMap().get(i).get(j).getHero().getCardId().contains(battle.getFirstPlayer().getUserName())) {
                        printHeroInfo(battle, i, j);
                    }

                }
            }
        }
    }

    public void printMinionInfo(Battle battle, int i, int j) {
        System.out.print(battle.getMap().get(i).get(j).getMinion().getCardId() + " : " + battle.getMap().get(i).get(j).getMinion().getName() + ", ");
        System.out.print("health : " + battle.getMap().get(i).get(j).getMinion().getHp() + ", location : [(" + (i + 1) + "," + (j + 1) + ")], power : " +
                battle.getMap().get(i).get(j).getMinion().getAp());
    }
    public void printHeroInfo(Battle battle, int i, int j) {
        System.out.print(battle.getMap().get(i).get(j).getHero().getCardId() + " : " + battle.getMap().get(i).get(j).getHero().getName() + ", ");
        System.out.println("health : " + battle.getMap().get(i).get(j).getHero().getHp() + ", location : [(" + (i + 1) + "," + (j + 1) + ")], power : " +
                battle.getMap().get(i).get(j).getHero().getAp());
    }
    public void showBattleMenu() {
        String helpstr = "1 : Game Info\n" +
                "2 : Show my minions\n" +
                "3 : Show opponent minion\n" +
                "4 : Show card Info\n" +
                "5 : Select [cardId]\n" +
                "if you select a card :\n" +
                "\t1 : Move To\n" +
                "\t2 : Attack\n" +
                "6 : Attack combo\n" +
                "7 : Use Special power\n" +
                "8 : Show hand\n" +
                "9 : Insert in\n" +
                "10 : End turn\n" +
                "11 : Show collectables\n" +
                "12 : Select [collectableId] " +
                "if you select an item :\n" +
                "\t1 : Show Info\n" +
                "\t2 : Use\n" +
                "13 : Search\n" +
                "14 : Show next Card\n" +
                "15 : Enter graveyard\n" +
                "if you enter graveyard :\n" +
                "\t1 : Show Info[cardId]\n" +
                "\t2 : Show Cards\n" +
                "\t3: : Exit\n" +
                "16 : Help\n" +//todo different work of help
                "17 : End Game\n" +
                "18 : Exit\n" +
                "19 : Show menu";
        System.out.println(helpstr);
    }

    public void showSingleMatchMenu() {
        String helpstr = "1 : Story\n" +
                "2 : custom game\n";
        System.out.println(helpstr);
    }

    public void showModeList() {

    }

    public void showWholePlayers() {
        for (Account account : Account.getAllUser()
        ) {
            if (account.getUserName().equals(Account.getLoginAccount().getUserName()))
                continue;
            System.out.println(account.getUserName());
        }
    }

    public void printMinionInfoInGame(Minion minion) {
        System.out.println("Minion:\n" + "Name: " + minion.getName());
        System.out.println("HP: " + minion.getHp() + " AP: " + minion.getAp() + " MP: " + minion.getCostToUse());
        if (minion.getRange() == 0)
            System.out.println("Range: Melee");
        else if (minion.getRange() == 1)
            System.out.println("Range: Ranged");
        else
            System.out.println("Range: Hybrid");

        System.out.print("Combo-ability: ");
        if (minion.getTimeOfActivationOfSpecialPower() == 2)
            System.out.println("Yes");
        else
            System.out.println("No");
        System.out.println("Cost: " + minion.getCostOfBuy());
        System.out.println("Desc: " + minion.getDesc());
    }

    public void printHeroInfoInGame(Hero hero) {
        System.out.println("Hero:\n" + "Name: " + hero.getName());
        System.out.println("Cost: " + hero.getCostOfBuy());
        System.out.println("Desc: " + hero.getDesc());

    }

    public void printSpellInfoInGame(Spell spell) {
        System.out.println("Spell:\n" + "Name: " + spell.getName());
        System.out.println(" MP: " + spell.getCostToUse());
        System.out.println("Cost: " + spell.getCostOfBuy());
        System.out.println("Desc: " + spell.getDesc());
    }
}
