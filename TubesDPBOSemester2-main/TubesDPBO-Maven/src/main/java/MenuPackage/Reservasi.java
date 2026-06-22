package MenuPackage;

public class Reservasi {

    private String idReservasi;
    private String namaPelanggan;
    private int jumlahOrang;
    private Meja meja; 

   
    public Reservasi(String idReservasi, String namaPelanggan, int jumlahOrang, Meja meja) {
        this.idReservasi = idReservasi;
        this.namaPelanggan = namaPelanggan;
        this.jumlahOrang = jumlahOrang;
        this.meja = meja;
    }

    // Getter
    public String getIdReservasi() {
        return idReservasi;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public int getJumlahOrang() {
        return jumlahOrang;
    }

    public Meja getMeja() {
        return meja;
    }

    // Setter
    public void setIdReservasi(String id) {
        this.idReservasi = id;
    }

    public void setNamaPelanggan(String nama) {
        this.namaPelanggan = nama;
    }

    public void setJumlahOrang(int jumlah) {
        this.jumlahOrang = jumlah;
    }

    public void setMeja(Meja meja) {
        this.meja = meja;
    }

    // Method Operasional
    public void konfirmasiReservasi() {
        meja.pesanMeja();

        // ini buat Print ke console sebagai log sistem
        System.out.println("Reservasi " + idReservasi + " oleh " + namaPelanggan
                + " dikonfirmasi untuk " + jumlahOrang + " orang di Meja " + meja.getNoMeja() + ".");
    }
}
