package DuelystServer.messages;

import DuelystServer.model.Account;
import DuelystServer.model.Shop;

import java.util.ArrayList;
import java.util.Arrays;

public class ShopMessage extends AccountMessage {

    public static final int NUMBER_OF_CARDS = 5;
    private ArrayList<String> heroes = new ArrayList<>();
    private ArrayList<String> minions = new ArrayList<>();
    private ArrayList<String> spells = new ArrayList<>();
    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<String> notEnoughMoney = new ArrayList<>();
    private ArrayList<String> alreadyHaveThisCard = new ArrayList<>();
    private ArrayList<String> notOwnedCard = new ArrayList<>();
    private ArrayList<Boolean> heroesBought;
    private ArrayList<Boolean> minionsBought;
    private ArrayList<Boolean> spellsBought;
    private ArrayList<Boolean> itemsBought;
    private ArrayList<Boolean> heroCheck = new ArrayList<>();
    private ArrayList<Boolean> minionCheck = new ArrayList<>();
    private ArrayList<Boolean> spellCheck = new ArrayList<>();
    private ArrayList<Boolean> itemCheck = new ArrayList<>();
    private Account account;
    private static int[] numberOfHeroesInShop = new int[10];
    private static int[] numberOfMinionsInShop = new int[40];
    private static int[] numberOfSpellInShop = new int[20];
    private static int[] numberOfItemsInShop = new int[11];
    private ArrayList<String> notAvailableCard = new ArrayList<>();

    private int[] heroesInShop = new int[10];
    private int[] minionsInShop = new int[40];
    private int[] spellInShop = new int[20];
    private int[] itemsInShop = new int[11];

    public ArrayList<String> getNotOwnedCard() {
        return notOwnedCard;
    }

    public ArrayList<Boolean> getHeroCheck() {
        return heroCheck;
    }

    public ArrayList<Boolean> getMinionCheck() {
        return minionCheck;
    }

    public ArrayList<Boolean> getSpellCheck() {
        return spellCheck;
    }

    public ArrayList<Boolean> getItemCheck() {
        return itemCheck;
    }

    public ArrayList<Boolean> getHeroesBought() {
        return heroesBought;
    }

    public ArrayList<Boolean> getMinionsBought() {
        return minionsBought;
    }

    public ArrayList<Boolean> getSpellsBought() {
        return spellsBought;
    }

    public ArrayList<Boolean> getItemsBought() {
        return itemsBought;
    }

    public void setHeroesBought(ArrayList<Boolean> heroesBought) {
        this.heroesBought = heroesBought;
    }

    public void setMinionsBought(ArrayList<Boolean> minionsBought) {
        this.minionsBought = minionsBought;
    }

    public void setSpellsBought(ArrayList<Boolean> spellsBought) {
        this.spellsBought = spellsBought;
    }

    public void setItemsBought(ArrayList<Boolean> itemsBought) {
        this.itemsBought = itemsBought;
    }

    public ShopMessage(boolean signUpOrLogIn, String user, String pass, String nameOfClass, long authToken) {
        super(signUpOrLogIn, user, pass, nameOfClass, authToken);
        super.setId(43123);
    }

