import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DbDelete {
    public static void main(String[] args) {
        del();
    }
    public static void del() {
        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/fyc?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","000000");
            statement = conn.createStatement();
            String sql = "delete from mytab where id=5";
            statement.execute(sql);
            System.out.println("删除成功");
        } catch (ClassNotFoundException var14) {
            var14.printStackTrace();
        } catch (SQLException var15) {
            var15.printStackTrace();
        } finally {
            try {
                statement.close();
                conn.close();
            } catch (Exception var13) {
                var13.printStackTrace();
            }

        }

    }
}
