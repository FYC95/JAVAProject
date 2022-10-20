import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PrepareStatement {
    public static void main(String[] args) throws Exception {
        String uname = "zzzzzsssss";
        String pass = "12345678";
        String phone = "10086";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3331/llg?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","111111");
        String sql = "insert into buser (username,password,phone) value (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,uname);
        ps.setString(2,pass);
        ps.setString(3,phone);
        ps.execute();
        ps.close();
        conn.close();
    }
}
