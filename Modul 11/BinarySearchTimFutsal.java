package Sortingsearch;
import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchTimFutsal {
    static int binarySearch(ArrayList<Integer> data, int target) {
        int kiri = 0;
        int kanan = data.size() - 1;
        while (kiri <= kanan) {
            int tengah = (kiri + kanan) / 2;
            if (data.get(tengah) == target) {
                return tengah;
            } else if (data.get(tengah) < target) {
                kiri = tengah + 1;
            } else {
                kanan = tengah - 1;
            }
        }
        return -1;
    }

    static int hitungJumlah(ArrayList<Integer> data, int target) {
        int jumlah = 0;
        for (int nilai : data) {
            if (nilai == target) jumlah++;
        }
        return jumlah;
    }

    public static void main(String[] args) {
        ArrayList<Integer> tinggiA = new ArrayList<>();
        tinggiA.add(170); tinggiA.add(165); tinggiA.add(172); tinggiA.add(160);
        tinggiA.add(168); tinggiA.add(175); tinggiA.add(160); tinggiA.add(163);
        tinggiA.add(158); tinggiA.add(170);
        ArrayList<Integer> beratA = new ArrayList<>();
        beratA.add(60); beratA.add(56); beratA.add(65); beratA.add(53);
        beratA.add(58); beratA.add(70); beratA.add(55); beratA.add(56);
        beratA.add(53); beratA.add(62);
 
        ArrayList<Integer> tinggiB = new ArrayList<>();
        tinggiB.add(168); tinggiB.add(155); tinggiB.add(160); tinggiB.add(172);
        tinggiB.add(168); tinggiB.add(160); tinggiB.add(175); tinggiB.add(165);
        tinggiB.add(160); tinggiB.add(180);
        ArrayList<Integer> beratB = new ArrayList<>();
        beratB.add(59); beratB.add(50); beratB.add(54); beratB.add(66);
        beratB.add(61); beratB.add(57); beratB.add(72); beratB.add(60);
        beratB.add(53); beratB.add(75);

        System.out.println("~ BINARY SEARCH DATA PEMAIN ~");
        System.out.println("\nTim A:");
        System.out.println("  Tinggi : " + tinggiA);
        System.out.println("  Berat  : " + beratA);
        System.out.println("\nTim B:");
        System.out.println("  Tinggi : " + tinggiB);
        System.out.println("  Berat  : " + beratB);

        Collections.sort(tinggiA);
        Collections.sort(beratA);
        Collections.sort(tinggiB);
        Collections.sort(beratB);

        System.out.println("\n  Setelah diurutkan:");
        System.out.println("  Tinggi A : " + tinggiA);
        System.out.println("  Berat  A : " + beratA);
        System.out.println("  Tinggi B : " + tinggiB);
        System.out.println("  Berat  B : " + beratB);
        System.out.println("\nTinggi Badan Tim B:");
        System.out.println("  Jumlah pemain tinggi 168 cm: " + hitungJumlah(tinggiB, 168));
        System.out.println("  Jumlah pemain tinggi 160 cm: " + hitungJumlah(tinggiB, 160));
        System.out.println("\nBerat Badan Tim A:");
        System.out.println("  Jumlah pemain berat 56 kg: " + hitungJumlah(beratA, 56));
        System.out.println("  Jumlah pemain berat 53 kg: " + hitungJumlah(beratA, 53));

        System.out.println("\nCek Kesamaan Tim A dengan Tim B:");
        System.out.println("\n  (Tinggi Badan)");
        for (int t : tinggiA) {
            if (binarySearch(tinggiB, t) != -1) {
                System.out.println("  Tinggi " + t + " cm -> ADA di Tim B");
            }
        }
        System.out.println("\n  (Berat Badan)");
        for (int b : beratA) {
            if (binarySearch(beratB, b) != -1) {
                System.out.println("  Berat " + b + " kg -> ADA di Tim B");
            }
        }
    }
}