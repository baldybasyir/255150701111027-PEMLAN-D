package praktikuminheritance;
import java.time.LocalDate;

public class Pekerja extends Manusia {
    private double gaji;
    private int jumlahAnak;
    private LocalDate tahunMasuk;
    public Pekerja(String nama, boolean jenisKelamin, String Nik, boolean menikah, LocalDate tahunMasuk, double gaji, int jumlahAnak) {
        super(nama, jenisKelamin, Nik, menikah);
        this.gaji = gaji;
        this.tahunMasuk = tahunMasuk;
        this.jumlahAnak = jumlahAnak;
    }
    public void setGaji(double gaji) {
        this.gaji = gaji;
    }
    public void setJumlahAnak(int jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }
    public void setTahunMasuk(LocalDate tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }
    public int getJumlahAnak() {
        return jumlahAnak;
    }
    public LocalDate getTahunMasuk() {
        return tahunMasuk;
    } 
    // get gaji
    public double getGaji() {
        return gaji;
    }
    public double getBonus() {
        int tahunKerja = LocalDate.now().getYear() - tahunMasuk.getYear();
        double bonus = 0;
        if (tahunKerja >= 0 && tahunKerja <= 5) {
            bonus += (5/100.0) * gaji;
        } else if (tahunKerja > 5 && tahunKerja <= 10) {
            bonus += (10/100.0) * gaji;
        } else if (tahunKerja > 10) {
            bonus += (15/100.0) * gaji;
        }
        return bonus;
    }
     @Override
        public double getTunjangan() {
            return super.getTunjangan() + (20 * getJumlahAnak());
        }
    @Override   
    public double getPendapatan() {
        return getTunjangan() + getGaji() + getBonus();
    }
    public String toString() {
        return super.toString() +
        String.format (
            "Tahun Masuk    : %s\n" +
            "Jumlah Anak    : %d\n" +
            "Gaji           : $%,.2f\n",
            tahunMasuk, jumlahAnak, gaji
        ) ;
    }
}