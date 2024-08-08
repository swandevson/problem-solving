import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    
    int[] arr = new int[n];
    for (int i = 0; i < n; i ++) {
        st = new StringTokenizer(br.readLine());
        arr[i] = Integer.parseInt(st.nextToken());
    }
    
    Arrays.sort(arr);
    
    int left = 0, right = 0;
    int ans = Integer.MAX_VALUE;
    
    while(left <= right && right < n) {
        int diff = arr[right] - arr[left];
        if(diff >= m) {
            ans = Math.min(ans, diff);
            left ++;
        } else {
            right ++;
        }
    }
    
    System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
  }
}