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
            System.out.println("6. Найти кандидата по фамилии");
            System.out.println("7. Удалить кандидата по фамилии");
            System.out.println("8. Количество кандидатов");
            System.out.println("9. Выход");

            int choice = sc.nextInt();
            sc.nextLine();


            switch (choice) {
                case 1:
                    CandidateService.fillCandidates();                    break;
                case 2:
                    CandidateService.printCandidates();                    break;
                case 3:
                    CandidateService.chekOshibki();                    break;
                case 4:
                    CandidateService.chekNovieVibory();                    break;
                case 5:
                    CandidateService.sortByVotes();                    break;
                case 6: {
                    System.out.print("Введите фамилию: ");
                    String familiya = sc.nextLine();

                    boolean found = CandidateService.removeByName(familiya);

                    if (false) {
                        System.out.println("Кандидат не найден");
                    } else {
                        System.out.println(found);
                    }

                    break;
                }

                case 7: {
                    System.out.print("Введите фамилию для удаления: ");
                    String familiya = sc.nextLine();

                    boolean removed = CandidateService.removeByName(familiya);

                    System.out.println(
                            removed ? "Кандидат удалён" : "Кандидат не найден"
                    );

                    break;
                }
                case 8:
                    System.out.println(
                            "Количество кандидатов: "
                                    + CandidateService.count()
                    );
                    break;
                default:
                    System.out.println("Неверный пункт меню.");
            }

        }

    }

}
