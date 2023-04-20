package bg.rumen.TaskFour;

public class Main {
    public static void main(String[] args) {
        Shop shop = Shop.getInstance();

        Worker salesConsultant = new SalesConsultant();
        Worker marketingSpecialist = new MarketingSpecialist();

        salesConsultant.moneyAction(500);
        marketingSpecialist.moneyAction(1000);

        shop.addWorker(salesConsultant);
        shop.addWorker(marketingSpecialist);

        double turnOver = shop.getTurnover();

        System.out.println(turnOver);

    }
}
