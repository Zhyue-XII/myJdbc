package Test;
import dao.UserDao;


public class TestUpdata {
    public static void main(String [] args){
        UserDao dao = new UserDao();
        String sql = "INSERT INTO user(user_name,user_psd) VALUES (?,?)";
        Object [] pram = {"杨玉环",123464};
        int i = dao.update(sql,pram);


    }
}
