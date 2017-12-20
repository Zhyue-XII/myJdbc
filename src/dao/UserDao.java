package dao;

import been.User;
import com.zhyue.util.Jutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    Jutil jutil = new Jutil();

    /**
     * 更新数据库
     */
    public int update(String sql,Object [] pram){
        PreparedStatement ps = null;
        Connection con = null;
        try {
            con = jutil.getConnection();
            ps = con.prepareStatement(sql);
            if(null!=pram&&pram.length>0) {
                for (int i = 0; i < pram.length; i++) {
                    ps.setObject(i+1, pram[i]);
                }
            }
            int i =ps.executeUpdate();
            if(i>0){
                System.out.println("数据库更新成功");
            }else {
                System.out.println("数据库更新失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jutil.closeAll(null,ps,con);
        }
        return 0;
    }

    /**
     * 查看数据库
     */
    public List<User> query(String sql, Object [] pram){
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        List<User> list = new  ArrayList();
        try {
            con = jutil.getConnection();
            ps = con.prepareStatement(sql);
            if(null!=pram&&pram.length>0){
                for (int i=0;i<pram.length;i++){
                    ps.setObject(i+1,pram[i]);
                }
            }
            rs=ps.executeQuery();
            while (rs.next()){
                User user = new User(rs.getInt(1),rs.getString(2),rs.getInt(3));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jutil.closeAll(rs,ps,con);
        }
        return null;
    }
}
