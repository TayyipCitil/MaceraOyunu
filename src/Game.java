import java.util.Scanner;

public abstract class Game {
    public static boolean keepGoingGame = true;
    public static Scanner input = new Scanner(System.in);
    public static int select;

    public static void story() {
        System.out.println("========Macera Diyarı========");

        //story
        System.out.println("========🏰Kale========");
        System.out.println("🤴(Kral):Bu diyarlarda kızımla evlenmeyi hak eden bir Yiğit var mı bilmiyorum");
        System.out.println("🤴(Kral):Bunun için bir yarışma düzenliyorum");
        System.out.println("🤴(Kral):Yıllar önce bir büyücü asamı,bir gladyatör kılıcımı,bir hırsız tacımı çalmıştı");
        System.out.println("🤴(Kral):Şimdi kayıp eşyalarımı bulup getiren kişi Yiğitliğni kanıtlamış olur");
        System.out.println("🤴(Kral):Ve kızım ile evlenmeye hak kazanır");
        System.out.println("🤴(Kral):Yolunuz açık olsun");
    }

    public static void start() {
        do {
            System.out.print("(1) Envanter \t(2) Konum :");
            Game.select = input.nextInt();
            if (Game.select == 1) {
                CharOfHero.getSelectChar().useTool();
            } else if (Game.select == 2) {
                System.out.println("Sağlık: " + CharOfHero.getSelectChar().getHealth());
                System.out.println("Eldeki eşya: " + CharOfHero.getSelectChar().getUseTool().getSkin());
                Location.selectLoc();
            } else {
                System.out.println("Hatalı seçim");
            }
        } while (keepGoingGame);
        winOrLose();
    }

    public static void winOrLose() {
        if (CharOfHero.getSelectChar().getHealth() <= 0) {
            //lost
            System.out.println("==========☠️Kaybettin☠️==========");
        } else {
            //win
            System.out.println("🤴(Kral):Aferim kahraman,Kızım ile evlenebilirsin.");
            System.out.println("👸(Prenses):Ne?");
            System.out.println("==========👰Kazandın🤵===========");
        }
    }
}
