public class Inventory {
    public static int lostPropertyNum = 0;
    private final String skin;
    private final int extraDamage;
    private final int extraDefance;
    private final int money;

    Inventory(String skin, int extraDamage, int extraDefance,int money) {
        this.skin = skin;
        this.extraDamage = extraDamage;
        this.extraDefance = extraDefance;
        this.money=money;
    }

    public String getSkin() {
        return skin;
    }
    public int getExtraDamage() {
        return extraDamage;
    }
    public int getExtraDefance() {
        return extraDefance;
    }
    public int getMoney() {
        return money;
    }
}
