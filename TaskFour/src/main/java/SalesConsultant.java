public class SalesConsultant implements Worker {

    private Shop workingShop;
    private double earnedMoney;

    public SalesConsultant() {
        this.workingShop = Shop.getInstance();
    }

    @Override
    public void moneyAction(double price) {
        this.earnedMoney += Math.max(price, 0);
    }

    @Override
    public double getBudget() {
        return this.earnedMoney;
    }
}
