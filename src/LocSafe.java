import java.util.Scanner;

public class LocSafe extends Location {
    static Inventory[] store = {Main.arrow, Main.shield, Main.sword};

    public void giveProperties() {
        if (Inventory.lostPropertyNum == 3) {
            keepGoingGame = false;
        } else {
            System.out.println("🤴(Kral):Tüm eşyaları toplamadan gelme!");
        }
    }

    public void regeneration() {
        CharOfHero.selectChar.health = CharOfHero.selectChar.maxHealthy;
        System.out.println("Canınn yenilendi");
    }

    public void buy() {
        System.out.println("Kesedeki altın: "+ CharOfHero.selectChar.money);
        int selectTool;
        Scanner input = new Scanner(System.in);
        System.out.println("(Ürün seç)\n(0) 🏹 : 20 altın\n(1) 🛡️ : 15 altın\n(2) 🗡️ : 25 altın\n Çıkış(3): ");
        selectTool = input.nextInt();
        if (selectTool == 0 || selectTool == 1 || selectTool == 2) {
            if (store[selectTool]==null) {
                System.out.println("Bu aleti satın aldın");
            } else if (CharOfHero.selectChar.money < store[selectTool].money) {
                System.out.println("Yetersiz altın");
            } else {
                System.out.println("Hayırlı olsun");
                Main.inventory[selectTool+1] = store[selectTool];//ilk alet hep yumruk olsundiye +1 ekledim
                CharOfHero.selectChar.money -= store[selectTool].money;
                store[selectTool] = null;
            }
        } else if (selectTool == 3) {
            System.out.println("Yine bekleriz");
        } else {
            System.out.println("Yanlış seçim");
        }
    }


}
