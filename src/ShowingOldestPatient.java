import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShowingOldestPatient implements Comparator<Patient>, PatientOperation {

    private final int ID1900 = 1900;
    private final int ID2000 = 2000;


    //Compare method create
    @Override
    public int compare(Patient patient1, Patient patient2) {

        long patientParsed1 = age(patient1.getId(), patient1);
        long patientParsed2 = age(patient2.getId(), patient2);

        if (patientParsed1 > patientParsed2)
            return 1;
        if (patientParsed1 == patientParsed2)
            return 0;
        if (patientParsed1 < patientParsed2)
            return -1;

        return -1;
    }

    //Converting id to year
    private long year(long id) {
        long conversionToYear = (long) Math.pow(10, 2);

        while (id > conversionToYear) {
            id = id / 10;
        }
        return id;
    }


    //Showing information about patients
    @Override
    public void patientOperation(List<Patient> patientList, DieticianDatabase db) {

        Patient oldest = Collections.max(ShowingPatientList.importListFromSQL(patientList, db), new ShowingOldestPatient());
        Patient youngest = Collections.min(ShowingPatientList.importListFromSQL(patientList, db), new ShowingOldestPatient());


        System.out.println("Najstarszy pacjent to:");
        System.out.println(/*oldest.getId() + " " + */oldest.getFirstName() + " " + oldest.getLastName() + ". Ma " + (age(oldest.getId(), oldest) + " lat"));

        System.out.println("Najmłodszy pacjent to:");
        System.out.println(/*youngest.getId() + " " + */youngest.getFirstName() + " " + youngest.getLastName() + ". Ma " + (age(youngest.getId(), youngest) + " lat"));


    }

    //Method to convert String to Long
    private static Long convertToLong(String id) {
        return Long.parseLong(id);
    }

    //Counting age of patient
    private Long age(String id, Patient patient) {
        Long thirdNum = Long.parseLong(String.valueOf(id.charAt(2)));
        if (thirdNum == 2) {
            return LocalDate.now().getYear() - (ID2000 + convertToLong((patient.getId()).substring(0, 2)));
        } else {
            return LocalDate.now().getYear() - (ID1900 + year(convertToLong(patient.getId())));
        }
    }
}


