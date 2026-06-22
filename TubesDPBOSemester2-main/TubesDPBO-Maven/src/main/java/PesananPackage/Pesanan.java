package PesananPackage;

import java.util.ArrayList;
import java.util.List;

import MenuPackage.DetailPesanan;
import StatusPackage.StatusPesanan;

/**
 * PERBAIKAN: Status pesanan diinisialisasi menggunakan konstanta dari
 * StatusPesanan, bukan string literal bebas.
 */
public class Pesanan {

    private String idPesanan;
    private double totalHarga;
    private List<DetailPesanan> daftarItem;
    private String status;

    public Pesanan(String idPesanan) {
        this.idPesanan = idPesanan;
        this.daftarItem = new ArrayList<>();
        this.totalHarga = 0;
        this.status = StatusPesanan.MENUNGGU;   // gunakan konstanta
    }

    public String getIdPesanan() {
        return idPesanan;
    }

    public String getStatus() {
        return status;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public List<DetailPesanan> getDaftarItem() {
        return daftarItem;
    }

    public void setIdPesanan(String id) {
        this.idPesanan = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void tambahItem(DetailPesanan item) {
        daftarItem.add(item);
        totalHarga += item.getSubtotal();
        System.out.println(item.getQuantity() + "x "
                + item.getNamaProduk() + " berhasil ditambahkan ke pesanan.");
    }

    public double hitungTotal() {
        return totalHarga;
    }
}
