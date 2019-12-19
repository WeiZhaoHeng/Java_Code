import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/18
 * Time: 20:55
 */
public class BlogSystem {
    private static Connection connection;
    public static User currentUser;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/java20_20191218?useSSL=false";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("===================");
            System.out.println("1.注册用户");
            System.out.println("2.登录用户");
            System.out.println("其他退出系统");
            System.out.print("博客系统>");
            System.out.println("===================");
            //currentUser = new User(0,null);
            int select = scanner.nextInt();
            switch(select){
                case 1:registerUser();break;
                case 2:loginUser();break;
                default:running = false;
            }
            if(running == false){
                break;
            }
            if(select == 1){
                break;
            }
            System.out.println("===================");
            System.out.println("1.发表文章");
            System.out.println("2.查看文章");
            System.out.println("其他退出系统");
            System.out.println("===================");
            select = scanner.nextInt();
            switch (select){
                case 1:publishAnArticle();break;
                case 2:checkArticle();break;
                default:running = false;
            }
        }
    }

    private static void publishAnArticle() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文章的标题：");
        String title = scanner.nextLine();
        System.out.println("请输入文章内容：");
        String content = scanner.nextLine();
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat format = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss"
        );
        String s = format.format(date);
        Statement statement = connection.createStatement();
        String sql = String.format("INSERT INTO articles (author_id, title, content,published_at) VALUES ('%d','%s','%s','%s')",
                currentUser.id,title,content,s);
        statement.executeUpdate(sql);
        System.out.println("发表成功");
        statement.close();
    }
    private static void checkArticle() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = String.format("SELECT * FROM articles WHERE author_id = %d",currentUser.id);
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        while(resultSet.next()){
            int id =  resultSet.getInt(1);
            int author_id  = resultSet.getInt(2);
            String title = resultSet.getString(3);
            String content = resultSet.getString(4);
            String published_at = resultSet.getString(5);
            System.out.println(id+","+author_id+","+title+","+content+","+published_at);
        }
        resultSet.close();
        statement.close();
    }

    private static void loginUser() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要登录的用户名");
        String username = scanner.nextLine();
        Statement statement = connection.createStatement();
        String sql = String.format("SELECT id FROM users WHERE username = '%s'",
                username);

        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        int id = resultSet.getInt(1);
        currentUser = new User(id,username);
        resultSet.close();
        statement.close();
        System.out.printf("欢迎回来 %s(%d)%n", username, id);

    }

    private static void registerUser() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要注册的用户名");
        String userName = scanner.nextLine();
        Statement statement = connection.createStatement();
        String sql = String.format("INSERT INTO users (username) VALUES ('%s')",
                userName);
        try{
            statement.executeUpdate(sql);
            System.out.println("用户注册成功");
        }catch(SQLException e){
            System.out.println("用户已被占用，请选择其他用户名");
        }
        statement.close();

    }
}
