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
        CharOfHero.getSelectChar().setHealth(CharOfHero.getSelectChar().getMaxHealth());
        System.out.println("Canınn yenilendi");
        CharOfHero.getSelectChar().setMoney(CharOfHero.getSelectChar().getMoney() - 5);
        System.out.println("Tedavi ücreti 5 altın kesenden alındı");
        System.out.println("Kesede kalan altın: " + CharOfHero.getSelectChar().getMoney());
    }

    public void buy() {
        System.out.println("Kesedeki altın: " + CharOfHero.getSelectChar().getMoney());
        System.out.print("(Ürün seç)\n" +
                "(1) 🏹 : " + Main.arrow.getMoney() + " altın\n" +
                "(2) 🛡️ : " + Main.shield.getMoney() + " altın\n" +
                "(3) 🗡️ : " + Main.sword.getMoney() + " altın\n" +
                "(4)Çıkış: ");
        select = input.nextInt();
        if (select == 1 || select == 2 || select == 3) {
            //ilk alet hep yumruk ve inventory lerin biri 3 diğeri 4 elemanlı bu sebeple biri select diğeri select-1
            if (store[select - 1] == null) {
                System.out.println("Bu aleti satın aldın");
            } else if (CharOfHero.getSelectChar().getMoney() < store[select - 1].getMoney()) {
                System.out.println("Yetersiz altın");
            } else {
                System.out.println("Hayırlı olsun");
                CharOfHero.getSelectChar().getInventory()[select] = store[select - 1];
                CharOfHero.getSelectChar().setMoney(CharOfHero.getSelectChar().getMoney() - store[select - 1].getMoney());
                store[select - 1] = null;
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
