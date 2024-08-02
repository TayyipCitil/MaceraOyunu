import java.util.Scanner;

public abstract class Game {
    public static boolean keepGoingGame = true;

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
            Scanner input = new Scanner(System.in);
            System.out.print("(1) Envanter \t(2) Konum :");
            int select = input.nextInt();
            if (select == 1) {
                CharOfHero.selectChar.useTool();
            } else if (select == 2) {
                System.out.println("Sağlık: " + CharOfHero.selectChar.health);
                System.out.println("Eldeki eşya: " + Main.useTool.skin);
                Location.selectLoc();
            } else {
                System.out.println("Hatalı seçim");
            }
        } while (keepGoingGame);
        winOrLose();
    }

    public static void winOrLose() {
        if (CharOfHero.selectChar.health <= 0) {
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
