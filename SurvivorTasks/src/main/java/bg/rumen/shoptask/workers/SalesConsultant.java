package bg.rumen.shoptask.workers;

import bg.rumen.shoptask.workers.interfaces.Worker;

public class SalesConsultant implements Worker {

    private double earnedMoney;

    public SalesConsultant() {
    }

    public void sellProduct(double price) {
        this.earnedMoney += Math.max(price, 0);
    }

    @Override
    public double getBudget() {
        return this.earnedMoney;
    }
}
