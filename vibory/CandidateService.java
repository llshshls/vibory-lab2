package lab2.vibory.vibory;

import java.util.Scanner;

public class CandidateService {
    public static void printCandidates() {


        if (kandidati == null || kandidati.length == 0) {
            System.out.println("Кандидатов нет");
            return;
        }

        System.out.println("Список кандидатов:");

        for (Kandidati c : kandidati) {
            System.out.println(c);
        }

        System.out.println("Всего избирателей: " + izbirateli);
    }

    public static void chekOshibki() {

        int sum = 0;
        for (Kandidati c : kandidati) {
            sum += c.getGolosa();
        }
        System.out.println("Всего голосов кандидатов: " + sum);
        System.out.println("Общее количество избирателей: " + izbirateli);
        if (sum > izbirateli) {

            System.out.println("голосов больше чем избирателей");
        } else {
            System.out.println("все норм");

        }

    }

    public static void chekNovieVibory() {

        int maxVotes = 0;
        String winner = "";

        for (Kandidati c : kandidati) {
            if (c.getGolosa() > maxVotes) {
                maxVotes = c.getGolosa();
                winner = c.getFamiliya();

            }

        }

    }

    public static void sortByVotes() {

        for (int i = 0; i < kandidati.length - 1; i++) {
            for (int j = 0; j < kandidati.length - 1 - i; j++) {
                if (kandidati[j].getGolosa() < kandidati[j + 1].getGolosa()) {
                    Kandidati temp = kandidati[j];
                    kandidati[j] = kandidati[j + 1];
                    kandidati[j + 1] = temp;
                }

            }

        }

        printCandidates();
    }
    public static void fillCandidates() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите общее количество избирателей: ");
        int voters = sc.nextInt();
        sc.nextLine();
        setIzbirateli(voters);
        System.out.print("Введите количество кандидатов: ");
        int n = sc.nextInt();
        sc.nextLine();
        if (n <= 0) {

            System.out.println("Количество кандидатов должно быть больше 0.");

            return;

        }


        kandidati = new Kandidati[n];

        System.out.println("Введите данные кандидатов:");
        for (int i = 0; i < kandidati.length; i++) {
            System.out.println("Кандидат " + (i + 1));
            kandidati[i] = new Kandidati();

        }

    }

    private static Kandidati[] kandidati;
    private static int izbirateli;
    static {

        kandidati = new Kandidati[] {

                new Kandidati("аоаоао", "15.03.1980", 120),

                new Kandidati("ОАОоао", "22.07.1978", 95),

                new Kandidati("УОАОУоа", "10.11.1985", 60)

        };

        izbirateli = 300;

    }
    public static int getIzbirateli() {
        return izbirateli;

    }
    public static void setIzbirateli(int value) {
        if (value <= 0) {
            System.out.println("Ноль избирателей");
        } else {
            izbirateli = value;
        }

    }

    public static boolean removeByName(String familiya) {
        if (familiya == null) {
            return false;
        }

        for (int i = 0; i < kandidati.length; i++) {
            if (kandidati[i].getFamiliya()
                    .equalsIgnoreCase(familiya.trim())) {

                Kandidati[] result =
                        new Kandidati[kandidati.length - 1];

                System.arraycopy(
                        kandidati, 0,
                        result, 0,
                        i
                );

                System.arraycopy(
                        kandidati, i + 1,
                        result, i,
                        kandidati.length - i - 1
                );

                kandidati = result;
                return true;
            }
        }

        return false;
    }
    public static int count() {
        return kandidati.length;
    }


}
