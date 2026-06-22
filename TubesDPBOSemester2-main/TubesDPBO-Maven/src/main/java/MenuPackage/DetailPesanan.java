package MenuPackage;

/**
 * Merepresentasikan satu baris item dalam sebuah pesanan.
 *
 * PERBAIKAN: Sebelumnya extends Menu (kurang tepat secara semantik —
 * DetailPesanan "adalah" Menu tidak masuk akal). Sekarang menggunakan komposisi
 * (has-a): menyimpan referensi ke Menu dan menyalin data harga saat pesan
 * dibuat agar snapshot harga tetap akurat meski harga Menu berubah di kemudian
 * hari.
 */
public class DetailPesanan {

    private Menu menu;        // referensi ke Menu asli
    private String idMenu;
    private String namaProduk;
    private int harga;
    private int quantity;
    private double subtotal;

    public DetailPesanan(Menu menu, int quantity) {
        this.menu = menu;
        this.idMenu = menu.getIdMenu();
        this.namaProduk = menu.getNamaProduk();
        this.harga = menu.getHarga();
        this.quantity = quantity;
        this.subtotal = (double) harga * quantity;
    }

    public Menu getMenu() {
        return menu;
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

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.subtotal = (double) harga * quantity;
    }
}
