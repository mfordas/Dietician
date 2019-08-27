import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class AddPatient implements PatientOperation {
    @Override
    public void patientOperation(List<Patient> patientList, DieticianDatabase db) {
        do {
            String sql = "INSERT INTO patientList VALUES(NULL, ?, ?, ?)";

            try {
                Connection conn = db.getConn();

                PreparedStatement pstmt = conn.prepareStatement(sql);
                System.out.println("Podaj pesel pacjenta");
                pstmt.setString(1, PatientFactory.getPatientId());
                System.out.println("Podaj imię pacjenta");
                pstmt.setString(2, PatientFactory.getPatientFirstName());
                System.out.println("Podaj nazwisko pacjenta");
                pstmt.setString(3, PatientFactory.getPatientLastName());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }

            System.out.println("Czy chcesz dodać kolejnego pacjenta? T/N");
        } while (readNextPatient().equalsIgnoreCase("t"));
    }
}
