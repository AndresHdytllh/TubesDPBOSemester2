/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuPackage;

/**
 *
 * @author lenovo
 */
public class DetailPesanan extends Menu {

    private int quantity;
    private double subtotal;

    public DetailPesanan(String idMenu, String namaProduk, int harga, int quantity, double subtotal) {
        super(idMenu, namaProduk, harga);
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

}
