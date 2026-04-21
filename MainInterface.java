package praktikum.praktikuminterfacebaru;
import java.util.Scanner;

public class MainInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("║   PROGRAM MAKHLUK HIDUP v1.0     ║");

        while (running) {
            System.out.println("\n===== MENU UTAMA =====");
            System.out.println("1. Input Data Manusia");
            System.out.println("2. Input Data Hewan");
            System.out.println("3. Input Data Tumbuhan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- Input Data Manusia ---");
                    System.out.print("Masukkan nama : ");
                    String namaManusia = scanner.nextLine();

                    System.out.print("Masukkan umur : ");
                    int umurManusia = scanner.nextInt();
                    scanner.nextLine();

                    Manusia manusia = new Manusia(namaManusia, umurManusia);

                    System.out.println("\n===== HASIL DATA MANUSIA =====");
                    manusia.tampilkanNama();
                    manusia.tampilkanUmur();
                    manusia.makan();
                    manusia.berjalan();
                    manusia.bersuara();
                    break;

                case 2:
                    System.out.println("\n--- Input Data Hewan ---");
                    System.out.print("Masukkan nama hewan : ");
                    String namaHewan = scanner.nextLine();

                    System.out.print("Masukkan umur hewan : ");
                    int umurHewan = scanner.nextInt();
                    scanner.nextLine();

                    Hewan hewan = new Hewan(namaHewan, umurHewan);

                    System.out.println("\n===== HASIL DATA HEWAN =====");
                    hewan.tampilkanNama();
                    hewan.tampilkanUmur();
                    hewan.makan();
                    hewan.berjalan();
                    hewan.bersuara();
                    break;

                case 3:
                        System.out.println("\n--- Input Data Tumbuhan ---");
                        System.out.print("Masukkan nama : ");
                        String namaTumbuhan = scanner.nextLine();
                        System.out.print("Masukkan umur : ");
                        int umurTumbuhan = scanner.nextInt();
                        scanner.nextLine();

                        Tumbuhan tumbuhan = new Tumbuhan(namaTumbuhan, umurTumbuhan);
                        System.out.println("\n===== HASIL DATA TUMBUHAN =====");
                        tumbuhan.tampilkanNama();
                        tumbuhan.tampilkanUmur();
                        tumbuhan.makan();
                        tumbuhan.berjalan();
                        tumbuhan.bersuara();
                        tumbuhan.berfotosintesis(); // method tambahan
                        break;
                case 0:
                    System.out.println("\nTerima kasih telah menggunakan program ini. Sampai jumpa!");
                    running = false;
                    break;
                default:
                    System.out.println("\n[!] Pilihan tidak valid, coba lagi.");
            }
        }

        scanner.close();
    }
}