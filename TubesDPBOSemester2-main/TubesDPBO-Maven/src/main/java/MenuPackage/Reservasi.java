package MenuPackage;

/**
 * PERBAIKAN: Ditambahkan referensi ke Meja sehingga Reservasi terhubung secara
 * eksplisit dengan meja yang dipesan, dan bisa langsung mengubah status meja
 * saat reservasi dikonfirmasi.
 */
public class Reservasi {

    private String idReservasi;
    private int jumlahOrang;
    private Meja meja;        // asosiasi ke Meja

    public Reservasi(String idReservasi, int jumlahOrang, Meja meja) {
        this.idReservasi = idReservasi;
        this.jumlahOrang = jumlahOrang;
        this.meja = meja;
    }

    public String getIdReservasi() {
        return idReservasi;
    }

    public int getJumlahOrang() {
        return jumlahOrang;
    }

    public Meja getMeja() {
        return meja;
    }

    public void setIdReservasi(String id) {
        this.idReservasi = id;
    }

    public void setJumlahOrang(int jumlah) {
        this.jumlahOrang = jumlah;
    }

    public void setMeja(Meja meja) {
        this.meja = meja;
    }

    /**
     * Konfirmasi reservasi: tandai meja sebagai terisi.
     */
    public void konfirmasiReservasi() {
        meja.pesanMeja();
        System.out.println("Reservasi " + idReservasi
                + " dikonfirmasi untuk " + jumlahOrang + " orang.");
    }
}
