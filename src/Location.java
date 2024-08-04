public abstract class Location extends Game {
    static void selectLoc() {
        do {
            System.out.print("Güvenli Bölgeler(1) Macera Bölgeleri(2): ");
            select = input.nextInt();
            if (select == 1) {
                System.out.print("🏰Kale(1)\n💰Mağza(2)\n🌙Şifa Çadırı(3)\n(Çıkış)(4) :");
                select = input.nextInt();
                if (select == 1) {
                    System.out.println("=========🏰Kale========");
                    Main.castle.giveProperties();
                    break;
                } else if (select == 2) {
                    System.out.println("=========💰Mağza💰========");
                    Main.store.buy();
                    break;
                } else if (select == 3) {
                    System.out.println("=======🌙Şifa Çadırı🌙======");
                    Main.healingTent.regeneration();
                    break;
                } else if (select==4) {
                    break;
                } else {
                    System.out.println("Yanlış seçim tekrar deneyiniz");
                }
            } else if (select == 2) {
                System.out.print("🌳Orman(1)\n🦇Mağra(2)\n⚔️Arena(3)\n(Çıkış)(4): ");
                select = input.nextInt();
                if (select == 1) {
                    System.out.println("=========🌳Orman🌳========");
                    Main.forest.combat();
                    break;
                } else if (select == 2) {
                    System.out.println("========🦇Mağra🦇========");
                    Main.cave.combat();
                    break;
                } else if (select == 3) {
                    System.out.println("========⚔️Arena⚔️========");
                    Main.arena.combat();
                    break;
                } else if (select == 4) {
                    break;
                } else {
                    System.out.println("Yanlış seçim tekrar deneyiniz");
                }
            } else {
                System.out.println("Yanlış seçim tekrar deneyiniz");
            }
        }
        while (true);
    }
}
