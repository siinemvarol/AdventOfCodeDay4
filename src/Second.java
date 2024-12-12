import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Second {
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

        for (int i = 1; i < lines.size() - 1; i++) {
            for (int j = 1; j < lines.get(i).length() - 1; j++) {

                if (lines.get(i).charAt(j) == 'A') {
                    boolean firstMasCheck = false;
                    boolean secondMasCheck = false;

                    // first MAS
                    if ((lines.get(i-1).charAt(j - 1) == 'M' && lines.get(i+1).charAt(j + 1) == 'S')
                            || (lines.get(i+1).charAt(j + 1) == 'M' && lines.get(i-1).charAt(j - 1) == 'S')) {
                        firstMasCheck = true;
                    }

                    // second MAS
                    if ((lines.get(i+1).charAt(j - 1) == 'M' && lines.get(i-1).charAt(j + 1) == 'S')
                            || (lines.get(i-1).charAt(j + 1) == 'M' && lines.get(i+1).charAt(j - 1) == 'S')) {
                        secondMasCheck = true;
                    }

                    if (firstMasCheck && secondMasCheck) {
                        xmasCounter++;
                    }
                }
            }
        }

        System.out.println("Total X-MAS counter is: " + xmasCounter);

    }
}