/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserPackage;



/**
 *
 * @author lenovo
 */
public class Admin extends User{
    private String tingkatAkses;

    public Admin(String idUser, String username, String password,String tingkatAkses) {
        super(idUser, username, password);
        this.tingkatAkses = tingkatAkses;
    }

    public String getTingkatAkses() {
        return tingkatAkses;
    }

    public void setTingkatAkses(String tingkatAkses) {
        this.tingkatAkses = tingkatAkses;
    }
    
    @Override
    public String getRole() {
        return "Admin";
    }

    @Override
    public boolean login(String username, String password) {
        boolean validasi = false;
        if(getRole().equals("Admin") && username.equals(getUsername())
                && password.equals(getPassword())){
            validasi = true;
        }
        return validasi;
    }

    @Override
    public void logout() {
        System.out.println("Anda Telah Logout Sebagai Admin");
    }

}