package UserPackage;

public abstract class User {

    private String idUser;
    private String username;
    private String password;

    public User(String idUser, String username, String password) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract boolean login(String username, String password);

    public abstract void logout();

    public abstract String getRole();
}
