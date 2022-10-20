import java.sql.*;

public class DbConnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        add("user7","456789","15555585555");
//        del(2);
    }
    public  static  void add(String username1, String password1, String phone1) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3310/fyc?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","000000");
        Statement statement= connection.createStatement();
        String sql="insert into mytab (username,password,phone) value ('"+username1+"','"+password1+"','"+phone1+"')";
        System.out.println(sql);
        boolean b= statement.execute(sql);
        statement.close();
        connection.close();
    }
    public  static  void del(int id1) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3310/fyc?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","000000");
        Statement statement= connection.createStatement();
        String sql="delete from  mytab where id="+id1;
        boolean b= statement.execute(sql);
        statement.close();
        connection.close();
    }public  static  void cha() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3310/fyc?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true", "root", "000000");
            statement = connection.createStatement();
            String sql = "select * from mytab";
            ResultSet b = statement.executeQuery(sql);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}