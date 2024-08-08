import java.util.*;
import java.io.*;

public class Main {
    static int ans = Integer.MIN_VALUE;
    static Map<Integer, Integer> map = new HashMap<>(); // A map that stores the fruit number and the number of corresponding fruits
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] nums = new int[10];
        int cnt = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(st.nextToken());
            arr[i] = s;
            if (nums[s] == 0) {
                cnt ++;
            }
            nums[s]++;
        }
        
       solve(arr);
        
        System.out.println(ans);
    }
    
    static void solve(int[] arr) {
        int f = 0;
        int r = 0;
        
        while(f <= r && r < arr.length) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            r++;
            
            if (map.size() > 2) {
                map.put(arr[f], map.get(arr[f]) - 1);
                if (map.get(arr[f]) == 0) {
                    map.remove(arr[f]);
                }
            
                f++;
                ans = Math.max(ans, r-f);
            }
        }
        
        ans = Math.max(ans, r-f);
        
    }
}