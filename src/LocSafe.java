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
        System.out.print("(Ürün seç)\n" +
                "(1) 🏹 : " + Main.arrow.getMoney() + " altın\n" +
                "(2) 🛡️ : " + Main.shield.getMoney() + " altın\n" +
                "(3) 🗡️ : " + Main.sword.getMoney() + " altın\n" +
                "(4)Çıkış: ");
        select = input.nextInt();
        if (select == 1 || select == 2 || select == 3) {
            //ilk alet hep yumruk ve inventory lerin biri 3 diğeri 4 elemanlı bu sebeple biri select diğeri select-1
            if (store[select-1] == null) {
                System.out.println("Bu aleti satın aldın");
            } else if (CharOfHero.selectChar.getMoney() < store[select-1].getMoney()) {
                System.out.println("Yetersiz altın");
            } else {
                System.out.println("Hayırlı olsun");
                Main.inventory[select] = store[select-1];
                CharOfHero.selectChar.setMoney(CharOfHero.selectChar.getMoney() - store[select-1].getMoney());
                store[select-1] = null;
            }
        } else if (select == 4) {
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
