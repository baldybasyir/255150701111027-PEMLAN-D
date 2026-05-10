import java.io.File;
public class HapusDirectory {
    public static void main(String[] args) {
        var namaDir = args.length > 0 ? args[0] : "ProsesPenghapusan";
        var dir = new File(namaDir);
        if (!dir.exists()) {
            System.out.println("Direktori tidak ditemukan: " + namaDir);
            return;
        }
        if (!dir.isDirectory()) {
            System.out.println(namaDir + " bukan sebuah direktori!");
            return;
        }
        System.out.println("  Menghapus Direktori: " + dir.getAbsolutePath());
        var daftarFile = dir.listFiles();
        if (daftarFile != null) {
            for (var file : daftarFile) {
                if (file.delete()) {
                    System.out.println("[HAPUS] " + file.getName());
                } else {
                    System.out.println("[GAGAL] " + file.getName());
                }
            }
        }
        if (dir.delete()) {
            System.out.println("--------------------------------------------");
            System.out.println("Direktori '" + namaDir + "' berhasil dihapus!");
        } else {
            System.out.println("--------------------------------------------");
            System.out.println("Gagal menghapus direktori: " + namaDir);
        }
    }
}