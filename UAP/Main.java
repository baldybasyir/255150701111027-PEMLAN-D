import java.util.*;

public class Main {
    public static void main(String[] args) {
        RentalSistem system = new RentalSistem();
        system.tambahKendaraan(new Mobil("MBL01", "Toyota Supra", 3500000, 7));
        system.tambahKendaraan(new Mobil("MBL02", "Mustang", 1000000, 7));
        system.tambahKendaraan(new Mobil("MBL03", "Honda Civic Type R", 500000, 5));
        system.tambahKendaraan(new Motor("MTR01", "Vario 250 CC", 200000, "Matik"));
        system.tambahKendaraan(new Motor("MTR02", "Mio Mierza", 100000, "Matik"));
        system.tambahKendaraan(new Motor("MTR03", "Kawasaki ZX06", 200000, "Manual"));
        Scanner scanner = new Scanner(System.in);
        system.menuGoDrive(scanner);
        scanner.close();
    }
}
