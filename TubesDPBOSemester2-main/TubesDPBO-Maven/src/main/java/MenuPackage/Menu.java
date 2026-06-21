/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuPackage;

/**
 *
 * @author lenovo
 */
public class Menu {
    private String idMenu;
    private String namaProduk;
    private int harga;
    
    public Menu(String idMenu, String namaProduk, int harga){
        this.idMenu = idMenu;
        this.namaProduk = namaProduk;
        this.harga = harga;
    }

    public String getIdMenu() {
        return idMenu;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public int getHarga() {
        return harga;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    
}
