package MenuPackage;

public class Meja {

    private int noMeja;
    private int kapasitas;
    private String statusMeja;

    // Konstruktor
    public Meja(int noMeja, int kapasitas) {
        this.noMeja = noMeja;
        this.kapasitas = kapasitas;
        this.statusMeja = "Kosong"; 
    }

    // Getter
    public int getNoMeja() {
        return noMeja;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public String getStatusMeja() {
        return statusMeja;
    }

    // Setter
    public void setNoMeja(int noMeja) {
        this.noMeja = noMeja;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public void setStatusMeja(String status) {
        this.statusMeja = status;
    }

    // Method Operasional
    public void pesanMeja() {
        this.statusMeja = "Terisi";
    }

    public void bebaskanMeja() {
        this.statusMeja = "Kosong";
    }
}
