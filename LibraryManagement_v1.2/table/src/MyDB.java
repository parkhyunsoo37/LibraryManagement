import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDB {
    private static final String URL = "jdbc:mariadb://192.168.100.20:3306/library";
    private static final String USER = "cjulib";
    private static final String PASSWORD = "security";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            // 아래 문장 끝에 세미콜론(;)이 반드시 있어야 합니다.
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ DB 연결 성공!");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ 드라이버 오류: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ DB 접속 오류: " + e.getMessage());
        }
        return conn;
    }
}