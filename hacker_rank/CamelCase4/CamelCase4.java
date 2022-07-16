import java.io.*;
import java.util.*;

public class CamelCase4 {
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            char op = parts[0].charAt(0);
            char type = parts[1].charAt(0);
            char[] wordArray = parts[2].toCharArray();
            String output = "";
            
            if(op == 'S'){
                for(char ch : wordArray){
                    if(Character.isUpperCase(ch)){
                        output+=" " + Character.toLowerCase(ch);
                    }else if(ch != '(' && ch != ')'){
                        output+=ch;
                    }
                }
            }
            
            if(op == 'C'){
                for(int i = 0; i < wordArray.length; i++){
                    char currentChar = wordArray[i];
                    
                    if(currentChar != ' '){
                        if(i > 0 && wordArray[i-1] == ' '){
                            currentChar = Character.toUpperCase(currentChar);
                        }
                        output += currentChar;
                    }
                }
                
                if(type == 'M'){
                    output += "()";
                }
                
                if(type == 'C'){
                    output = output.substring(0,1).toUpperCase() + output.substring(1);
                }
                
            }
            
            System.out.println(output.trim()); 
        }
    }
}
