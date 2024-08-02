public abstract class Character extends Game {
    public final String skin;
    public int maxHealth;
    public int health;
    public int damage;
    public int money;

    Character(String skin, int maxHealth, int damage, int money) {
        this.skin = skin;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.damage = damage;
        this.money = money;
    }
}
