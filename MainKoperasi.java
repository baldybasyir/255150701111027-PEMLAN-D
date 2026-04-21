package praktikum.tpraktikumInterface;
import java.util.Scanner;
 
public class MainKoperasi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== KOPERASI NV. MENEER ===\n");
        System.out.print("No. Registrasi : ");
        int noReg = input.nextInt(); input.nextLine();
        System.out.print("Nama           : ");
        String nama = input.nextLine();
        System.out.print("Gaji Per Bulan : ");
        int gaji = input.nextInt();
        System.out.print("Jumlah Belanja : ");
        int n = input.nextInt(); input.nextLine();
  
        Invoice[] invoices = new Invoice[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nBelanja #" + (i + 1));
            System.out.print("  Nama Produk  : ");
            String produk = input.nextLine();
            System.out.print("  Qty          : ");
            int qty = input.nextInt();
            System.out.print("  Harga/item   : ");
            int harga = input.nextInt(); input.nextLine();
            invoices[i] = new Invoice(produk, qty, harga);
        }
 
        Employee emp = new Employee(noReg, nama, gaji, invoices);
        System.out.println("\n========== SLIP GAJI ==========");
        System.out.println("No. Reg  : " + emp.registrationNumber);
        System.out.println("Nama     : " + emp.name);
        System.out.println("Gaji     : Rp " + emp.salaryPerMonth);
 
        System.out.println("\n--- Detail Belanja Koperasi ---");
        for (Invoice inv : emp.invoices) {
            System.out.println("  " + inv.productName + " x" + inv.quantity
                + " // Rp" + inv.pricePerItem
                + " = Rp " + inv.getPayableAmount());
        }
 
        System.out.println("\nTotal Belanja : Rp " + emp.getTotalBelanja());
        System.out.println("Gaji Bersih   : Rp " + emp.getPayableAmount());
        System.out.println("================================");
 
        input.close();
    }
}
 