package praktikum.praktikumabstract;
public class KuePesanan extends Kue {
    public double berat;
    public KuePesanan (String nama, double harga, double berat) {
        super(nama,harga);
        this.berat = berat;
    }
    @Override
    public double hitungHarga(double harga) {
        return super.harga*berat;
    }
    @Override
    public String toString() {
        return super.toString() + 
        String.format (
            "Berat Pesanan : %.2f kg\n"  +
            "Harga Pesanan : Rp%,.2f\n" , berat,
            hitungHarga(harga)
        );
    }
}