package Test;

import been.User;
import dao.UserDao;

import java.util.List;
import java.util.Scanner;

public class BlankLogin {
    public static void main(String[] args) {
        System.out.println("========登陆========");
        UserDao dao = new UserDao();
        String sql = "SELECT * FROM user WHERE user_name=? AND user_psd = ?";
        Scanner s = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = s.next();
        Scanner ss = new Scanner(System.in);
        int count =0;
        while(count<3){
            count++;
            System.out.println("请输入密码");
            int passaword = ss.nextInt();
            Object [] pram = {name,passaword};
            List<User> list = dao.query(sql, pram);
            if(null!=list&&list.size()>0){
                System.out.println("登录成功");
                break;
            }else{
                System.out.println("登录失败，用户名或密码错误");
                continue;
            }
        }
        System.out.println("1.余额查询,2.修改密码,3.转账,4.退出");
        Scanner n = new Scanner(System.in);
        int num = n.nextInt();
        switch(num){
            case 1:
                System.out.println("10000000000000");
                break;
            case 2:
                System.out.println("请修改新密码");
                Scanner c = new Scanner(System.in);
                int newPas1 = c.nextInt();
                System.out.println("确认新密码");
                Scanner c1 = new Scanner(System.in);
                int newPas2 = c1.nextInt();
                if(newPas1==newPas2){
                    String changeP = "UPDATE user set  user_psd= ？where user_name=?";
                    Object [] changeCheek = {newPas1,name};
                    dao.update(changeP, changeCheek);
                    System.out.println("修改成功");
                }else{
                    System.out.println("密码不一致!!");
                }
                break;
            case 3:
                System.out.println("暂未开通");
                break;
            case 4:
                System.out.println("谢谢使用");
                break;
        }


    }
}
