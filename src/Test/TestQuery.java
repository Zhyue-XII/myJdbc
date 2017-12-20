package Test;

import been.User;
import dao.UserDao;

import java.util.List;

public class TestQuery {
    public static void main(String[] args){
        UserDao dao = new UserDao();
        String sql = "SELECT * FROM user";
        Object [] pram = null;
        List<User> list = dao.query(sql,pram);
        for(Object o:list){
            System.out.println(o);
        }

    }
}
