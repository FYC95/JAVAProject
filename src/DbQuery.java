import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DbQuery {
    public static void main(String[] args) {
        query();
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
