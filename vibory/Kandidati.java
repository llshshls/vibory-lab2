package lab2.vibory.vibory;

import java.util.Scanner;


public class Kandidati {
    private String familiya;
    private String datarozh;
    private int golosa;

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
    public Kandidati(String surname, String birthDate, int votes) {
        setFamiliya(surname);
        setDatarozh(birthDate);
        setGolosa(votes);

    }


    // Конструктор без параметров

    public Kandidati() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Фамилия кандидата: ");
        setFamiliya(sc.nextLine());
        System.out.print("Дата рождения (дд.мм.гггг): ");
        setDatarozh(sc.nextLine());
        System.out.print("Количество голосов: ");
        setGolosa(sc.nextInt());
        sc.nextLine();

    }



    @Override

    public String toString() {

        return String.format("Кандидат: %-15s | Дата рождения: %-10s | Голосов: %d", familiya, datarozh, golosa);

    }
    public String getFamiliya() {

        return familiya;

    }
    public void setFamiliya(String familiya) {
        if (familiya == null || familiya.trim().isEmpty()) {
            System.out.println("Ошибка: фамилия не может быть пустой.");
        } else {
            this.familiya = familiya.trim();
        }
    }


    public String getDatarozh() {
        return datarozh;
    }

    public void setDatarozh(String datarozh) {
        if (datarozh == null || !datarozh.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            System.out.println("Ошибка: дата должна быть в формате дд.мм.гггг.");
        } else {
            this.datarozh = datarozh;
        }

    }


    public int getGolosa() {
        return golosa;
    }


    public void setGolosa(int golosa) {
        if (golosa < 0) {
            System.out.println("Ноль голосов");
        } else {
            this.golosa = golosa;

        }

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



    public static void printCandidates() {
        if (kandidati == null || kandidati.length == 0) {
            System.out.println("Кандидитов нет");
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


        double tret = izbirateli / 3.0;
        System.out.println("максимальное количество голосов: " + maxVotes);
        System.out.println("1/3 от общего количества избирателей: " + tret);

        if (maxVotes > tret) {
            System.out.println("повторные выборы не требуются");
            System.out.println("польше 1/3 голосов " + winner);

        } else {
            System.out.println("требуется повторные выборы");

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

}