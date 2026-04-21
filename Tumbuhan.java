package praktikum.praktikuminterfacebaru;
public class Tumbuhan implements MakhlukHidup, Identitas {
    private String nama;
    private int umur;

    public Tumbuhan(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    @Override
    public void makan() {
        System.out.println("Menyerap nutrisi lewat akar");
    }
    @Override
    public void berjalan() {
        System.out.println("Tidak bisa berjalan");
    }
    @Override
    public void bersuara() {
        System.out.println("Tidak bisa bersuara");
    }
    @Override
    public void tampilkanNama() {
        System.out.println("Nama  : " + this.nama);
    }
    @Override
    public void tampilkanUmur() {
        System.out.println("Umur  : " + this.umur + " tahun");
    }

    public void berfotosintesis() {
        System.out.println("Berfotosintesis menggunakan sinar matahari");
    }
}