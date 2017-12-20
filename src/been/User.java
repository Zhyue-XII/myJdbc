package been;

public class User {
    private int user_id;
    private String user_name;
    private int user_psd;

    public User(int user_id, String user_name, int user_psd) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_psd = user_psd;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_psd() {
        return user_psd;
    }

    public void setUser_psd(int user_psd) {
        this.user_psd = user_psd;
    }

    @Override
    public String toString() {
        return "User{" +
                "用户id：" + user_id +
                ", 用户名：" + user_name +
                ", 密码：" + user_psd +
                '}';
    }
}
