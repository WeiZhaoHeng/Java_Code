/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/18
 * Time: 19:13
 */


import com.mysql.jdbc.Driver;

import java.sql.*;

public class Test {
    public static void main1(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册Driver
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取链接
        String url = "jdbc:mysql://127.0.0.1:3306/java20_20191218?useSSL=false";
        String username = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url,username,password);
        //3.获取语句 Statement
        Statement statement = connection.createStatement();
        //4.执行一条 SELECT DATABASE()
        String sql = "select database()";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        String name = resultSet.getString(1);
        System.out.println(name);



        sql = "SELECT id,username FROM users ORDER BY id";
        resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            int id =  resultSet.getInt(1);
            String user = resultSet.getString(2);
            System.out.println(id+"."+user);
        }
        //-3.关闭结果集(resultSet)
        resultSet.close();
        //-2.关闭语句
        statement.close();
        //-1.关闭链接
        connection.close();
    }
}
