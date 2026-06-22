package UserPackage;

public class Pelanggan extends User {

    private int poinMember;

    public Pelanggan(String idUser, String username, String password, int poinMember) {
        super(idUser, username, password);
        this.poinMember = poinMember;
    }

    public int getPoinMember() {
        return poinMember;
    }

    public void setPoinMember(int poin) {
        this.poinMember = poin;
    }

    @Override
    public String getRole() {
        return "Pelanggan";
    }

    @Override
    public boolean login(String username, String password) {
        return getRole().equals("Pelanggan")
                && username.equals(getUsername())
                && password.equals(getPassword());
    }

    @Override
    public void logout() {
        System.out.println("Anda Telah Logout Sebagai Pelanggan");
    }
}
