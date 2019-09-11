import java.io.IOException;
import java.util.*;

public class Dietician {

    public static void main(String[] args) throws IOException {
        DieticianDatabase db = new DieticianDatabase();

        List<Patient> patientList = new ArrayList<>();

        List<Termin> terminList = new ArrayList<>();

        //Menu

        System.out.println("Witamy w bazie pacjentów");
        System.out.println("Aby dodać pacjenta wcisnij 1");
        System.out.println("Aby wyświetlić listę pacjentów wciśnij 2");
        System.out.println("Aby wyświetlić dane konkretnego pacjenta wciśnij 3");
        System.out.println("Aby usunąć pacjenta wciśnij 4");
        System.out.println("Najstarszy i najmłodszy pacjent - wciśnij 5");
        System.out.println("Aby dodać nowy termin naciśnij 6");
        System.out.println("Aby wyświetlić listę terminów naciśnij 7");
        System.out.println("Aby usunąć termin naciśnij 8");
        System.out.println("Aby wyłączyć program wciśnij 0");

        try {
            PatientOperation patient = null;
            TerminOperation termin = null;
            int functionChoose = readFunctionChoose();

            while (functionChoose != PatientOperation.EXIT) {

                switch (functionChoose) {
                    case PatientOperation.ADD:
                        patient = new AddPatient();
                        break;
                    case PatientOperation.SHOW_LIST:
                        patient = new ShowingPatientList();
                        break;
                    case PatientOperation.SHOW_ONE:
                        patient = new ShowingPatient();
                        break;
                    case PatientOperation.REMOVE:
                        patient = new RemovingPatient();
                        break;
                    case PatientOperation.OLDEST_YOUNGEST:
                        patient = new ShowingOldestPatient();
                        break;
                    case TerminOperation.NEW_VISIT:
                        termin = new AddTermin();
                        break;
                    case TerminOperation.TERMIN_LIST:
                        termin = new ShowingTerminList();
                        break;
                    case TerminOperation.REMOVE_VISIT:
                        termin = new RemovingTermin();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + functionChoose );



                }
                if (functionChoose<=PatientOperation.OLDEST_YOUNGEST){
                patient.patientOperation(patientList, db);} else {
                termin.terminOperation(terminList, db);}

                System.out.println("Podaj co chcesz dalej zrobić");
                functionChoose = readFunctionChoose();


            }

        } catch (IllegalStateException e) {
            e.printStackTrace();
            System.out.println("Podaj inny numer");

        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Złe numery pesel");
        }

        System.out.println("Program wyłączony");
        System.exit(1);
    }

    private static Integer readFunctionChoose() {
        return new Scanner(System.in).nextInt();
    }

}
