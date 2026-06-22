package MenuPackage;

/**
 * PERBAIKAN: Dipindahkan dari LaporanPackage ke MenuPackage karena Meja
 * berkaitan dengan operasional (reservasi), bukan laporan keuangan.
 */
public class Meja {

    private int noMeja;
    private int kapasitas;
    private String statusMeja;

    public Meja(int noMeja, int kapasitas) {
        this.noMeja = noMeja;
        this.kapasitas = kapasitas;
        this.statusMeja = "Kosong";
    }

    public int getNoMeja() {
        return noMeja;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public String getStatusMeja() {
        return statusMeja;
    }

    public void setNoMeja(int noMeja) {
        this.noMeja = noMeja;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public void setStatusMeja(String status) {
        this.statusMeja = status;
    }

    public void pesanMeja() {
        this.statusMeja = "Terisi";
        System.out.println("Meja " + noMeja + " telah dipesan.");
    }

    public void bebaskanMeja() {
        this.statusMeja = "Kosong";
        System.out.println("Meja " + noMeja + " kini kosong.");
    }
}
