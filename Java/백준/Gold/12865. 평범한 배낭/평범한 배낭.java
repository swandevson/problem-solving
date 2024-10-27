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
        
        int[][] dp = new int[K+1][N+1];  
        for (int i = 1; i <= K; i++) {  
            for (int j = 1; j <= N; j++) { 
                if (w[j] > i) {
                    dp[i][j] = dp[i][j-1];
                    continue;
                }
                
                dp[i][j] = Math.max(dp[i][j-1], v[j] + dp[i-w[j]][j-1]);
            }
        }
        
        System.out.println(dp[K][N]);
    }
}
