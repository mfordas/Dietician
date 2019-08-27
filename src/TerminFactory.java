import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TerminFactory implements PatientOperation {
    static String visitDate;
    static String visitHour;

    public static void createTermin(DieticianDatabase db){

            String sql = "INSERT INTO terminList VALUES(NULL, ?, ?, ?)";

            try {
                Connection conn = db.getConn();

                PreparedStatement pstmt = conn.prepareStatement(sql);
                System.out.println("Podaj pesel pacjenta");
                pstmt.setString(1, readId());
                System.out.println("Podaj datę wizyty w formacie YYYY/MM/DD");
                pstmt.setString(2, readDate());
                System.out.println("Podaj godzinę wizyty w formacie HH:MM");
                pstmt.setString(3, readDate());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }


        /*Patient patient;
        System.out.println("Podaj termin wizyty w formacie yyyy/mm/dd hh:mm");
        visitDate = readDate();
        visitHour = readDate();
        Date date = new SimpleDateFormat("yyyy/MM/dd"+"HH:mm").parse(visitDate+visitHour);
        System.out.println("Podaj pesel pacjenta, ktorego chcesz zapisać: ");
        String id = readId();

        patient = patientList.stream()
                .filter(Patient -> Long.parseLong(id) == (Long.parseLong(Patient.getId())))
                .findAny()
                .orElse(null);

        return new Termin.Builder()
                .date(date)
                .patient(patient)
                .build();*/

    }





    private static String readDate() { return new Scanner(System.in).next();}

    private static String readId() { return new Scanner(System.in).next();}
}
