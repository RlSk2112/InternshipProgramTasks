package bg.rumen.TaskFour;

import java.util.ArrayList;
import java.util.List;

class Shop {
    private static Shop instance = Shop.getInstance();
    private List<Worker> workers;


    private Shop() {
        this.workers = new ArrayList<>();
    }

    public static synchronized Shop getInstance() {
        if (instance == null) {
            instance = new Shop();
        }

        return instance;
    }


    public void addWorker(Worker worker) {
        this.workers.add(worker);
    }

    public double getTurnover() {
        var turnOver = 0.0;
        for (Worker worker : this.workers) {
                turnOver +=  worker.getBudget();
        }
        return turnOver;
    }
}



