package LaporanPackage;

/**
 *
 * @author lenovo
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

    public void setNoMeja(int noMeja) {
        this.noMeja = noMeja;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getStatusMeja() {
        return statusMeja;
    }

    public void setStatusMeja(String statusMeja) {
        this.statusMeja = statusMeja;
    }
    
    public void pesanMeja() {
        this.statusMeja = "Terisi";
        System.out.println("Meja " + noMeja + " telah dipesan.");
    }
}
