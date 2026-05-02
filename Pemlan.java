public class Pemlan extends MataKuliah {
    public Pemlan() {
        super("Pemlan");
    }

    // nilai akhir UTS 25%, UAS 25%, Tugas 30%, Kuis 20%
    @Override
    public double hitungNilaiAkhir() {
        return (nilaiUts * 0.25) + (nilaiUas * 0.25) + (nilaiTugas * 0.30) + (nilaiKuis * 0.20);
    }
    
}
