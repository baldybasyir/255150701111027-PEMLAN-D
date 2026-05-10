import java.io.File;
public class UkuranFile {
    public static void main(String[] args) {
        var namaFile = args.length > 0 ? args[0] : "test.txt";
        var file = new File(namaFile);

        if (!file.exists()) {
            System.out.println("File tidak ditemukan: " + namaFile);
            return;
        }
        long ukuranBytes = file.length();
        double ukuranKB  = ukuranBytes / 1024.0;
        double ukuranMB  = ukuranBytes / (1024.0 * 1024.0);
        System.out.println("Nama File    : " + file.getName());
        System.out.println("Ukuran Bytes : " + ukuranBytes + " bytes");
        if (ukuranBytes < 1024 * 1024) {
            System.out.printf("Ukuran File  : %.2f KB%n", ukuranKB);
        } else {
            System.out.printf("Ukuran File  : %.2f MB%n", ukuranMB);
        }
    }
}
