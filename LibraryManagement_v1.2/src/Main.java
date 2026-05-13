import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // 서버 주소와 계정 정보
        String url = "jdbc:mariadb://192.168.100.20:3306/library";
        String user = "root"; // admin 대신 root로 해보세요!
        String password = "1111"; // HeidiSQL 로그인할 때 쓴 비번

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ 드디어 연결 성공!");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                System.out.println("도서명: " + rs.getString("title"));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("❌ 연결 실패: " + e.getMessage());
        }
    }
}