package bg.rumen.TaskFour;

import bg.rumen.TaskFour.shop.Shop;
import bg.rumen.TaskFour.workers.MarketingSpecialist;
import bg.rumen.TaskFour.workers.SalesConsultant;
import bg.rumen.TaskFour.workers.interfaces.Worker;

public class Main {
    public static void main(String[] args) {
        Shop shop = Shop.getInstance();

        Worker salesConsultant = new SalesConsultant();
        Worker marketingSpecialist = new MarketingSpecialist();

        SalesConsultant salesConsultant1 = new SalesConsultant();
        salesConsultant1.sellProduct(200.50);

        MarketingSpecialist marketingSpecialist1 = new MarketingSpecialist();
        marketingSpecialist1.spendMoney(3200);


        shop.addWorker(marketingSpecialist1);
        shop.addWorker(salesConsultant1);
        shop.addWorker(salesConsultant);
        shop.addWorker(marketingSpecialist);

        double turnOver = shop.getTurnover();

        System.out.println(turnOver);

    }
}
