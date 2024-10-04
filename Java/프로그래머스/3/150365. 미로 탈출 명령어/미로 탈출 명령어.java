// 네 방향 중 한 곳으로 이동 가능.
// 해당 위치가 이전 위치에서 어떻게 움직여 왔는지 기록함
// 이동한 거리가 k와 같다면, 해당 탈출경로를 기록
import java.util.*;

class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] dr = {"d", "l", "r", "u"}; 
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        
        
        if (!enable(x, y, r, c, k)) {
            return "impossible";
        }
        
        return solve(n, m, x, y, r, c, k);
    }
    
    public String solve(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder sb = new StringBuilder();
        
        while(k > 0) {
            for (int i = 0; i < 4; i++) {   // 우선순위가 높은 방향으로 먼저 방문
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (!isInRange(n, m, nx, ny)) {
                    continue;
                }
                
                int distance = Math.abs(nx-r) + Math.abs(ny-c);
                if (distance <= k-1) {  // 이동 후, 남은 거리보다 움직일 수 있는 횟수가 많을때
                    k--;
                    x = nx;    // 이동한 방향 기억하기
                    y = ny;
                    sb.append(dr[i]);
                    break;
                }
            }
        }
        
        return sb.toString();
    }
    
    public boolean isInRange(int n, int m, int nx, int ny) {
        if (nx <= 0 || nx > n) {
            return false;
        }
        if (ny <= 0 || ny > m) {
            return false;
        }
        return true;
    }
    
    public boolean enable(int x, int y, int r, int c, int k) {
        int distance = Math.abs(r-x) + Math.abs(c-y);
        if (distance == k) {
            return true;
        }
        if (distance > k) {
            return false;
        }
        
        if ((k - distance) % 2 == 0) {
            return true;
        }
        
        return false;
    }
}