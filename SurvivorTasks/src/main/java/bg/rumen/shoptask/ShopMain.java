package bg.rumen.shoptask;

import bg.rumen.shoptask.shop.Shop;
import bg.rumen.shoptask.workers.MarketingSpecialist;
import bg.rumen.shoptask.workers.SalesConsultant;
import bg.rumen.shoptask.workers.interfaces.Worker;

public class ShopMain {
    public static void main(String[] args) {
        Shop shop = Shop.getInstance();

        Worker salesConsultant = new SalesConsultant();
        Worker marketingSpecialist = new MarketingSpecialist();

        shop.addWorker(salesConsultant);
        shop.addWorker(marketingSpecialist);

        double turnOver = shop.getTurnover();

        System.out.println(turnOver);

    }
}
