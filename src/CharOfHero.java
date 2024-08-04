public class CharOfHero extends Character {
    public static CharOfHero selectChar;
    private Inventory[] inventory;
    private int defance;

    CharOfHero(String skin, int health, int damage, int money, Inventory[] inventory, int defance) {
        super(skin, health, damage, money);
        this.inventory = inventory;
        this.defance = defance;
    }

    public static void selectChar() {
        do {
            System.out.print("(Karakter seç)\n" +
                    "(1)👱‍(Tüccar) Sağlık: " + Main.merchant.getHealth() + "\tGüç: " + Main.merchant.getDamage() + "\tAltın: " + Main.merchant.getMoney() + "\n" +
                    "(2)👨‍🦱(Piyade) Sağlık: " + Main.infantry.getHealth() + "\tGüç: " + Main.infantry.getDamage() + "\tAltın: " + Main.infantry.getMoney() + "\n" +
                    "(3)👨‍🦰(Okçu)   Sağlık: " + Main.archery.getHealth() + "\tGüç: " + Main.archery.getDamage() + "\tAltın: " + Main.archery.getMoney() + "\n" +
                    "seçim: ");
            select = input.nextInt();
            if (select == 1) {
                CharOfHero.selectChar = Main.merchant;
                break;
            } else if (select == 2) {
                CharOfHero.selectChar = Main.infantry;
                break;
            } else if (select == 3) {
                CharOfHero.selectChar = Main.archery;
                break;
            } else {
                System.out.println("Yanlış seçim tekrar deneyiniz");
            }
        } while (true);
    }

    public void useTool() {
        printInventory();
        System.out.print("(Alet seç): ");
        select = input.nextInt();
        if (select == 1 || select == 2 || select == 3 || select == 4) {
            if (Main.inventory[select-1] == null) {
                System.out.println("Bu slot boş");
                Main.useTool = Main.inventory[0];
            } else {
                CharOfHero.selectChar.setDamage(CharOfHero.selectChar.getDamage() - Main.useTool.getExtraDamage());
                CharOfHero.selectChar.setDefance(CharOfHero.selectChar.getDefance() - Main.useTool.getExtraDefance());
                Main.useTool = Main.inventory[select-1];
                CharOfHero.selectChar.setDefance(CharOfHero.selectChar.getDefance() + Main.useTool.getExtraDefance());
                CharOfHero.selectChar.setDamage(CharOfHero.selectChar.getDamage() + Main.useTool.getExtraDamage());
            }
        } else {
            System.out.println("Hatalı seçim");
        }
    }

    public void printInventory() {
        for (int i = 0; i < Main.inventory.length; i++) {
            if (Main.inventory[i] != null) {
                System.out.print(Main.inventory[i].getSkin() + " " + (i+1) + "\t");
            }
        }
    }

    public Inventory[] getInventory() {
        return inventory;
    }

    public void setInventory(Inventory[] inventory) {
        this.inventory = inventory;
    }

    public int getDefance() {
        return defance;
    }

    public void setDefance(int defance) {
        this.defance = defance;
    }


}
