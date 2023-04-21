package bg.rumen.rabbittask;

import bg.rumen.util.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rabbit {
    public static void main(String[] args) {

        try {
            solve();
        } catch (FileNotFoundException e) {
            Logger.log(e.getMessage());
        }

    }

    private static void solve() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/rabbittask/first.txt"));

        int dimensions = Integer.parseInt(scanner.nextLine());

        char[][] garden = new char[dimensions][dimensions];

        fillGarden(garden, dimensions);
        getCarrots(scanner, garden);

        printGarden(garden);
        int count = getCountLeaps(garden, dimensions);
        Logger.log(count + "");
    }



    private static int getCountLeaps(char[][] garden, int dimensions) {
        List<int[]> coordinatesOfCarrots = getCoordinatesOfCarrots(garden, dimensions);
        List<int[]> grouper = new ArrayList<>();
        for (int[] currentCoordinates : coordinatesOfCarrots) {
            int row = currentCoordinates[0];
            int col = currentCoordinates[1];
            garden[row][col] = '_';

            boolean isEmpty = true;
            for (int rowIndex = row - 1; rowIndex <= row + 1; rowIndex++) {
                for (int colIndex = col - 1; colIndex <= col + 1; colIndex++) {
                    if (areValidIndexes(garden, rowIndex, colIndex) && !checkForEmptyField(garden, rowIndex, colIndex)) {
                        isEmpty = false;
                        break;
                    }
                }
            }
            if (isEmpty) {
                int[] coordinates = {row, col};
                grouper.add(coordinates);
            }
        }

        return grouper.size();
    }

    private static List<int[]> getCoordinatesOfCarrots(char[][] garden, int dimensions) {
        List<int[]> coordinatesOfCarrots = new ArrayList<>();

        for (int row = 0; row < dimensions; row++) {
            for (int col = 0; col < dimensions; col++) {

                if (garden[row][col] == 'C') {
                    int[] coordinates = {row, col};
                    coordinatesOfCarrots.add(coordinates);
                }
            }
        }
        return coordinatesOfCarrots;
    }



    private static void fillGarden(char[][] garden, int dimensions) {
        for (int row = 0; row < dimensions; row++) {
            for (int col = 0; col < dimensions; col++) {
                garden[row][col] = '_';
            }
        }
    }

    private static void getCarrots(Scanner scanner, char[][] garden) {
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] coordinates = command.split("\s+");
            int inputRow = Integer.parseInt(coordinates[0]);
            int inputCol = Integer.parseInt(coordinates[1]);

            if (areValidIndexes(garden, inputRow, inputCol)) {
                garden[inputRow][inputCol] = 'C';
            }

            command = scanner.nextLine();
        }
    }


    private static void printGarden(char[][] garden) {
        for (char[] row : garden) {
            String line = "";
            for (char symbol : row) {
                line = line.concat(symbol + "");
            }
            Logger.log(line);
        }
    }


    private static boolean areValidIndexes(char[][] garden, int row, int col) {
        return row >= 0 && row < garden.length && col >= 0 && col < garden[row].length;
    }

    private static boolean checkForEmptyField(char[][] garden, int row, int col) {
        return garden[row][col] == '_';
    }
}
