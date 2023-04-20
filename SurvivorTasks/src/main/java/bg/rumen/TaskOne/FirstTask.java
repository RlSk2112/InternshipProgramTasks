package bg.rumen.TaskOne;
import bg.rumen.util.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FirstTask {
    public static void main(String[] args) {
        try {
            solve();
        } catch (FileNotFoundException e) {
            Logger.log(e.getMessage());
        }
    }


    public static void solve() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/resourcesTaskOne/input.txt"));

        Map<String, Integer> colorsMap = new HashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandLine = command.split(": ");
            String currentColor = commandLine[0];
            int currentCount = Integer.parseInt(commandLine[1]);

            colorsMap.putIfAbsent(currentColor, 0);
            int newCount = colorsMap.get(currentColor) + currentCount;
            colorsMap.put(currentColor, newCount);

            command = scanner.nextLine();
        }

        int max = 0;
        if (colorsMap.size() > 0) {
            max = colorsMap.values().stream().max(Comparator.comparingInt(f -> f)).get();
        }

        int sum = 0;
        for (Map.Entry<String, Integer> entry : colorsMap.entrySet()) {
            sum += entry.getValue();
        }

        Logger.log(String.format("%d", sum - max));
        scanner.close();
    }
}
