package bg.rumen.TaskFour;

public class MarketingSpecialist implements Worker {

    private Shop workingShop;
    private double budget = 5000.00;

    public MarketingSpecialist() {
        this.workingShop = Shop.getInstance();
    }

    @Override
    public void moneyAction(double price) {
        this.budget -= Math.max(price, 0);
    }

    @Override
    public double getBudget() {
        return this.budget;

    }
}
