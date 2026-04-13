package praktikum.praktikumabstract;
public class KueJadi extends Kue {
    public double jumlah;
    public KueJadi (String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }
    @Override
     public double hitungHarga(double harga) {
        return super.harga*jumlah*2;
    }
    @Override
    public String toString() {
        return super.toString() +
        String.format (
            "Total harga: %,.2f\n",
            hitungHarga(harga)
        );
    }
}