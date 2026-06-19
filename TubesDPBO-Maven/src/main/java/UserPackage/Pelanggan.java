    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserPackage;



/**
 *
 * @author lenovo
 */
public class Pelanggan extends User{
    private int poinMember;

    public Pelanggan(String idUser, String username, String password,int poinMember) {
        super(idUser, username, password);
        this.poinMember = poinMember;
    }

    public int getPoinMember() {
        return poinMember;
    }

    public void setPoinMember(int poinMember) {
        this.poinMember = poinMember;
    }

    @Override
    public boolean login(String username,String password) {
        boolean validasi = false;
        if(getRole().equals("Pelanggan") && username.equals(getUsername())
                && password.equals(getPassword())){
            validasi = true;
        }
        return validasi;
    }

    @Override
    public void logout() {
        System.out.println("Anda Telah Logout Sebagai Pelanggan");
    }

    @Override
    public String getRole() {
        return "Pelanggan";
    }   
}
