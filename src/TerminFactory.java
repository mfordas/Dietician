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

    }





    private static String readDate() { return new Scanner(System.in).next();}

    private static String readId() { return new Scanner(System.in).next();}
}
