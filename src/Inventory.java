public class Inventory {
    public static int lostPropertyNum = 0;
    public String skin;
    public int extraDamage;
    public int extraDefance;
    public int money;

    Inventory(String skin, int extraDamage, int extraDefance,int money) {
        this.skin = skin;
        this.extraDamage = extraDamage;
        this.extraDefance = extraDefance;
        this.money=money;
    }
}
