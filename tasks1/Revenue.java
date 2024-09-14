import java.util.Scanner;

public class Revenue {
    public static double calculateRevenue(int ticketsSold, double ticketPrice, double commission) {
        double commissionPerTicket = ticketPrice * commission;
        double ticketPriceWithCommission = ticketPrice - commissionPerTicket;
        return ticketsSold * ticketPriceWithCommission;
    }
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int ticketsSold = console.nextInt();
        double ticketPrice = console.nextDouble();
        double commission = console.nextDouble();
        double totalRevenue = calculateRevenue(ticketsSold, ticketPrice, commission);
        System.out.println("Общая выручка : " + totalRevenue);
    }
}