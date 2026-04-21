package praktikum.tpraktikumInterface;

public class Employee implements Payable {
    int registrationNumber;
    String name;
    int salaryPerMonth;
    Invoice[] invoices;
 
    public Employee(int registrationNumber, String name, int salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }
 
    // Total semua belanja di koperasi
    public int getTotalBelanja() {
        int total = 0;
        for (Payable p : invoices) {   // <-- POLIMORFISME
            total += p.getPayableAmount();
        }
        return total;
    }
 
    @Override
    public int getPayableAmount() {
        return salaryPerMonth - getTotalBelanja(); // gaji bersih
    }
}
 