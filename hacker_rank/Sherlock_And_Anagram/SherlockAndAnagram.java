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
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
    // Write your code here
        HashMap<String, Integer> substringMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j < s.length()+1; j++){
                char[] arr = s.substring(i,j).toCharArray();
                Arrays.sort(arr);
                String key = new String(arr);
                if(substringMap.containsKey(key)){
                    substringMap.put(key, substringMap.get(key)+1);
                }else{
                    substringMap.put(key, 1);
                }
            }
        }
        
        int res = 0;
        
        for(String key : substringMap.keySet()){
            if(substringMap.get(key) > 1){
                int num = substringMap.get(key).intValue();
                while(num > 1){
                    res += num-1;
                    num--;
                }
            }
        }
        
        return res;
        

    }

}

public class SherlockAndAnagram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.sherlockAndAnagrams(s);

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
