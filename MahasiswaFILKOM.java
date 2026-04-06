package praktikuminheritance;

public class MahasiswaFILKOM extends Manusia {
    private String nim;
    private double ipk;
    public MahasiswaFILKOM(String nama, boolean jenisKelamin, String Nik, boolean menikah, String nim, double ipk) {
        super(nama, jenisKelamin, Nik, menikah);
        this.nim = nim;
        this.ipk = ipk;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }
    public void setIpk(double ipk) {
        this.ipk = ipk;
    }
    public String getNim() {
        return nim;
    }
    public double getIpk() {
        return ipk;
    }
    public double getBeasiswa() {
        double totalBeasiswa = 0;
        if (ipk >= 3.0 && ipk <= 3.5) {
            totalBeasiswa += 50;
        } else if (ipk > 3.5 && ipk <= 4.0) {
            totalBeasiswa += 75;
        }
        return totalBeasiswa;
    }
     public String getStatus() {
        String angkatan = "20" + nim.substring(0, 2); // contoh "25" → "2025"
        char prodiCode = nim.charAt(6);
        switch (prodiCode) {
            case '2': return "Teknik Informatika, " + angkatan;
            case '3': return "Teknik Komputer, " + angkatan;
            case '4': return "Sistem Informasi, " + angkatan;
            case '6': return "Pendidikan Teknologi Informasi, " + angkatan;
            case '7': return "Teknologi Informasi, " + angkatan;
            default: return "Prodi tidak diketahui, " + angkatan;
    }
}
    @Override
      public double getPendapatan() { 
        return super.getPendapatan() + getBeasiswa();
    }

    @Override
    public String toString() {
        return super.toString() +
        String.format(
                "NIM            : %s\n" +
                "IPK            : %.2f\n" +
                "Status         : %s\n",
                nim, ipk, getStatus()
            );
    }
}
