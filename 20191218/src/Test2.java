import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/18
 * Time: 20:06
 */
public class Test2 {
    public static void main1(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/java20_20191218?useSSL=false";
        String username = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();
        String sql = "select database()";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        String name = resultSet.getString(1);
        System.out.println(name);
        resultSet.close();
        sql = "SHOW TABLES";
        resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            String name1 = resultSet.getString(1);
            System.out.println(name1);
        }
        resultSet.close();
        sql = "SELECT id,username FROM users ORDER BY id";
        resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String user = resultSet.getString(2);
            System.out.println(id+"."+user);
        }
        resultSet.close();

        statement.close();
        connection.close();

    }

}
