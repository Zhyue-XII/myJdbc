package Test;

import been.User;
import dao.UserDao;

import java.util.List;
import java.util.Scanner;

public class TestRegist {
    public static void main(String[] args){
        System.out.println("=========注册==========");
        while(true){
            UserDao dao = new UserDao();
            String sql = "INSERT INTO user(user_name,user_psd)VALUES(?,?)";
            Scanner s = new Scanner(System.in);
            System.out.println("请输入用户名");
            String name = s.next();
            String sqlcheeked = "SELECT * FROM user WHERE user_name =?";
            Object [] cheekedResult = {name};
            List<User> list = dao.query(sqlcheeked, cheekedResult);
            if(list!= null&&list.size()>0){
                System.out.println("用户名被占用");
				continue;
            }else{
                Scanner ss = new Scanner(System.in);
                System.out.println("请输入密码");
                int pasword = ss.nextInt();
                Object [] pram = {name,pasword};
                int i = dao.update(sql, pram);
                System.out.println("恭喜注册成功");
                break;
            }
        }

    }
}

