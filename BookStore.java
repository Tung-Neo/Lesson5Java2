package Lesson5Java2;

import java.sql.*;
import java.util.Scanner;

public class BookStore {
    //1.Xem toàn bộ 5 cuốn sách mới nhất
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
        ){
            String strSelect = "select * from book limit 0, 5";
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()){
                int idBook = rset.getInt("idBook");
                String title = rset.getString("title");
                String author = rset.getString("author");
                float price = (float) rset.getDouble("price");
                int qty = rset.getInt("qty");

                System.out.println(idBook + ", " + title + ", " + author + ", " + price + ", " + qty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //2.Xem 5 cuốn sách bán chạy nhất
    public static void yc2() {
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
        ){
            String strSelect = "select invoice.qty, book.* from invoice inner join book on invoice.idBook = book.idBook order by invoice.qty DESC limit 0, 5";
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()){
                int idBook = rset.getInt("book.idBook");
                String title = rset.getString("book.title");
                String author = rset.getString("book.author");
                float price = (float) rset.getDouble("book.price");
                int qty = rset.getInt("invoice.qty");

                System.out.println(title + ", " + author + ", " + price + ", " + qty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //3.Tìm sách theo tên
    public static void yc3() {
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
            ){
                Scanner sc = new Scanner(System.in);
                System.out.println("Nhập tên sách: ");
                String name = sc.nextLine();
                String strSelet = "select * from book where title ='" + name + "'";
                ResultSet rset = stmt.executeQuery(strSelet);

                while (rset.next()){
                    int idBook = rset.getInt("idBook");
                    String title = rset.getString("title");
                    String author = rset.getString("author");
                    float price = (float) rset.getDouble("price");
                    int qty = rset.getInt("qty");

                    System.out.println(idBook + ", " + title + ", " + author + ", " + price + ", " + qty);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    //4.Tìm sách theo tên tác giả
    public static void yc4() {
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
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập tên tác giả: ");
            String author = sc.nextLine();
            String strSelet = "select * from book where author ='" + author + "'";
            ResultSet rset = stmt.executeQuery(strSelet);

            while (rset.next()){
                String title = rset.getString("title");

                System.out.println(title);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //5.Xem chi tiết về cuốn sách
    public static void yc5() {
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
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập ID sách: ");
            String id = sc.nextLine();
            String strSelet = "select * from book where idBook ='" + id + "'";
            ResultSet rset = stmt.executeQuery(strSelet);

            while (rset.next()){
                int idBook = rset.getInt("idBook");
                String title = rset.getString("title");
                String author = rset.getString("author");
                float price = (float) rset.getDouble("price");
                int qty = rset.getInt("qty");

                System.out.println(idBook + ", " + title + ", " + author + ", " + price + ", " + qty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public static void main(String[] args) {
        yc1();
        System.out.println("--------");
        yc2();
        System.out.println("--------");
        yc3();
        System.out.println("--------");
        yc4();
        System.out.println("--------");
        yc5();
    }
}
