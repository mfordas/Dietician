import java.util.List;
import java.util.Scanner;

public interface TerminOperation {
    void terminOperation(List<Termin> terminList, DieticianDatabase db);

    default String readNextTermin() {
        return new Scanner(System.in).nextLine();
    }

    default String readPatientId() { return new Scanner(System.in).nextLine(); }

    int NEW_VISIT = 6;
    int TERMIN_LIST = 7;
    int REMOVE_VISIT = 8;
}
