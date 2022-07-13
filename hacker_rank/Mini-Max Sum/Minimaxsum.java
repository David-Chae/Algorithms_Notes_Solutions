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
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
    
        ListIterator<Integer> iterator = arr.listIterator();
        int[] list = new int[5];
        int count = 0;
        long sum = 0;
        while(iterator.hasNext()){
            int num = iterator.next().intValue();
            list[count++] = num;
            sum+=num;
        }
        
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        
        for(int num : list){
            long runningSum = sum - num;
            min = (min > runningSum) ? runningSum : min;
            max = (max < runningSum) ? runningSum : max;
        }
        
        System.out.println(min + " " + max);

    }

}

public class Minimaxsum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
