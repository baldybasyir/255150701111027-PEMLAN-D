package Sortingsearch;
import java.util.*;
class Pemain {
    String nama;
    int tinggi;
    int berat;
    public Pemain(String nama, int tinggi, int berat) {
        this.nama = nama;
        this.tinggi = tinggi;
        this.berat = berat;
    }
    @Override
    public String toString() {
        return nama + " (" + tinggi + "cm, " + berat + "kg)";
    }
}
public class TimSukses {
    public static void main(String[] args) {
        List<Pemain> timA = new ArrayList<>();
        timA.add(new Pemain("Baldy", 170, 56));
        timA.add(new Pemain("Mas Rafi", 175, 70));
        timA.add(new Pemain("Cak Joko", 168, 56));
        timA.add(new Pemain("Cak Man", 180, 75));
        timA.add(new Pemain("Cak Sul", 172, 53));

        List<Pemain> timB = new ArrayList<>();
        timB.add(new Pemain("Jokowi", 178, 72));
        timB.add(new Pemain("Budi", 168, 58));
        timB.add(new Pemain("Sam Edy", 168, 66));
        timB.add(new Pemain("Mbok Yo", 182, 80));
        timB.add(new Pemain("Jakawi", 160, 64));

        System.out.println("--- Analisis Tim B (Tinggi Badan) ---");
        timB.sort(Comparator.comparingInt(p -> p.tinggi));
        cariJumlah(timB, 168, true);
        cariJumlah(timB, 160, true);

        System.out.println("\n--- Analisis Tim A (Berat Badan) ---");
        timA.sort(Comparator.comparingInt(p -> p.berat));
        cariJumlah(timA, 56, false);
        cariJumlah(timA, 53, false);
        cekKesamaan(timA, timB);
    }

    public static void cariJumlah(List<Pemain> list, int target, boolean isTinggi) {
        int count = 0;
        Comparator<Pemain> comp = isTinggi ? 
            Comparator.comparingInt(p -> p.tinggi) : 
            Comparator.comparingInt(p -> p.berat);

        Pemain targetDummy = isTinggi ? new Pemain("", target, 0) : new Pemain("", 0, target);
        int index = Collections.binarySearch(list, targetDummy, comp);
        if (index >= 0) {
            count++;
            // Cek ke kiri
            for (int i = index - 1; i >= 0 && (isTinggi ? list.get(i).tinggi : list.get(i).berat) == target; i--) count++;
            // Cek ke kanan
            for (int i = index + 1; i < list.size() && (isTinggi ? list.get(i).tinggi : list.get(i).berat) == target; i++) count++;
        }
        String satuan = isTinggi ? "cm" : "kg";
        System.out.println("Jumlah pemain dengan " + (isTinggi ? "tinggi" : "berat") + " " + target + satuan + ": " + count);
    }
    public static void cekKesamaan(List<Pemain> a, List<Pemain> b) {
        System.out.println("\n--- Cek Kesamaan Antar Tim ---");
        boolean adaSama = false;
        for (Pemain pA : a) {
            for (Pemain pB : b) {
                if (pA.tinggi == pB.tinggi || pA.berat == pB.berat) {
                    System.out.println("Kesamaan ditemukan: " + pA.nama + " (A) dan " + pB.nama + " (B)");
                    adaSama = true;
                }
            }
        }
        if (!adaSama) System.out.println("Tidak ada pemain dengan tinggi atau berat yang sama.");
    }
}