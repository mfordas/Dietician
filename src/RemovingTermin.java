import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RemovingTermin implements PatientOperation {
    @Override
    public void patientOperation(List<Patient> patientList, DieticianDatabase db) {
        System.out.println("Podaj pesel pacjenta, ktorego wizytę chcesz skasować");
        String sql = "DELETE FROM terminList WHERE id = ?";

        try {Connection conn = db.getConn();
             PreparedStatement pstmt = conn.prepareStatement(sql);

            // set the corresponding param
            pstmt.setString(1, readPatientId());
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
