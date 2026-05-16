package Sortingsearch;
import java.util.*;
class Pemain {
    String nama;
    String tim;
    int tinggi; 
    int berat;

    public Pemain(String nama, String tim, int tinggi, int berat) {
        this.nama = nama;
        this.tim = tim;
        this.tinggi = tinggi;
        this.berat = berat;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-5s | %d cm | %d kg", nama, tim, tinggi, berat);
    }
}
public class TimFutsal {
    public static void main(String[] args) {
        List<Pemain> allPemain = new ArrayList<>();
        allPemain.add(new Pemain("Baldy", "A", 170, 65));
        allPemain.add(new Pemain("Joko", "A", 175, 70));
        allPemain.add(new Pemain("Anwar", "A", 168, 60));
        allPemain.add(new Pemain("Asep", "A", 180, 75));
        allPemain.add(new Pemain("Cak Jon", "A", 172, 68));

        List<Pemain> timB = new ArrayList<>();
        timB.add(new Pemain("BudiSpeed", "B", 178, 72));
        timB.add(new Pemain("Cak Man", "B", 165, 58));
        timB.add(new Pemain("Mak Cik", "B", 173, 66));
        timB.add(new Pemain("Jokowi", "B", 182, 80));
        timB.add(new Pemain("Cak Sul", "B", 170, 64));
        
        allPemain.addAll(timB);
        System.out.println(" ~ Tinggi Badan Ascending ~");
        allPemain.sort(Comparator.comparingInt(p -> p.tinggi));
        allPemain.forEach(System.out::println);

        System.out.println("\n ~ Tinggi Badan Descending ~");
        allPemain.sort((p1, p2) -> p2.tinggi - p1.tinggi);
        allPemain.forEach(System.out::println);

        System.out.println("\n~ Berat Badan Ascending ~");
        allPemain.sort(Comparator.comparingInt(p -> p.berat));
        allPemain.forEach(System.out::println);

        System.out.println("\n~ Berat Badan Descending ~");
        allPemain.sort((p1, p2) -> p2.berat - p1.berat);
        allPemain.forEach(System.out::println);

        tampilkanMinMax(allPemain, "A");
        tampilkanMinMax(allPemain, "B");
        
        List<Pemain> timC = new ArrayList<>(timB);
        System.out.println("\n~ Anggota Tim C (Copy dari Tim B) ~");
        timC.forEach(System.out::println);
    }
    public static void tampilkanMinMax(List<Pemain> list, String namaTim) {
        List<Pemain> filterTim = new ArrayList<>();
        for (Pemain p : list) {
            if (p.tim.equalsIgnoreCase(namaTim)) filterTim.add(p);
        }
        int maxTinggi = filterTim.stream().mapToInt(p -> p.tinggi).max().orElse(0);
        int minTinggi = filterTim.stream().mapToInt(p -> p.tinggi).min().orElse(0);
        int maxBerat = filterTim.stream().mapToInt(p -> p.berat).max().orElse(0);
        int minBerat = filterTim.stream().mapToInt(p -> p.berat).min().orElse(0);
        System.out.println("\n~ Statistik Tim " + namaTim + " ~");
        System.out.println("Tinggi: Max " + maxTinggi + " | Min " + minTinggi);
        System.out.println("Berat : Max " + maxBerat + " | Min " + minBerat);
    }
}
