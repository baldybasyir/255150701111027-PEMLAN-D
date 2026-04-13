package praktikum.praktikumabstract;
public abstract class Kue {
    private String nama;
    public double harga;
    public Kue (String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }
     abstract double hitungHarga (double harga);
     double hitungHarga() {
        return hitungHarga(harga);
     }

    public String toString() {
        return String.format (
    "Nama Kue : %s\n" +
    "Harga    : Rp%,.2f\n" , nama , harga
        );
    }
}