package praktikuminheritance;

public class Manusia {
    private String nama;
    private boolean jenisKelamin = true;
    private String Nik;
    private boolean menikah = true;

    public Manusia (String nama, boolean jeniskelamin, String Nik, boolean menikah) {
        this.nama = nama;
        this.jenisKelamin = jeniskelamin;
        this.Nik = Nik;
        this.menikah = menikah;
    }
    // Manusia
    public double getTunjangan() {
        double tunjangan = 0;
        if (menikah) {
        if (jenisKelamin) {
            tunjangan += 25;
        } else if (!jenisKelamin) {
            tunjangan += 20;
        }
    } else {
        tunjangan += 15;
    }
        return tunjangan;
    }
    public boolean isJenisKelamin() {
        return jenisKelamin;
    }

    public double getPendapatan() {
        return getTunjangan();
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setJenisKelamin(boolean jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    public void setNik (String Nik) {
        this.Nik = Nik;
    }
    public String getNik () {
        return Nik;
    }
    public void setMenikah(boolean menikah) {
        this.menikah =  menikah;
    }
    @Override
    public String toString() {
        return String.format(
            "Nama           : %s\n" +
            "Nik            : %s\n" +
            "Jenis Kelamin  : %s\n" + 
            "Pendapatan     : $%,.2f\n", nama, Nik,
            jenisKelamin ? "Laki-laki" : "Perempuan", 
            getPendapatan()
        );
}

}