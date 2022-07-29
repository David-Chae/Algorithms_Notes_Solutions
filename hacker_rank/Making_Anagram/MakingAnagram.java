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
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static int makeAnagram(String a, String b) {
    // Write your code here
        int[] a_freq = new int[26];
        int[] b_freq = new int[26];
        int count = 0;
        
        for(int i = 0; i < a.length(); i++){
            char c = a.charAt(i);
            int index = (int)c-97;
            a_freq[index]+=1;
        }
        
        for(int i = 0; i < b.length(); i++){
            char c = b.charAt(i);
            int index = (int)c-97;
            b_freq[index]+=1;
        }
        
        for(int i = 0; i < 26; i++){
            count += Math.abs(a_freq[i] - b_freq[i]); 
        }
        
        return count;

    }

}

public class MakingAnagram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = Result.makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
