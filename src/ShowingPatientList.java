import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ShowingPatientList implements PatientOperation {
    @Override
    public void patientOperation(List<Patient> patientList, DieticianDatabase db) {
        importListFromSQL(patientList, db);

        for (int patientNumber = 0; patientNumber < patientList.size(); patientNumber++) {
            System.out.println(patientNumber + 1 + " " + patientList.get(patientNumber).getId() + " " + patientList.get(patientNumber).getFirstName() + " " + patientList.get(patientNumber).getLastName());
        }

        patientList.clear();
    }

    public static List<Patient> importListFromSQL(List<Patient> patientList, DieticianDatabase db) {
        try {
            ResultSet result = db.getStat().executeQuery("SELECT * FROM patientList");
            String id, firstName, lastName;
            while (result.next()) {
                id = result.getString("id");
                firstName = result.getString("firstName");
                lastName = result.getString("lastName");
                patientList.add(new Patient(id, firstName, lastName));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patientList;
    }

}

