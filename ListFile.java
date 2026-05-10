import java.io.File;
public class ListFile {
    public static void main(String[] args) {
        var namaDir = args.length > 0 ? args[0] : ".";
        var dir = new File(namaDir);

        if (!dir.exists()) {
            System.out.println("Direktori tidak ditemukan: " + namaDir);
            return;
        }
        if (!dir.isDirectory()) {
            System.out.println(namaDir + " bukan sebuah direktori!");
            return;
        }

        var daftarFile = dir.listFiles();
        if (daftarFile == null || daftarFile.length == 0) {
            System.out.println("Direktori kosong: " + namaDir);
            return;
        }
        System.out.println("============================================");
        System.out.println("  Isi Direktori: " + dir.getAbsolutePath());
        System.out.println("============================================");
        int jumlahFile = 0;
        int jumlahFolder = 0;

        for (var file : daftarFile) {
            if (file.isDirectory()) {
                System.out.println("[DIR]  " + file.getName());
                jumlahFolder++;
            } else {
                System.out.println("[FILE] " + file.getName());
                jumlahFile++;
            }
        }
        System.out.println("--------------------------------------------");
        System.out.println("Total: " + jumlahFile + " file, " + jumlahFolder + " folder");
    }
}