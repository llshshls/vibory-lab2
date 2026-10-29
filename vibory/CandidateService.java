package lab2.vibory.vibory;

public class CandidateService {
    public static void printCandidates() {
        Kandidati[] kandidati = Kandidati.getCandidates();
        int izbirateli = Kandidati.getIzbirateli();

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
        Kandidati[] kandidati = Kandidati.getCandidates();
        int izbirateli = Kandidati.getIzbirateli();
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
        Kandidati[] kandidati = Kandidati.getCandidates();
        int izbirateli = Kandidati.getIzbirateli();
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
        Kandidati[] kandidati = Kandidati.getCandidates();
        int izbirateli = Kandidati.getIzbirateli();

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
