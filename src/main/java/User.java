import java.time.LocalDateTime;

public class User {

    private String email;
    private String name;
    private int age;
    private String password;
    private LocalDateTime lastLogin;

    public User(String email, String name, int age, String password, LocalDateTime lastLogin) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.password = password;
        this.lastLogin = lastLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastlogin(LocalDateTime lastlogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", lastLogin=" + lastLogin +
                '}';
    }
}