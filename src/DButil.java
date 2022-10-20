import java.sql.*;

public class DButil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
    }
    public static Connection getConn() throws SQLException {
        String url = "jdbc:mysql://localhost:3310/fyc?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        String user = "root";
        String pass = "000000";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,user,pass);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void close(ResultSet rs,Statement st,Connection conn){
        try {
            if (rs != null){
                try {
                    rs.close();
                }catch (SQLException e){e.printStackTrace();}
            }
        }finally {
            try {
                if (st != null){
                    try {
                        st.close();
                    }catch (SQLException e){e.printStackTrace();}
                }
            }finally {
                if (conn != null){
                    try {
                        conn.close();
                    }catch (SQLException e){e.printStackTrace();}
                }
            }
        }
    }
}
