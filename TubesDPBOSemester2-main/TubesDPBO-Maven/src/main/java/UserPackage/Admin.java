package UserPackage;

public class Admin extends User {

    private String tingkatAkses;

    public Admin(String idUser, String username, String password, String tingkatAkses) {
        super(idUser, username, password);
        this.tingkatAkses = tingkatAkses;
    }

    public String getTingkatAkses() {
        return tingkatAkses;
    }

    public void setTingkatAkses(String akses) {
        this.tingkatAkses = akses;
    }

    @Override
    public String getRole() {
        return "Admin";
    }

    @Override
    public boolean login(String username, String password) {
        return getRole().equals("Admin")
                && username.equals(getUsername())
                && password.equals(getPassword());
    }

    @Override
    public void logout() {
        System.out.println("Anda Telah Logout Sebagai Admin");
    }
}
