import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int n = Integer.parseInt(br.readLine());
    long[] distances = new long[n-1];
    long[] costs = new long[n];
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n-1; i++) {
        distances[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
        costs[i] = Integer.parseInt(st.nextToken());
    }
    
    long minCost = costs[0];
    
    long ans = 0;
    
    for (int i = 0; i < n-1; i++) {
        if (costs[i] < minCost) {
            minCost = costs[i];
        }
        
        ans = ans + (distances[i] * minCost);
    }
    
    System.out.println(ans);
  }
}