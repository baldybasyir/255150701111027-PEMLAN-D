package praktikuminheritance;
import java.time.LocalDate;

public class Manajer extends Pekerja {
    private String departemen;
    public Manajer(String nama, boolean jenisKelamin, String Nik, boolean menikah, LocalDate tahunMasuk, double gaji, int jumlahAnak, String departemen) {
        super(nama, jenisKelamin, Nik, menikah, tahunMasuk, gaji, jumlahAnak);
        this.departemen = departemen;
    }
    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }
    public String getDepartemen() {
        return departemen;
    }
     @Override
    public double getTunjangan() {
        return super.getTunjangan() + (0.1 * getGaji());
    }
    public String toString () {
        return super.toString() +
        String.format (
            "Departemen     : %s\n", departemen
        );
    }

}
