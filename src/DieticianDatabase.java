import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DieticianDatabase {

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:dieticianDatabase.db";

    private Connection conn;
    private Statement stat;

    public DieticianDatabase() {
        try {
            Class.forName(DieticianDatabase.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }

        createTables();
    }

    public boolean createTables() {
        String createPatientList = "CREATE TABLE IF NOT EXISTS patientList (id_patient INTEGER PRIMARY KEY AUTOINCREMENT, id String, firstName String, lastName String)";
        String createTerminList = "CREATE TABLE IF NOT EXISTS terminList (id_termin INTEGER PRIMARY KEY AUTOINCREMENT, id String, date String, hour String)";
        try {
            stat.execute(createPatientList);
            stat.execute(createTerminList);
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Connection getConn() {
        return conn;
    }

    public Statement getStat() {
        return stat;
    }


    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
}

