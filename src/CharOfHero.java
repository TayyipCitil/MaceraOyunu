import java.util.Scanner;

public class CharOfHero extends Character {
    public static Scanner input = new Scanner(System.in);
    public static CharOfHero selectChar;
    private Inventory[] inventory;
    private int defance;

    CharOfHero(String skin, int health, int damage, int money, Inventory[] inventory, int defance) {
        super(skin, health, damage, money);
        this.inventory = inventory;
        this.defance = defance;
    }

    public static void selectChar() {
        int select;
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
        int selectTool = input.nextInt();
        if (selectTool == 0 || selectTool == 1 || selectTool == 2 || selectTool == 3) {
            if (Main.inventory[selectTool] == null) {
                System.out.println("Bu slot boş");
                Main.useTool = Main.inventory[0];
            } else {
                CharOfHero.selectChar.setDamage(CharOfHero.selectChar.getDamage() - Main.useTool.getExtraDamage());
                CharOfHero.selectChar.setDefance(CharOfHero.selectChar.getDefance() - Main.useTool.getExtraDefance());
                Main.useTool = Main.inventory[selectTool];
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
                System.out.print(Main.inventory[i].getSkin() + " " + i + "\t");
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
