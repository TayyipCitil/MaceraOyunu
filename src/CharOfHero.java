import java.util.Scanner;

public class CharOfHero extends Character {
    static Scanner input = new Scanner(System.in);
    static CharOfHero selectChar;
    public Inventory[] inventories;
    public int defance;

    CharOfHero(Inventory[] inventories, int defance, String skin, int health, int damage, int money) {
        super(skin, health, damage, money);
        this.inventories = inventories;
        this.defance = defance;
    }

    public static void selectChar() {
        int select;
        do {
            System.out.print("(Karakter seç)\n(1)👱‍(Tüccar)\n(2)👨‍🦱(Piyade)\n(3)👨‍🦰(Okçu)\nseçim: ");
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
                Main.useTool = Main.inventory[0];
            } else {
                CharOfHero.selectChar.damage -= Main.useTool.extraDefance;
                CharOfHero.selectChar.damage -= Main.useTool.extraDamage;
                Main.useTool = Main.inventory[selectTool];
                CharOfHero.selectChar.defance += Main.useTool.extraDefance;
                CharOfHero.selectChar.damage += Main.useTool.extraDamage;
            }

        } else {
            System.out.println("Hatalı seçim");
        }
    }
    public void printInventory() {
        for (int i = 0; i < Main.inventory.length; i++) {
            if (Main.inventory[i] != null) {
                System.out.print(Main.inventory[i].skin + " " + i + "\t");
            }
        }
    }


}
