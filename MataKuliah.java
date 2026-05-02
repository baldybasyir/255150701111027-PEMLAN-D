public abstract class MataKuliah {
    protected String nama;
    protected int nilaiUts;
    protected int nilaiUas;
    protected int nilaiTugas;
    protected int nilaiKuis;

    public MataKuliah(String namaMatkul) {
        this.nama = namaMatkul;
    }

    public String getNama() {
        return nama;
    }
    public void setNilai (int nilaiUts, int nilaiUas, int nilaiTugas, int nilaiKuis) {
        this.nilaiUts = nilaiUts;
        this.nilaiUas = nilaiUas;
        this.nilaiTugas = nilaiTugas;
        this.nilaiKuis = nilaiKuis;
    }
    public abstract double hitungNilaiAkhir();

    public String getGrade() {
        double nilaiAkhir = hitungNilaiAkhir();
        if (nilaiAkhir >= 85) {
            return "A";
        } else if (nilaiAkhir >= 70) {
            return "B";
        } else if (nilaiAkhir >= 55) {
            return "C";
        } else if (nilaiAkhir >= 40) {
            return "D";
        } else {
            return "E";
        }
    }
}
