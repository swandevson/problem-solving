import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
   while(true) {
       String word = br.readLine();
       if(word.equals("end")) {
           break;
       }
       
       bw.write("<" +  word + "> is ");
       if (isAcceptable(word)) {
           bw.write("acceptable");
       } else {
           bw.write("not acceptable");
       }
       bw.write(".");
       bw.newLine();
       
       bw.flush();
   }
   
   
    br.close();
    bw.close();
  }
  
  static boolean isAcceptable(String word) {
    
    if (!hasVowel(word)) {
        // System.out.println("no vowel");
        return false;
    }
    
    for (int i = 0; i < word.length() - 2; i++) {
        String sub = word.substring(i, i+3);
        // System.out.println(sub);
        if(!(hasVowel(sub) && hasConsonant(sub))) {
            // System.out.println("3 successive");
            return false;
        }
    }
    
    for (int i = 0; i < word.length() - 1; i++) {
        String sub = word.substring(i, i+2);
        // System.out.println(sub);
        if (sub.charAt(0) == 'e' || sub.charAt(0) == 'o') {
            continue;
        }
        
        if (sub.charAt(0) != sub.charAt(1)) {
            continue;
        }
        
        return false;
     }   
    
    return true;
  }
  
  static boolean hasVowel(String word) {
      List<String> vowels = List.of("a", "e", "i", "o", "u");
      
      for (String vowel : vowels) {
          if (word.contains(vowel)) {
              return true;
          }
      }
      
      return false;
  }
  
  static boolean hasConsonant(String word) {
      List<String> consonants = List.of("b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z");
      
      for (String consonant : consonants) {
          if (word.contains(consonant)) {
              return true;
          }
      }
      
      return false;
  }
}