import java.util.Scanner;

public class LocSafe extends Location {
    private static Inventory[] store = {Main.arrow, Main.shield, Main.sword};

    public void giveProperties() {
        if (Inventory.lostPropertyNum == 3) {
            keepGoingGame = false;
        } else {
            System.out.println("🤴(Kral):Tüm eşyaları toplamadan gelme!");
        }
    }

    public void regeneration() {
        CharOfHero.selectChar.setHealth(CharOfHero.selectChar.getMaxHealth());
        System.out.println("Canınn yenilendi");
    }

    public void buy() {
        System.out.println("Kesedeki altın: " + CharOfHero.selectChar.getMoney());
        int selectTool;
        Scanner input = new Scanner(System.in);
        System.out.print("(Ürün seç)\n" +
                "(0) 🏹 : " + Main.arrow.getMoney() + " altın\n" +
                "(1) 🛡️ : " + Main.shield.getMoney() + " altın\n" +
                "(2) 🗡️ : " + Main.sword.getMoney() + " altın\n" +
                "(3)Çıkış: ");
        selectTool = input.nextInt();
        if (selectTool == 0 || selectTool == 1 || selectTool == 2) {
            if (store[selectTool] == null) {
                System.out.println("Bu aleti satın aldın");
            } else if (CharOfHero.selectChar.getMoney() < store[selectTool].getMoney()) {
                System.out.println("Yetersiz altın");
            } else {
                System.out.println("Hayırlı olsun");
                Main.inventory[selectTool + 1] = store[selectTool];//ilk alet hep yumruk olsundiye +1 ekledim
                CharOfHero.selectChar.setMoney(CharOfHero.selectChar.getMoney() - store[selectTool].getMoney());
                store[selectTool] = null;
            }
        } else if (selectTool == 3) {
            System.out.println("Yine bekleriz");
        } else {
            System.out.println("Yanlış seçim");
        }
    }

    public Inventory[] getStore() {
        return store;
    }

    public void setStore(Inventory[] store) {
        LocSafe.store = store;
    }
}
