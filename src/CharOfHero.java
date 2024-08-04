public class CharOfHero extends Character implements Cloneable {
    private static CharOfHero selectChar;
    private Inventory[] inventory;
    private Inventory useTool;//kılıç çantadaysa işe yaramaz eline alcan
    private int defance;

    CharOfHero(String skin, int health, int damage, int money, int defance) {
        super(skin, health, damage, money);
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
                selectChar=new CharOfHero(Main.merchant.getSkin(),Main.merchant.getHealth(),Main.merchant.getDamage(),Main.merchant.getMoney(),Main.merchant.getDefance());
                break;
            } else if (select == 2) {
                selectChar =new CharOfHero(Main.infantry.getSkin(),Main.infantry.getHealth(),Main.infantry.getDamage(),Main.infantry.getMoney(),Main.infantry.getDefance());
                break;
            } else if (select == 3) {
                selectChar =new CharOfHero(Main.archery.getSkin(),Main.archery.getHealth(),Main.archery.getDamage(),Main.archery.getMoney(),Main.archery.getDefance());
                break;
            } else {
                System.out.println("Yanlış seçim tekrar deneyiniz");
            }
        } while (true);
        selectChar.inventory= new Inventory[]{Main.hand, null, null, null};
        selectChar.useTool=selectChar.inventory[0];
    }

    public void useTool() {
        printInventory();
        System.out.print("(Alet seç): ");
        select = input.nextInt();
        if (select == 1 || select == 2 || select == 3 || select == 4) {
            if (inventory[select-1] == null) {
                System.out.println("Bu slot boş");
                useTool = inventory[0];
            } else {
                CharOfHero.selectChar.setDamage(CharOfHero.selectChar.getDamage() - useTool.getExtraDamage());
                CharOfHero.selectChar.setDefance(CharOfHero.selectChar.getDefance() - useTool.getExtraDefance());
                useTool = inventory[select-1];
                CharOfHero.selectChar.setDefance(CharOfHero.selectChar.getDefance() + useTool.getExtraDefance());
                CharOfHero.selectChar.setDamage(CharOfHero.selectChar.getDamage() + useTool.getExtraDamage());
            }
        } else {
            System.out.println("Hatalı seçim");
        }
    }

    public void printInventory() {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                System.out.print(inventory[i].getSkin() + " " + (i+1) + "\t");
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
    public Inventory getUseTool() {
        return useTool;
    }
    public void setUseTool(Inventory useTool) {
        this.useTool = useTool;
    }

    public static CharOfHero getSelectChar() {
        return selectChar;
    }

    public static void setSelectChar(CharOfHero selectChar) {
        CharOfHero.selectChar = selectChar;
    }
}
