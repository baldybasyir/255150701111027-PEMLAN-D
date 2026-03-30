package semester2;
import java.util.Scanner;

public class SistemPenjualanJaket {
    public static void main(String[] args) {
        final int HARGA_A = 100000;
        final int HARGA_B = 125000;
        final int HARGA_C = 175000;
        final int DISKON_A = 95000;
        final int DISKON_B = 120000;
        final int DISKON_C = 160000;

        Scanner input = new Scanner(System.in);
        System.out.println("=== Sistem Penjualan Jaket CV. Labkomdas ===");
        System.out.print("Masukkan jumlah Jaket A: ");
        int jumlahA = input.nextInt();
        System.out.print("Masukkan jumlah Jaket B: ");
        int jumlahB = input.nextInt();
        System.out.print("Masukkan jumlah Jaket C: ");
        int jumlahC = input.nextInt();
        long totalA = (jumlahA > 100) ? (long) jumlahA * DISKON_A : (long) jumlahA * HARGA_A;
        long totalB = (jumlahB > 100) ? (long) jumlahB * DISKON_B : (long) jumlahB * HARGA_B;
        long totalC = (jumlahC > 100) ? (long) jumlahC * DISKON_C : (long) jumlahC * HARGA_C;
        long totalBayar = totalA + totalB + totalC;
        System.out.println("\n--- Rincian Pembayaran ---");
        System.out.printf("Total Jaket A: Rp %,d%n", totalA);
        System.out.printf("Total Jaket B: Rp %,d%n", totalB);
        System.out.printf("Total Jaket C: Rp %,d%n", totalC);
        System.out.println("---------------------------");
        System.out.printf("TOTAL BAYAR  : Rp %,d%n", totalBayar);
        input.close();
    }
}