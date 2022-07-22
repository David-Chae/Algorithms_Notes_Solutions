import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
    // Write your code here
        int total = 0;
        int n = matrix.size()/2;
        int len = matrix.size();
        int max = 0;
        
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                max = Integer.MIN_VALUE;
                int num1 = matrix.get(row).get(col).intValue();
                int num2 = matrix.get(row).get(len-col-1).intValue();
                int num3 = matrix.get(len-row-1).get(col).intValue();
                int num4 = matrix.get(len-row-1).get(len-col-1).intValue();
                
                if(num1 > max) max = num1;
                if(num2 > max) max = num2;
                if(num3 > max) max = num3;
                if(num4 > max) max = num4;
                total+=max;
            }
        }
        return total;
    }

}

public class FlippingMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = Result.flippingMatrix(matrix);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
