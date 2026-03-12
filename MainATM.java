package semester2;
import java.util.Scanner;

class ATM {
    private String nama;
    private String noRekening;
    protected String password;
    private double saldo;

    public void setNama(String nama) {
            this.nama = nama;
        } 

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNama() {
        return nama;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public double getSaldo() {
        return saldo;
    }
    public String getPassword() {
        return password;
    }

    public boolean tarikTunai(double jumlah) {
        if (jumlah <= saldo) {
            saldo -= jumlah;
            return true;
        } else {
            return false;
        }
    }
    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tarik Tunai");
        System.out.println("2. Cek Saldo");
        System.out.println("3. Keluar");

    }

}
public class MainATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ATM atm = new ATM();
        System.out.println("Selamat datang di ATM!");
        String nama;
        do {
        System.out.print("Masukkan nama: ");
        nama = input.nextLine();
        if (nama.length() < 4) {
            System.out.println("Nama harus memiliki minimal 4 karakter.");
            System.out.print("Masukkan nama: ");
            nama = input.nextLine();
        }
    } while (nama.length() < 4);
        atm.setNama(nama);
        String noRekening;
        do {
        System.out.print("Masukkan nomor rekening: ");
         noRekening = input.nextLine();
        if (noRekening.length() < 10) {
            System.out.println("Nomor rekening harus memiliki minimal 10 digit.");
            System.out.print("Masukkan nomor rekening: ");
            noRekening = input.nextLine();
        }
    } while (noRekening.length() < 10);
        atm.setNoRekening(noRekening);
            String password;
        do {
        System.out.print("Masukkan password: ");
        password = input.nextLine();
        if (password.length() < 8 || !password.matches(".*[A-Z].*") || !password.contains("_")) {
            System.out.println("Password harus memiliki minimal 8 karakter, satu huruf besar, dan satu karakter '_'.");
            System.out.print("Masukkan password: ");
            password = input.nextLine();
        }
    } while (password.length() < 8 || !password.matches(".*[A-Z].*") || !password.contains("_"));
        atm.setPassword(password);

        System.out.print("Masukkan saldo awal: ");
        double saldo = input.nextDouble();
        atm.setSaldo(saldo);

        System.out.println("\nAkun berhasil dibuat!");
        System.out.println("\nInformasi Akun:");
        System.out.println("Nama: " + atm.getNama());
        System.out.println("Nomor Rekening: " + atm.getNoRekening());
        System.out.println("Saldo: " + atm.getSaldo());

        boolean kondisi = true;
        do {
            atm.displayMenu();
            System.out.print("Pilih menu: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    input.nextLine();
                    System.out.print("Masukkan password: ");
                String enteredPassword = input.nextLine();
                if (!enteredPassword.equals(atm.getPassword())) {
                    System.out.println("Password salah.");
                    break;
                }
                System.out.print("\nMasukkan jumlah tarik tunai: ");
                double tarikTunai = input.nextDouble();
                if (atm.tarikTunai(tarikTunai)) {
                    System.out.println("Tarik tunai berhasil. Sisa saldo: " + atm.getSaldo());
                } else {
                    System.out.println("Tarik tunai gagal. Saldo tidak mencukupi.");
                }
                break;
            case 2:
                input.nextLine();
                System.out.print("Masukkan password: ");
                String enteredPassword2 = input.nextLine();
                if (!enteredPassword2.equals(atm.getPassword())) {
                    System.out.println("Password salah!");
                    break;
                }
                System.out.println("Saldo Anda: " + atm.getSaldo());
                break;
            case 3:
                System.out.println("Terima kasih telah menggunakan layanan ATM.");
                kondisi = false;
                break;
                default:
                System.out.println("Pilihan tidak valid.");
        }
    } while (kondisi);
}
}
