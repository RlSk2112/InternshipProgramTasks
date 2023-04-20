import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FirstTask {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);

//        Color: count

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/input"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/output"));

            Map<String, Integer> colorsMap = new HashMap<>();

            String command = bufferedReader.readLine();
            while (!command.equals("End")) {
                String[] commandLine = command.split(": ");
                String currentColor = commandLine[0];
                int currentCount = Integer.parseInt(commandLine[1]);

                colorsMap.putIfAbsent(currentColor, 0);
                int newCount = colorsMap.get(currentColor) + currentCount;
                colorsMap.put(currentColor, newCount);

                command = bufferedReader.readLine();
            }

            int max = 0;
            if (colorsMap.size() > 0) {
                max = colorsMap.values().stream().max(Comparator.comparingInt(f -> f)).get();
            }

            int sum = 0;
            for (Map.Entry<String, Integer> entry : colorsMap.entrySet()) {
                    sum += entry.getValue();
            }


            bufferedWriter.write(String.format("%d", sum - max));

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
