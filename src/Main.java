import java.util.Scanner;
public abstract class Main {
    static Inventory hand = new Inventory("👊(yumruk)", 0, 0, 0);
    static Inventory arrow = new Inventory("🏹(ok)", 7, 0, 20);
    static Inventory shield = new Inventory("🛡️(kalkan)", 0, 5, 20);
    static Inventory sword = new Inventory("🗡️(kılıç)", 5, 2, 25);

    static CharOfHero merchant = new CharOfHero("👱‍(Tüccar)", 30, 5, 50, 0);
    static CharOfHero infantry = new CharOfHero("👨‍🦱(Piyade)", 40, 6, 10, 0);
    static CharOfHero archery = new CharOfHero("👨‍🦰(Okçu)", 35, 7, 20, 0);

    static CharOfEnemy wizard = new CharOfEnemy("🧙‍♂️(Büyücü)", 20, 8, 15);
    static CharOfEnemy thief = new CharOfEnemy("👤(Hırsız)", 25, 9, 25);
    static CharOfEnemy gladiator = new CharOfEnemy("🧔(Gladyatör)", 30, 10, 30);

    static LocSafe castle = new LocSafe();
    static LocSafe store = new LocSafe();
    static LocSafe healingTent = new LocSafe();

    static LocBattle forest = new LocBattle(wizard, "🦯(asa)", 0);
    static LocBattle cave = new LocBattle(thief, "👑(taç)", 0);
    static LocBattle arena = new LocBattle(gladiator, "🗡️(kılıç)", 0);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0;
        do {
            count++;
            if (count==1) {
                CharOfHero.selectChar();
                Game.story();
                Game.start();
            }else{
                System.out.print("Tekrar denemek ister misin? evt(1) hyr(2) : ");
                int select = input.nextInt();
                if (select == 1) {
                    Game.keepGoingGame=true;
                    CharOfHero.selectChar();
                    Game.story();
                    Game.start();
                } else if (select == 2) {
                    break;
                } else {
                    System.out.println("Hatalı seçim");
                }
            }
        } while (true);
    }
}
