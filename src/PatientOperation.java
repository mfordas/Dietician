import java.util.List;
import java.util.Scanner;

public interface PatientOperation {
    void patientOperation(List<Patient> patientList, DieticianDatabase db);
    default String readNextPatient() {
        return new Scanner(System.in).nextLine();
    }

    int ADD = 1;
    int SHOW_LIST = 2;
    int SHOW_ONE = 3;
    int REMOVE = 4;
    int OLDEST_YOUNGEST = 5;
    int EXIT = 0;


}
