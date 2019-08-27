import java.util.Scanner;

public class PatientFactory {


    public static Patient createPatient() {
        System.out.println("Podaj dane pacjenta: ");
        return new Patient.Builder()
                .Info("Podaj pesel")
                .id(getPatientId())
                .Info("Podaj imię")
                .firstName(getPatientFirstName())
                .Info("Podaj nazwisko")
                .lastName(getPatientLastName())
                .build();

    }

    public static String getPatientId() {
        return new Scanner(System.in).next();
    }

    public static String getPatientFirstName() {
        return new Scanner(System.in).next();
    }

    public static String getPatientLastName() {
        return new Scanner(System.in).next();
    }

}
