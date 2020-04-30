package Lesson5Java2;

import java.sql.*;

public class ex2 {
    //1.Hiển thị đơn hàng mới tiếp nhận
    public static void yc1() {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/bookstore?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        ""
                );
                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "select book.title, status from book inner join invoice on book.idBook = invoice.idBook where status = 1";
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("Đơn hàng mới tiếp nhận");
            while (rset.next()){
                String title =rset.getString("book.title");

                System.out.println(title);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        yc1();
    }
}
