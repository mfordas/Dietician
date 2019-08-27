import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ShowingPatient implements PatientOperation{
    @Override
    public void patientOperation(List<Patient> patientList, DieticianDatabase db) {
        System.out.println("Podaj pesel pacjenta, ktorego dane chcesz wyświetlić");

        String sql = "SELECT id, firstName, lastName "
                + "FROM patientList WHERE id = ?";

        try {Connection conn = db.getConn();
             PreparedStatement pstmt  = conn.prepareStatement(sql);

            // set the value
            pstmt.setString(1,PatientFactory.getPatientId());
            //
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("id") +  "\t" +
                        rs.getString("firstName") + "\t" +
                        rs.getString("lastName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        /*final String id = PatientFactory.getPatientId();
        Patient patient = patientList.stream()
                .filter(Patient -> Long.parseLong(id) == (Long.parseLong(Patient.getId())))
                .findAny()
                .orElse(null);*/


        /*System.out.println(patient.getId()+ " " + patient.getFirstName() + " " + patient.getLastName());*/
    }
}
