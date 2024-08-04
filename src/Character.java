public abstract class Character extends Game {
    private final String skin;
    private int maxHealth;
    private int health;
    private int damage;
    private int money;

    Character(String skin, int maxHealth, int damage, int money) {
        this.skin = skin;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.damage = damage;
        this.money = money;
    }
    public String getSkin(){
        return skin;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
    public void setMaxHealth(int maxHealth){
        this.maxHealth=maxHealth;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        if(health<0){
            health=0;
        }
        this.health=health;
    }
    public int getDamage(){
        return damage;
    }
    public void setDamage(int damage){
        this.damage=damage;
    }
    public int getMoney(){
        return money;
    }
    public void setMoney(int money){
        this.money=money;
    }

}
