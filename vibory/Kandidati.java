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





    public static void fillCandidates() {
        CandidateService.fillCandidates();
    }



    public static void printCandidates() {
        CandidateService.printCandidates();
    }

    public static void chekOshibki() {
        CandidateService.chekOshibki();
    }

    public static void chekNovieVibory() {
        CandidateService.chekNovieVibory();
    }

    public static void sortByVotes() {
        CandidateService.sortByVotes();
    }



}