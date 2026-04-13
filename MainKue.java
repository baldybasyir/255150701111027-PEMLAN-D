package praktikum.praktikumabstract;

public class MainKue {
    public static void main(String[] args) {
        KuePesanan pesenan = new KuePesanan("Brownies", 5000, 1.5);
        KueJadi brownies = new KueJadi("Brownies" ,5000, 2);
        ArrayKue arrayKue = new ArrayKue();
        
        System.out.println(pesenan);
        System.out.println(brownies + "\n");
        System.out.println(arrayKue);
    }
}