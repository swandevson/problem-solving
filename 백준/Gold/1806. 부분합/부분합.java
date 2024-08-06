import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    long s = Long.parseLong(st.nextToken());
    
    long[] arr = new long[n+1];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i ++) {
        arr[i] = Long.parseLong(st.nextToken());
    }

    int left = 0, right = 0;
    long sum = 0;
    int ans = Integer.MAX_VALUE;
    while (left <= right && right <= n) {
        if (sum >= s) {
            ans = Math.min(ans, right-left);
            sum -= arr[left++];
        } else if (sum < s) {
            sum += arr[right++];
        }
        
    }
    
    System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
  }
}