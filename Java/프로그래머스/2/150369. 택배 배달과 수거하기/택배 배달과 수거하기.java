import java.util.*;
import java.util.stream.*;
// n <= 10^5이므로, O(n^2)은 불가능 -> n log n?
// 1. 최대로 적재하고 가면서 뿌리기
// 2. 물류창고에 돌아오면서 수거하기
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long ans = 0;
        
        int d = 0;
        int p = 0;
        
        
        for (int i = n - 1; i >= 0; i--) {
            // 해당 지점에 배달 및 수거해야할 택배 수
            d += deliveries[i];
            p += pickups[i];
            int cnt = 0;    // 해당 지점 방문 횟수
            
            // 해당 지점을 더이상 방문하지 않아도 될 때 까지(배달과 수거를 모두 할 때 까지) 반복
            // 해당 지점 방문 후 잉여량을 그대로 두어, 다음 목적지에 가야하는지 판단
            while(d > 0 || p > 0) {
                d -= cap;
                p -= cap;
                
                cnt++;
            }
            
            ans += cnt * (i+1) * 2;
        }
        
        return ans;
    }
}