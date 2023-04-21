package bg.rumen.shoptask.workers;

import bg.rumen.shoptask.workers.interfaces.Worker;

public class MarketingSpecialist implements Worker {

    private double budget = 5000.00;

    public MarketingSpecialist() {
    }

    public void spendMoney(double marketingCampaignCost) {
        this.budget -= Math.max(marketingCampaignCost, 0);
    }

    @Override
    public double getBudget() {
        return this.budget;
    }
}
