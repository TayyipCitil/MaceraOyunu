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


}
