package praktikum.praktikumabstract;
public class ArrayKue {
    public ArrayKue() {
        Kue[] arrKue = new Kue[20];
        arrKue[0] = new KuePesanan("Brownies", 5000, 1.5);
        arrKue[1] = new KueJadi("Green Tea" ,5000, 2);
        arrKue[2] = new KuePesanan("Lapis Legit", 4000, 1.5);
        arrKue[3] = new KueJadi("Lapis Surabaya" ,10000, 2);
        arrKue[4] = new KuePesanan("Lapis Malang", 32000, 1.5);
        arrKue[5] = new KueJadi("Kue Bolu" ,1000, 3);
        arrKue[6] = new KuePesanan("Kue Cubit", 2000, 1.5);
        arrKue[7] = new KueJadi("Kue Sabit" ,3000, 11);
        arrKue[8] = new KuePesanan("Kue Pukis", 2000, 1.5);
        arrKue[9] = new KueJadi("Tiramisu Cake" ,25000, 4);
        arrKue[10] = new KuePesanan("Kue Lumpur", 3500, 1.5);
        arrKue[11] = new KueJadi("Red Velvet" ,40000, 1);
        arrKue[12] = new KuePesanan(" Terang Bulan", 20000, 3);
        arrKue[13] = new KueJadi("Kue Cucur" ,2500, 2);
        arrKue[14] = new KuePesanan("Martabak", 24000, 2);
        arrKue[15] = new KueJadi("Cucur Adabi" ,2000, 3);
        arrKue[16] = new KuePesanan("Kue Warni", 4000, 0.5);
        arrKue[17] = new KueJadi("Choco bomb" ,40000, 1);
        arrKue[18] = new KuePesanan("America Breakfast", 15000, 1.5);
        arrKue[19] = new KueJadi("Sour soup" ,3000, 1);
        double totalHargaSemua = 0;
        double totalHargaPesanan = 0, totalBeratPesanan = 0;
        double totalHargaJadi = 0, totalJumlahJadi = 0;
        Kue kueTermahal = arrKue[0];

        System.out.println("=== LIST KUE ===");
        for (Kue k : arrKue) {
            System.out.println(k);
            double hargaAkhir = k.hitungHarga();
            totalHargaSemua += hargaAkhir;
            if (k instanceof KuePesanan) {
                KuePesanan kp = (KuePesanan) k;
                totalHargaPesanan += hargaAkhir;
                totalBeratPesanan += kp.berat; 
            } else if (k instanceof KueJadi) {
                KueJadi kj = (KueJadi) k;
                totalHargaJadi += hargaAkhir;
                totalJumlahJadi += kj.jumlah;
            }

            if (hargaAkhir > kueTermahal.hitungHarga()) {
                kueTermahal = k;
            }
        }
        System.out.println("\n=== RESUME PERHITUNGAN ===");
        System.out.printf("Total Harga (Semua Jenis)   : Rp %.0f\n", totalHargaSemua);
        System.out.printf("Total Harga Kue Pesanan     : Rp %.0f\n", totalHargaPesanan);
        System.out.printf("Total Berat Kue Pesanan     : %.1f kg\n", totalBeratPesanan);
        System.out.printf("Total Harga Kue Jadi        : Rp %.0f\n", totalHargaJadi);
        System.out.printf("Total Jumlah Kue Jadi       : %.0f pcs\n", totalJumlahJadi);
        
        System.out.println("\n=== KUE DENGAN HARGA TERMAHAL ===");
        System.out.print(kueTermahal);
        System.out.printf("Harga Akhir: Rp %.0f\n", kueTermahal.hitungHarga());
    }
}
