public abstract class Character extends Game {
    public final String skin;
    public int maxHealthy;
    public int health;
    public int damage;
    public int money;

    Character(String skin, int maxHealth, int damage, int money) {
        this.skin = skin;
        this.maxHealthy = maxHealth;
        this.health = maxHealth;
        this.damage = damage;
        this.money = money;
    }
    public void printCharacter(){

    }

}
