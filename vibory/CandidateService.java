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
}
