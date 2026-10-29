package lab2.vibory.vibory;


import java.util.Scanner;


public class Main {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("1. Заполнить массив");
            System.out.println("2. Распечатать кандидатов");
            System.out.println("3. Проверить наличие нарушений");
            System.out.println("4. Проверить необходимость повторных выборов");
            System.out.println("5. Упорядочить кандидатов по голосам");
            System.out.println("6. Выход");
            System.out.print("Выберите пункт меню: ");

            int choice = sc.nextInt();


            switch (choice) {
                case 1:
                    Kandidati.fillCandidates();
                    break;
                case 2:
                    Kandidati.printCandidates();
                    break;
                case 3:
                    Kandidati.chekOshibki();
                    break;
                case 4:
                    Kandidati.chekNovieVibory();
                    break;
                case 5:
                    Kandidati.sortByVotes();
                    break;
                case 6:
                    System.out.println("ок");
                    return;
                default:
                    System.out.println("Неверный пункт меню.");
            }

        }

    }

}
