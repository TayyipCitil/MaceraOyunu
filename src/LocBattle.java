public class LocBattle extends Location {
    int counterEntry;
    CharOfEnemy enemy;
    String lostProperty;

    LocBattle(CharOfEnemy enemy, String lostProperty, int counterEntry) {
        this.enemy = enemy;
        this.lostProperty = lostProperty;
        this.counterEntry = counterEntry;
    }

    public void combat() {
        do {
            if (CharOfHero.selectChar.health < 0 && this.enemy.health < 0) {
                CharOfHero.selectChar.health = 0;
                this.enemy.health = 0;
            } else if (CharOfHero.selectChar.health < 0) {
                CharOfHero.selectChar.health = 0;
            } else if (this.enemy.health < 0) {
                this.enemy.health = 0;
            }
            System.out.print(CharOfHero.selectChar.skin + "(Sen) Sağlık: " + CharOfHero.selectChar.health + "\t");
            System.out.println(this.enemy.skin + "(rakip) Sağlık: " + this.enemy.health);
            System.out.println("=====================");

            CharOfHero.selectChar.health -= this.enemy.damage;
            this.enemy.health -= CharOfHero.selectChar.damage;

            if (CharOfHero.selectChar.health <= 0 && this.enemy.health <= 0) {
                System.out.println("💀Öldün💀");
                keepGoingGame = false;
                break;
            } else if (CharOfHero.selectChar.health <= 0) {
                System.out.println("💀Öldün💀");
                keepGoingGame = false;
                break;
            } else if (this.enemy.health <= 0) {
                if (counterEntry == 0) {
                    System.out.println("Mücadeleyi kazandın ve kayıp eşya " + this.lostProperty + "buldun ");
                    Inventory.lostPropertyNum++;
                    counterEntry++;
                }
                System.out.println("Kazanılan para: " + this.enemy.money);
                CharOfHero.selectChar.money += this.enemy.money;

                break;
            }
        } while (true);

    }

}
