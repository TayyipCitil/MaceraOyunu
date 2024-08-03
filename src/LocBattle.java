public class LocBattle extends Location {
    private int counterEntry;
    private CharOfEnemy enemy;
    private String lostProperty;

    LocBattle(CharOfEnemy enemy, String lostProperty, int counterEntry) {
        this.enemy = enemy;
        this.lostProperty = lostProperty;
        this.counterEntry = counterEntry;
    }

    public void combat() {
        do {
            if (CharOfHero.selectChar.getHealth() < 0 && this.enemy.getHealth() < 0) {
                CharOfHero.selectChar.setHealth(0);
                this.enemy.setHealth(0);
            } else if (CharOfHero.selectChar.getHealth() < 0) {
                CharOfHero.selectChar.setHealth(0);
            } else if (this.enemy.getHealth() < 0) {
                this.enemy.setHealth(0);
            }
            System.out.print(CharOfHero.selectChar.getSkin() + "(Sen) Sağlık: " + CharOfHero.selectChar.getHealth() + "\t");
            System.out.println(this.enemy.getSkin() + "(rakip) Sağlık: " + this.enemy.getHealth());
            System.out.println("=====================");

            CharOfHero.selectChar.setHealth(CharOfHero.selectChar.getHealth() - this.enemy.getDamage());
            this.enemy.setHealth(this.enemy.getHealth() - CharOfHero.selectChar.getDamage());

            if (CharOfHero.selectChar.getHealth() <= 0 && this.enemy.getHealth() <= 0) {
                System.out.println("💀Öldün💀");
                keepGoingGame = false;
                break;
            } else if (CharOfHero.selectChar.getHealth() <= 0) {
                System.out.println("💀Öldün💀");
                keepGoingGame = false;
                break;
            } else if (this.enemy.getHealth() <= 0) {
                if (counterEntry == 0) {
                    System.out.println("Mücadeleyi kazandın ve kayıp eşya " + this.lostProperty + "buldun ");
                    Inventory.lostPropertyNum++;
                    counterEntry++;
                }
                System.out.println("Kazanılan para: " + this.enemy.getMoney());
                CharOfHero.selectChar.setMoney(CharOfHero.selectChar.getMoney() + this.enemy.getMoney());
                break;
            }
        } while (true);
    }
    public int getCounterEntry(){
        return counterEntry;
    }
    public void setCounterEntry(int counterEntry){
        this.counterEntry=counterEntry;
    }
    public CharOfEnemy getEnemy(){
        return enemy;
    }
    public void setEnemy(CharOfEnemy enemy){
        this.enemy=enemy;
    }
    public String getLostProperty(){
        return lostProperty;
    }
    public void setLostProperty(String lostProperty){
        this.lostProperty=lostProperty;
    }

}
