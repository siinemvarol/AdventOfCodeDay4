import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<String> lines = new ArrayList<>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("day4.txt"));
            String line = reader.readLine();

            while (line != null) {
                String[] splitted = line.split(" ");
                lines.add(Arrays.toString(splitted));
                line = reader.readLine();
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println(lines);

        int xmasCounter = 0;

        int horizontalCounter = 0;
        int backwardsCounter = 0;
        int verticalCounter = 0;
        int diagonalCounter = 0;

        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {

                // horizontal
                if (j < lines.get(i).length() - 3
                        && lines.get(i).charAt(j) == 'X'
                        && lines.get(i).charAt(j + 1) == 'M'
                        && lines.get(i).charAt(j + 2) == 'A'
                        && lines.get(i).charAt(j + 3) == 'S') {
                    xmasCounter++;
                    horizontalCounter++;
                }

                // backwards
                if (j >= 3
                        && lines.get(i).charAt(j) == 'X'
                        && lines.get(i).charAt(j - 1) == 'M'
                        && lines.get(i).charAt(j - 2) == 'A'
                        && lines.get(i).charAt(j - 3) == 'S') {
                    xmasCounter++;
                    backwardsCounter++;
                }

                // vertical
                // downwards
                if (i < lines.size() - 3
                        && lines.get(i).charAt(j) == 'X'
                        && lines.get(i + 1).charAt(j) == 'M'
                        && lines.get(i + 2).charAt(j) == 'A'
                        && lines.get(i + 3).charAt(j) == 'S') {
                    xmasCounter++;
                    verticalCounter++;
                }

                // upwards
                if (i >= 3
                        && lines.get(i).charAt(j) == 'X'
                        && lines.get(i - 1).charAt(j) == 'M'
                        && lines.get(i - 2).charAt(j) == 'A'
                        && lines.get(i - 3).charAt(j) == 'S') {
                    xmasCounter++;
                    verticalCounter++;
                }

                // diagonal
                // diagonal - top left
                if (i >= 3
                        && j >= 3
                        && lines.get(i).charAt(j) == 'X'
                        && lines.get(i - 1).charAt(j - 1) == 'M'
                        && lines.get(i - 2).charAt(j - 2) == 'A'
                        && lines.get(i - 3).charAt(j - 3) == 'S') {
                    xmasCounter++;
                    diagonalCounter++;
                }

                // diagonal - top right
                if (i >= 3
                        && j < lines.get(i).length() - 3
                        && lines.get(i).charAt(j) == 'X'
                        && lines.get(i - 1).charAt(j + 1) == 'M'
                        && lines.get(i - 2).charAt(j + 2) == 'A'
                        && lines.get(i - 3).charAt(j + 3) == 'S') {
                    xmasCounter++;
                    diagonalCounter++;
                }

                // diagonal - bottom left
                if (i < lines.size() - 3
                        && j >= 3
                        && lines.get(i).charAt(j) == 'X'
                        && lines.get(i + 1).charAt(j - 1) == 'M'
                        && lines.get(i + 2).charAt(j - 2) == 'A'
                        && lines.get(i + 3).charAt(j - 3) == 'S') {
                    xmasCounter++;
                    diagonalCounter++;
                }

                // diagonal - bottom right
                if (i < lines.size() - 3
                        && j < lines.get(i).length() - 3
                        && lines.get(i).charAt(j) == 'X'
                        && lines.get(i + 1).charAt(j + 1) == 'M'
                        && lines.get(i + 2).charAt(j + 2) == 'A'
                        && lines.get(i + 3).charAt(j + 3) == 'S') {
                    xmasCounter++;
                    diagonalCounter++;
                }

            }
        }

        System.out.println("Total XMAS counter is... " + xmasCounter);
        System.out.println("Horizontal: " + horizontalCounter);
        System.out.println("Backwards: " + backwardsCounter);
        System.out.println("Vertical: " + verticalCounter);
        System.out.println("Diagonal: " + diagonalCounter);

    }
}