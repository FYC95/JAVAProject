import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DbAlter {
    public static void main(String[] args) {
        query();
        System.out.print("请输入需要修改记录的id值：");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        change(id);
    }
    public static void change(Integer argId) {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/fyc?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","000000");
            statement = conn.createStatement();
            String sql = "select * from mytab where id = " + argId;
            resultSet = statement.executeQuery(sql);
            System.out.println("查询单个数据成功"+resultSet);
            resultSet.next();
            Buser old = (new Buser(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("phone"))).setUptime(resultSet.getTimestamp("uptime"));
            System.out.println(old);
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入新密码：");
            String newPass = scanner.nextLine();
            System.out.print("请输入新手机号码：");
            String newPhone = scanner.nextLine();
            sql = "update mytab set password='" + newPass + "',phone='" + newPhone + "' where id=" + argId;
            System.out.println(sql);
            statement.execute(sql);
        } catch (ClassNotFoundException var19) {
            var19.printStackTrace();
        } catch (SQLException var20) {
            var20.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                conn.close();
            } catch (Exception var18) {
                var18.printStackTrace();
            }

        }

    }
    public static void query() {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/fyc?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","000000");
            statement = conn.createStatement();
            String sql = "select * from mytab";
            resultSet = statement.executeQuery(sql);
            System.out.println("查询成功");
            List<Buser> busers = new ArrayList();

            while(resultSet.next()) {
                busers.add((new Buser(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("phone"))).setUptime(resultSet.getTimestamp("uptime")));
            }

            Iterator var5 = busers.iterator();

            while(var5.hasNext()) {
                Buser b = (Buser)var5.next();
                System.out.println(b);
            }
        } catch (ClassNotFoundException var17) {
            var17.printStackTrace();
        } catch (SQLException var18) {
            var18.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                conn.close();
            } catch (Exception var16) {
                var16.printStackTrace();
            }

        }

    }
}
