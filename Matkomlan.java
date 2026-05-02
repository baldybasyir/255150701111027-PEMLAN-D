public class Matkomlan extends MataKuliah {
    public Matkomlan() {
        super("Matkomlan");
    }
    // nilai akhir UTS 20%, UAS 20% Tugas 30%, Kuis 30%
    @Override
    public double hitungNilaiAkhir() {
        return (nilaiUts * 0.20) + (nilaiUas * 0.20) + (nilaiTugas * 0.30) + (nilaiKuis * 0.30);
    }
    
}
