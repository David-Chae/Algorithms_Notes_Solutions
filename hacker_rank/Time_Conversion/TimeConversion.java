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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
        String[] parts = s.split(":");
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);
        String last = parts[parts.length-1];
        int seconds = Integer.parseInt(last.substring(0,last.length()/2));
        String amPm = last.substring(last.length()/2, last.length());
        
        String military = "";
        if(amPm.compareTo("PM") == 0){
            military = String.format("%02d:%02d:%02d", (hour+12), min, seconds);
            if(hour == 12) military = String.format("%02d:%02d:%02d", (hour), min, seconds);
        }
        
        if(amPm.compareTo("AM") == 0){
            military = String.format("%02d:%02d:%02d", (hour-12), min, seconds);
            if(hour < 12) military = String.format("%02d:%02d:%02d", hour, min, seconds);
        }
        
        return military;

    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
