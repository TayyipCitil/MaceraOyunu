public class Inventory {
    public static int lostPropertyNum = 0;
    private String skin;
    private int extraDamage;
    private int extraDefance;
    private int money;

    Inventory(String skin, int extraDamage, int extraDefance,int money) {
        this.skin = skin;
        this.extraDamage = extraDamage;
        this.extraDefance = extraDefance;
        this.money=money;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public int getExtraDamage() {
        return extraDamage;
    }

    public void setExtraDamage(int extraDamage) {
        this.extraDamage = extraDamage;
    }

    public int getExtraDefance() {
        return extraDefance;
    }

    public void setExtraDefance(int extraDefance) {
        this.extraDefance = extraDefance;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
