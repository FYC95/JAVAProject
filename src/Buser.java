import java.sql.Timestamp;

public class Buser {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private Timestamp uptime;

    public Buser() {
    }

    public Buser(Integer id, String username, String password, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getUptime() {
        return this.uptime;
    }

    public Buser setUptime(Timestamp uptime) {
        this.uptime = uptime;
        return this;
    }

    public String toString() {
        return "\t" + this.id + "\t\t\t\t" + this.username + "\t\t\t\t" + this.password + "\t\t\t\t" + this.phone + "\t\t\t\t" + this.uptime;
    }
}
