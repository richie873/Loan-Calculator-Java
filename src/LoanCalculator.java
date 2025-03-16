import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);

        // Input
        System.out.print("Masukkan harga mobil (OTR): Rp. ");
        double otr = data.nextDouble();

        System.out.print("Masukkan DP (%): ");
        double dp = data.nextDouble();

        System.out.print("Masukkan jangka waktu (bulan): ");
        int bulan = data.nextInt();

        // Hitung pokok utang
        double dpTotal = (dp / 100) * otr;
        double pokokUtang = otr - dpTotal;
        System.out.println("\n==== Pokok Hutang ====");
        System.out.println("DP = " + String.format("%,.0f",dp) + " / " + 100 + " * " + String.format("%,.0f",otr) + " = " + String.format("%,.0f", dp / 100 * otr));
        System.out.println("Pokok Utang = " + String.format("%,.0f",otr) + " - " + String.format("%,.0f",dpTotal) + " = " +String.format("%,.0f", otr - dpTotal));

        // Tentukan bunga
        double bunga;
        if (bulan <= 12) {
            bunga = 0.12;
        } else if (bulan <= 24) {
            bunga = 0.14;
        } else {
            bunga = 0.165;
        }

        // Hitung angsuran per bulan
        double pokokPerBulan = pokokUtang / bulan;
        double bungaPerBulan = pokokUtang * bunga / 12;
        double angsuranPerBulan = pokokPerBulan + bungaPerBulan;
        System.out.println("\n==== Angsuran Perbulan ====");
        System.out.println("Pokok Perbulan: " + String.format("%,.0f", pokokUtang) + " / " + bulan + " (Bulan) " + " = " + String.format("%,.0f", pokokPerBulan));
        System.out.println("Bunga Perbulan: " + String.format("%,.0f", pokokUtang) + " * " + bunga + " / " + "12" + " = " + String.format("%,.0f", bungaPerBulan));

        // Output hasil
        System.out.println("\n==== Hasil ====");
        System.out.println("Pokok Utang: Rp " + String.format("%,.0f", pokokUtang));
        System.out.println("Bunga: " + String.format("%.1f", bunga * 100) + "%");
        System.out.println("Pokok Perbulan: " + String.format("%,.0f", pokokPerBulan));
        System.out.println("Bunga Perbulan: " + String.format("%,.0f", bungaPerBulan));
        System.out.println("Angsuran Perbulan: Rp " + String.format("%,.0f", angsuranPerBulan));
    }
}