import java.util.ArrayList;
import java.util.Scanner;

public class RentalSistem {
    private ArrayList<Kendaraan> daftarKendaraan;

    public RentalSistem() {
        daftarKendaraan = new ArrayList<>();
    }
    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);
        System.out.println("[INFO] Kendaraan berhasil ditambahkan: " + k.getNamaKendaraan()
                + " (" + k.getKodeKendaraan() + ")");
    }

    public void tampilkanDaftarKendaraan() {
        System.out.println("\n=== Daftar Armada SuperCar & SuperMoto ===");
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada kendaraan yang terdaftar.");
            return;
        }
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarKendaraan.get(i).tampilInfo();
        }
    }
    public void sewaKendaraan(String kode, int lamaSewa) throws KendaraanTidakTersediaException {
        Kendaraan target = cariKendaraan(kode);
        if (target == null || !target.isTersedia()) {
            throw new KendaraanTidakTersediaException(
                    "Kendaraan dengan kode " + kode + " gagal disewa. " +
                    "Alasan: Kendaraan sedang disewa atau tidak ditemukan!");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Apakah Anda Member VIP? (y/n): ");
        String vipInput = scanner.nextLine().trim();
        boolean isVIP = vipInput.equalsIgnoreCase("y");
        double biayaDasar = target.hitungBiayaDasar(lamaSewa);
        double totalBiaya = biayaDasar;
        double diskonVIP = 0;
        double diskonLama = 0;

        if (isVIP) {
            diskonVIP = biayaDasar * 0.10;
            totalBiaya -= diskonVIP;
        }
        if (lamaSewa > 7) {
            diskonLama = biayaDasar * 0.05;
            totalBiaya -= diskonLama;
        }

        // Update status boloo
        target.setTersedia(false);

        System.out.println("\n=== TRANSAKSI SEWA SuperCar & SuperMoto ===");
        System.out.println("Kendaraan Berhasil Disewa!");
        System.out.printf("Kendaraan   : %s (%s)%n", target.getNamaKendaraan(), target.getKodeKendaraan());
        System.out.printf("Lama Sewa   : %d hari%n", lamaSewa);
        System.out.printf("Biaya Dasar Harian : Rp%,.0f%n", biayaDasar);

        if (target instanceof Mobil) {
            Mobil mobil = (Mobil) target;
            if (mobil.getJumlahKursi() > 5) {
                System.out.printf("Tambahan Kursi (>5)   : +Rp 50,000%n");
            }
        }
        if (target instanceof Motor) {
            Motor motor = (Motor) target;
            if (motor.getJenisTransmisi().equalsIgnoreCase("Matik")) {
            }
        }
        if (isVIP) {
            System.out.printf("Diskon Member VIP (10%%): -Rp%,.0f%n", diskonVIP);
        }
        if (lamaSewa > 7) {
            System.out.printf("Diskon Sewa >7 Hari (5%%): -Rp%,.0f%n", diskonLama);
        }

        System.out.println("----------------------------------");
        System.out.printf("TOTAL BIAYA AKHIR: Rp%,.0f%n", totalBiaya);
    }

    public void kembalikanKendaraan(String kode) {
        Kendaraan target = cariKendaraan(kode);
        if (target == null) {
            System.out.println("Kendaraan dengan kode " + kode + " tidak ditemukan.");
            return;
        }
        if (target.isTersedia()) {
            System.out.println("[INFO] Kendaraan " + target.getNamaKendaraan()
                    + " (" + kode + ") tidak sedang disewa.");
            return;
        }
        target.setTersedia(true);
        System.out.println("[INFO] Kendaraan " + target.getNamaKendaraan()
                + " (" + kode + ") berhasil dikembalikan. Status: Tersedia.");
    }
    private Kendaraan cariKendaraan(String kode) {
        for (Kendaraan k : daftarKendaraan) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        return null;
    }

    public void menuGoDrive(Scanner in) {
        int pilihan = 0;
        do {
            System.out.println("\n====== Rental SuperCar & SuperMoto ======");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Tampilkan Daftar Armada");
            System.out.println("3. Sewa Kendaraan");
            System.out.println("4. Kembalikan Kendaraan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            try {
                pilihan = Integer.parseInt(in.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka 1-5.");
                continue;
            }

            switch (pilihan) {
                case 1 -> inputKendaraan(in);
                case 2 -> tampilkanDaftarKendaraan();
                case 3 -> inputSewa(in);
                case 4 -> inputKembalikan(in);
                case 5 -> System.out.println("Terima kasih telah menggunakan Rental Kami!");
                default -> System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 5);
    }

    private void inputKendaraan(Scanner in) {
        System.out.print("Pilih jenis kendaraan (mobil/motor): ");
        String jenis = in.nextLine().trim().toLowerCase();
        System.out.print("Masukkan kode kendaraan: ");
        String kode = in.nextLine().trim();
        System.out.print("Masukkan nama kendaraan: ");
        String nama = in.nextLine().trim();
        double harga = 0;
        try {
            System.out.print("Masukkan harga sewa per hari: ");
            harga = Double.parseDouble(in.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Harga tidak valid.");
            return;
        }

        if (jenis.equals("mobil")) {
            int kursi = 0;
            try {
                System.out.print("Masukkan kapasitas kursi: ");
                kursi = Integer.parseInt(in.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Jumlah kursi tidak valid.");
                return;
            }
            tambahKendaraan(new Mobil(kode, nama, harga, kursi));

        } else if (jenis.equals("motor")) {
            System.out.print("Masukkan jenis transmisi (Matik/Manual): ");
            String transmisi = in.nextLine().trim();
            tambahKendaraan(new Motor(kode, nama, harga, transmisi));
        } else {
            System.out.println("Jenis kendaraan tidak dikenali. Gunakan 'mobil' atau 'motor'.");
        }
    }

    private void inputSewa(Scanner in) {
        System.out.print("Masukkan kode kendaraan yang ingin disewa: ");
        String kode = in.nextLine().trim();
        int lama = 0;
        try {
            System.out.print("Masukkan durasi sewa (dalam hari): ");
            lama = Integer.parseInt(in.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Durasi tidak valid.");
            return;
        }

        try {
            sewaKendaraan(kode, lama);
        } catch (KendaraanTidakTersediaException e) {
            System.out.println("\nException in thread \"main\" " + e.getClass().getName()
                    + ": " + e.getMessage());
            System.out.println("\tat GoDriveRentalSystem.sewaKendaraan(GoDriveRentalSystem.java)");
            System.out.println("\tat Main.menuGoDrive(Main.java)");
            System.out.println("\tat Main.main(Main.java)");
        }
    }
    private void inputKembalikan(Scanner in) {
        System.out.print("Masukkan kode kendaraan yang ingin dikembalikan: ");
        String kode = in.nextLine().trim();
        kembalikanKendaraan(kode);
    }
}
