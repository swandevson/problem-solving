import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      
      for (int i = 0; i < n; i++) {
          String word = br.readLine();
          int flag = judge(word);
          
          bw.write(flag + "\n");
          bw.flush();
      }
  }
  
  static int judge(String word) {
      int flag = 0;
      int left = 0 ;
      int right = word.length() - 1;
      
      char[] arr = word.toCharArray();
      
      while(left <= right) {
          if (arr[left] == arr[right]) {
              left ++;
              right --;
          } else {
              char[] leftCut = word.substring(left + 1, right + 1).toCharArray();
              char[] rightCut = word.substring(left, right).toCharArray();
              
              if (judgeSimilarity(leftCut) || judgeSimilarity(rightCut)) {
                  return 1;
              }
              
              return 2;
          }
      }
      
      return 0;
  }
  
  static boolean judgeSimilarity(char[] arr) {
      int left = 0;
      int right = arr.length - 1;
      
      while(left <= right) {
          if (arr[left] != arr[right]) {
             return false;
          }
          left ++;
          right --;
      }
      
      return true;
  }
  
}