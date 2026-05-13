import java.sql.*;

public class LibraryTest {
    public static void main(String[] args) {
        // 1. DBConn을 통해 연결 통로를 엽니다.
        Connection conn = MyDB.getConnection();

        if (conn != null) {
            // 2. HeidiSQL에서 확인했던 library 데이터베이스의 books 테이블을 조회합니다.
            String sql = "SELECT book_id, title, author FROM books";

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                System.out.println("======= 도서 대출 시스템 목록 =======");
                // 3. 반복문을 돌며 책 정보를 하나씩 출력합니다.
                while (rs.next()) {
                    int id = rs.getInt("book_id");
                    String title = rs.getString("title");
                    String author = rs.getString("author");
                    System.out.println(id + " | " + title + " | " + author);
                }
                System.out.println("==================================");

            } catch (SQLException e) {
                System.out.println("❌ 데이터 조회 중 오류 발생: " + e.getMessage());
            } finally {
                try { conn.close(); } catch (SQLException e) {}
            }
        }
    }
}