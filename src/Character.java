import java.util.Scanner;

public abstract class Character extends Game {
    static Scanner input = new Scanner(System.in);
    public final String skin;
    public int maxHealthy;
    public int health;
    public int damage;
    public int money;

    Character(String skin, int maxHealth, int damage, int money) {
        this.skin = skin;
        this.maxHealthy = maxHealth;
        this.health = maxHealth;
        this.damage = damage;
        this.money = money;
    }

    public static void printHealth() {
        System.out.println("Sağlık: " + CharOfHero.selectChar.health);
    }

    public void printInventory() {
        for (int i = 0; i < Main.inventory.length; i++) {
            if (Main.inventory[i] != null) {
                System.out.print(Main.inventory[i].skin + " " + i + "\t");
            }
        }
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


}
