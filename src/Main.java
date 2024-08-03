public abstract class Main {
    static Inventory hand=new Inventory("👊(yumruk)",0,0,0);
    static Inventory arrow=new Inventory("🏹(ok)",5,0,20);
    static Inventory shield=new Inventory("🛡️(kalkan)",0,5,20);
    static Inventory sword=new Inventory("🗡️(kılıç)",7,2,25);
    static Inventory[] inventory ={hand,null,null,null};
    static Inventory useTool=inventory[0];//kılıç çantadaysa işe yaramaz eline alcan

    static CharOfHero merchant = new CharOfHero("👱‍(Tüccar)", 30, 5, 50,inventory,2);
    static CharOfHero infantry = new CharOfHero("👨‍🦱(Piyade)", 40, 6, 10,inventory,0);
    static CharOfHero archery = new CharOfHero("👨‍🦰(Okçu)", 35, 7, 20,inventory,0);

    static CharOfEnemy wizard=new CharOfEnemy("🧙‍♂️(Büyücü)",20,8,15);
    static CharOfEnemy thief=new CharOfEnemy("👤(Hırsız)",25,9,25);
    static CharOfEnemy gladiator=new CharOfEnemy("🧔(Gladyatör)",30,10,30);

    static LocSafe castle = new LocSafe();
    static LocSafe store = new LocSafe();
    static LocSafe healingTent=new LocSafe();

    static LocBattle forest = new LocBattle(wizard,"🦯(asa)",0);
    static LocBattle cave = new LocBattle(thief,"👑(taç)",0);
    static LocBattle arena = new LocBattle(gladiator,"🗡️(kılıç)",0);

    public static void main(String[] args) {
        CharOfHero.selectChar();
        Game.story();
        Game.start();
    }
}
