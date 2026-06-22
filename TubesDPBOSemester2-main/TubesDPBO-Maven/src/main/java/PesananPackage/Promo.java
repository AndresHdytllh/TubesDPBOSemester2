package PesananPackage;

public class Promo {

    private String kodePromo;
    private double diskon;      // nilai 0.0 – 1.0 (mis. 0.10 = diskon 10%)

    public Promo(String kode, double diskon) {
        this.kodePromo = kode;
        this.diskon = diskon;
    }

    public String getKodePromo() {
        return kodePromo;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setKodePromo(String k) {
        this.kodePromo = k;
    }

    public void setDiskon(double d) {
        this.diskon = d;
    }

    /**
     * Terapkan diskon ke total harga pesanan.
     *
     * @param totalHarga total sebelum diskon
     * @return total setelah diskon
     */
    public double terapkanDiskon(double totalHarga) {
        return totalHarga * (1.0 - diskon);
    }
}
