import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ShowingTerminList implements PatientOperation {
    @Override
    public void terminOperation(List<Termin> terminList, DieticianDatabase db) {
        innerJoinPatienAndTerminList(db);

    }

    private static void innerJoinPatienAndTerminList(DieticianDatabase db) {
        try {
            String sql = "SELECT\n" +
                    "    patientList.id,\n" +
                    "    firstName,\n" +
                    "    lastName,\n" +
                    "    date,\n" +
                    "    hour\n" +
                    "FROM\n" +
                    "    patientList\n" +
                    "    INNER JOIN terminList ON terminList.id = patientList.id";

            ResultSet result = db.getStat().executeQuery(sql);
            String id, firstName, lastName, date, hour;
            while (result.next()) {
                id = result.getString("id");
                firstName = result.getString("firstName");
                lastName = result.getString("lastName");
                date = result.getString("date");
                hour = result.getString("hour");
                System.out.println(id + " " + firstName + " " + lastName + " " + date + " " + hour);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

