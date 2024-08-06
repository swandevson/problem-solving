import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            int flag = judge(word, 0, word.length() - 1, 0);
            
            bw.write(flag + "\n");
            bw.flush();
        }
    }
    
    static int judge(String word, int left, int right, int flag) {
        if (flag >= 2) {
            return 2;
        }
        
        while(left <= right) {
            if (word.charAt(left) == word.charAt(right)) {
                left++;
                right--;
            } else {
                int leftResult = judge(word, left + 1, right, flag + 1);
                int rightResult = judge(word, left, right - 1, flag + 1);
                
                flag = Math.min(leftResult, rightResult);
                return flag;
            }
        }
        
        return flag;
    }
}