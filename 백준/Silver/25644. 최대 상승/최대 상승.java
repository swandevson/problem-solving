import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    long[] arr = new long[n];
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    for (int i = 0; i < n; i++) {
        arr[i] = Long.parseLong(st.nextToken());
    }

    long minVal = Long.MAX_VALUE;
    long maxProfit = 0;
    for (int i = 0; i < n; i++) {
        if (minVal > arr[i]) {
            minVal = arr[i];
            continue;
        }
        
        long profit = arr[i] - minVal;
        maxProfit = Math.max(profit, maxProfit);
    }
    
    System.out.println(maxProfit);
  }
  
}