    public ArrayList<String> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<String> heroes) {
        this.heroes = heroes;
    }

    public ArrayList<String> getMinions() {
        return minions;
    }

    public void setMinions(ArrayList<String> minions) {
        this.minions = minions;
    }

    public ArrayList<String> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<String> spells) {
        this.spells = spells;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public static void buyAction(Account account, ShopMessage shopMessage, Shop shop) {
        int count = 0;
        for (String vBox : shopMessage.getHeroes()) {
            if (numberOfHeroesInShop[count] > 0) {
                if (shopMessage.getHeroCheck().get(count)) {
                    if (!account.getCollection().hasThisCard(vBox)) {
                        if (shop.costOfCard2(vBox) <= account.getMoney()) {
                            account.getCollection().addToCollection(vBox);
                            numberOfHeroesInShop[count]--;
                            account.incrementMoney(-shop.costOfCard2(vBox));
                            shopMessage.getHeroesBought().set(count, true);
                        } else
                            shopMessage.getNotEnoughMoney().add(vBox);
                    } else
                        shopMessage.getAlreadyHaveThisCard().add((vBox));
                }
            } else {
                shopMessage.getNotAvailableCard().add(vBox);
            }
            shopMessage.getHeroCheck().set(count, false);
            count++;
        }
        count = 0;
        for (String vBox : shopMessage.getMinions()) {
            if (numberOfMinionsInShop[count] > 0) {
                if (shopMessage.getMinionCheck().get(count)) {
                    if (!account.getCollection().hasThisCard(vBox)) {
                        if (shop.costOfCard2(vBox) <= account.getMoney()) {
                            account.getCollection().addToCollection(vBox);
                            numberOfMinionsInShop[count]--;
                            account.incrementMoney(-shop.costOfCard2(vBox));
                            shopMessage.getMinionsBought().set(count, true);
                        } else
                            shopMessage.getNotEnoughMoney().add(vBox);
                    } else
                        shopMessage.getAlreadyHaveThisCard().add(vBox);
                }
            } else {
                shopMessage.getNotAvailableCard().add(vBox);
            }
            shopMessage.getMinionCheck().set(count, false);
            count++;
        }
        count = 0;
        for (String vBox : shopMessage.getSpells()) {
            if (numberOfSpellInShop[count] > 0) {
                if (shopMessage.getSpellCheck().get(count)) {
                    if (!account.getCollection().hasThisCard(vBox)) {
                        if (shop.costOfCard2(vBox) <= account.getMoney()) {
                            account.getCollection().addToCollection(vBox);
                            numberOfSpellInShop[count]--;
                            account.incrementMoney(-shop.costOfCard2(vBox));
                            shopMessage.getSpellsBought().set(count, true);
                        } else
                            shopMessage.getNotEnoughMoney().add(vBox);
                    } else
                        shopMessage.getAlreadyHaveThisCard().add(vBox);
                }
            } else {
                shopMessage.getNotAvailableCard().add(vBox);
            }
            shopMessage.getMinionCheck().set(count, false);
            count++;
        }
        count = 0;
        for (String vBox : shopMessage.getItems()) {
            if (numberOfItemsInShop[count] > 0) {
                if (shopMessage.getItemCheck().get(count)) {
                    if (!account.getCollection().hasThisCard(vBox)) {
                        if (shop.costOfCard2(vBox) <= account.getMoney()) {
                            account.getCollection().addToCollection(vBox);
                            numberOfItemsInShop[count]--;
                            account.incrementMoney(-shop.costOfCard2(vBox));
                            shopMessage.getItemsBought().set(count, true);
                        } else
                            shopMessage.getNotEnoughMoney().add(vBox);
                    } else
                        shopMessage.getAlreadyHaveThisCard().add(vBox);
                }
            } else {
                shopMessage.getNotAvailableCard().add(vBox);
            }
            shopMessage.getItemCheck().set(count, false);
            count++;
        }
        shopMessage.setAccount(account);
        shopMessage.setHeroesInShop(numberOfHeroesInShop);
        shopMessage.setMinionsInShop(numberOfMinionsInShop);
        shopMessage.setSpellInShop(numberOfSpellInShop);
        shopMessage.setItemsInShop(numberOfItemsInShop);
    }

    public static void sellAction(Shop shop, ShopMessage shopMessage, Account account) {
        int count = 0;
        for (String vBox : shopMessage.getHeroes()) {
            if (shopMessage.getHeroCheck().get(count)) {
                if (account.getCollection().hasThisCard(vBox)) {
                    account.getCollection().removeCardFromCollection(vBox);
                    numberOfHeroesInShop[count]++;
                    account.incrementMoney(shop.costOfCard2(vBox));
                    shopMessage.getHeroesBought().set(count, false);
                } else {
                    shopMessage.getNotOwnedCard().add(vBox);
                }
                shopMessage.getHeroCheck().set(count, false);
            }
            count++;
        }
        count = 0;
        for (String vBox : shopMessage.getMinions()) {
            if (shopMessage.getMinionCheck().get(count)) {
                if (account.getCollection().hasThisCard(vBox)) {
                    account.getCollection().removeCardFromCollection(vBox);
                    numberOfMinionsInShop[count]++;
                    account.incrementMoney(shop.costOfCard2(vBox));
                    shopMessage.getMinionsBought().set(count, false);
                } else {
                    shopMessage.getNotOwnedCard().add(vBox);
                }
                shopMessage.getMinionCheck().set(count, false);
            }
            count++;
        }
        count = 0;
        for (String vBox : shopMessage.getSpells()) {
            if (shopMessage.getSpellCheck().get(count)) {
                if (account.getCollection().hasThisCard(vBox)) {
                    account.getCollection().removeCardFromCollection(vBox);
                    numberOfSpellInShop[count]++;
                    account.incrementMoney(shop.costOfCard2(vBox));
                    shopMessage.getSpellsBought().set(count, false);
                } else {
                    shopMessage.getNotOwnedCard().add(vBox);
                }
                shopMessage.getSpellCheck().set(count, false);
            }
            count++;
        }
        count = 0;
        for (String vBox : shopMessage.getItems()) {
            if (shopMessage.getItemCheck().get(count)) {
                if (account.getCollection().hasThisCard(vBox)) {
                    account.getCollection().removeCardFromCollection(vBox);
                    numberOfItemsInShop[count]++;
                    account.incrementMoney(shop.costOfCard2(vBox));
                    shopMessage.getItemsBought().set(count, false);
                } else {
                    shopMessage.getNotOwnedCard().add(vBox);
                }
                shopMessage.getItemCheck().set(count, false);
            }
            count++;
        }
        shopMessage.setAccount(account);
        shopMessage.setHeroesInShop(numberOfHeroesInShop);
        shopMessage.setMinionsInShop(numberOfMinionsInShop);
        shopMessage.setSpellInShop(numberOfSpellInShop);
        shopMessage.setItemsInShop(numberOfItemsInShop);
    }

    @Override
    public int hashCode() {
        return 2357;
    }

    public ArrayList<String> getNotEnoughMoney() {
        return notEnoughMoney;
    }

    public void setNotEnoughMoney(ArrayList<String> notEnoughMoney) {
        this.notEnoughMoney = notEnoughMoney;
    }

    public ArrayList<String> getAlreadyHaveThisCard() {
        return alreadyHaveThisCard;
    }

    public void setAlreadyHaveThisCard(ArrayList<String> alreadyHaveThisCard) {
        this.alreadyHaveThisCard = alreadyHaveThisCard;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public static void setNumberOfCardsInShop() {
        Arrays.fill(numberOfHeroesInShop, NUMBER_OF_CARDS);
        Arrays.fill(numberOfMinionsInShop, NUMBER_OF_CARDS);
        Arrays.fill(numberOfSpellInShop, NUMBER_OF_CARDS);
        Arrays.fill(numberOfItemsInShop, NUMBER_OF_CARDS);
    }

    public static int[] getNumberOfHeroesInShop() {
        return numberOfHeroesInShop;
    }

    public static int[] getNumberOfMinionsInShop() {
        return numberOfMinionsInShop;
    }

    public static int[] getNumberOfSpellInShop() {
        return numberOfSpellInShop;
    }

    public static int[] getNumberOfItemsInShop() {
        return numberOfItemsInShop;
    }

    public ArrayList<String> getNotAvailableCard() {
        return notAvailableCard;
    }

    public int[] getHeroesInShop() {
        return heroesInShop;
    }

    public void setHeroesInShop(int[] heroesInShop) {
        this.heroesInShop = heroesInShop;
    }

    public int[] getMinionsInShop() {
        return minionsInShop;
    }

    public void setMinionsInShop(int[] minionsInShop) {
        this.minionsInShop = minionsInShop;
    }

    public int[] getSpellInShop() {
        return spellInShop;
    }

    public void setSpellInShop(int[] spellInShop) {
        this.spellInShop = spellInShop;
    }

    public int[] getItemsInShop() {
        return itemsInShop;
    }

    public void setItemsInShop(int[] itemsInShop) {
        this.itemsInShop = itemsInShop;
    }
}