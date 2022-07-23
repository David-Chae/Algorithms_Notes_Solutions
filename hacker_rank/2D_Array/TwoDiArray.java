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
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
    // Write your code here
    
        int total = Integer.MIN_VALUE;
        //Iterate through all rows except last two rows.
        for(int i = 0; i < arr.size()-2; i++){
            //Iterate through all columns except last two columns.
            for(int j = 0; j< arr.get(i).size()-2; j++){
                int sum = 0;
                sum += arr.get(i).get(j).intValue();//Add top left number.
                sum += arr.get(i).get(j+1).intValue();//Add top middle number.
                sum += arr.get(i).get(j+2).intValue();//Add top right number.
                sum += arr.get(i+1).get(j+1).intValue();//Add middle middle number.
                sum += arr.get(i+2).get(j).intValue();//Add bottom left number.
                sum += arr.get(i+2).get(j+1).intValue();//Add bottom middle number.
                sum += arr.get(i+2).get(j+2).intValue();//Add bottom right number.
                if(total < sum) total = sum; 
            }
        }
        return total;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
