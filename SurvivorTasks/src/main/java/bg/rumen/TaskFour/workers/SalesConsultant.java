package bg.rumen.TaskFour.workers;

import bg.rumen.TaskFour.workers.interfaces.Worker;

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
