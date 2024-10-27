import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] w = new int[N+1];
        int[] v = new int[N+1];
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[N+1][K+1];  
        for (int i = 1; i <= N; i++) {  // select product
            for (int j = 1; j <= K; j++) {  // select napsack capacity
                if (w[i] > j) { // if product's weight over capacity
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                
                // case 1. don't put current thing in
                // case 2. extract to make up current product's capcity, then put in
                dp[i][j] = Math.max(dp[i-1][j], v[i] + dp[i-1][j-w[i]]);
            }
        }
        
        System.out.println(dp[N][K]);
    }
}
