package praktikuminheritance;
import java.time.LocalDate;
public class MainOutput {
    public static void main(String[] args) {
        Manusia manusia1 = new Manusia("A", true, "111", true);
        MahasiswaFILKOM mahasiswa1 = new MahasiswaFILKOM("B", false, "111",false, "25515070111027", 4.0);
        Pekerja pekerja1 = new Pekerja("Baldy", true, "111", true, LocalDate.of(2016, 3, 2), 1000, 4);
        Manajer manajer1 = new Manajer("Dendi", true, "111", true, LocalDate.of(2017, 1, 2), 1000, 3, "HRD");
       System.out.println(manusia1);
       System.out.println(mahasiswa1);
       System.out.println(pekerja1);
       System.out.println(manajer1);
    }
}
