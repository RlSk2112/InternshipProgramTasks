package bg.rumen.TaskTwo;

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());

        char[][] garden = new char[dimensions][dimensions];


        fillGarden(garden, dimensions);
        garden[0][0] = 'R';


//        put more carrots for bigger garden with dimensions like 10x10
//        if (dimensions > 4) {
//            garden[3][3] = 'C';
//            garden[3][4] = 'C';
//            garden[4][3] = 'C';
//            garden[4][4] = 'C';
//        }



        printGarden(garden);
        int count = getCountLeaps(garden);
        System.out.println(count);
    }

    private static int getCountLeaps(char[][] garden) {
        int count = 1;

        for (int row = 0; row < garden.length - 1; row++) {
            for (int col = 0; col < garden[row].length - 1; col++) {
                if (garden[row][col] == 'C'
                        && garden[row][col + 1] == '_'
                        && garden[row + 1][col] == '_') {
                    count++;
                }
            }
        }
        return count;
    }


    public static void fillGarden(char[][] garden, int dimensions) {
        for (int row = 0; row < dimensions; row++) {
            for (int col = 0; col < dimensions; col++) {
                garden[row][col] = putSymbol(dimensions, row, col);
            }
        }
    }


    public static void printGarden(char[][] garden) {
        for (char[] row : garden) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }


    public static char putSymbol(int dimensions, int rowToCheck, int colToCheck) {
        char symbol = '_';
        boolean firstGroupCondition = (rowToCheck == 0 || rowToCheck == 1) && (colToCheck == 0 || colToCheck == 1);
        boolean secondGroupCondition = (rowToCheck == dimensions - 2 || rowToCheck == dimensions - 1)
                && (colToCheck == dimensions - 2 || colToCheck == dimensions - 1);

        if (firstGroupCondition || secondGroupCondition) {
            symbol = 'C';
        }
        return symbol;
    }

}
