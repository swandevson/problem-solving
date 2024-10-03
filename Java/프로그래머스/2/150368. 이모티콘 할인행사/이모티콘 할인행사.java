// 이모티콘 할인율을 각각 다를 수 있다.
// 사용자는 일정 할인율 이상의 이모티콘만 구매한다

import java.util.*;

class Solution {
    static List<int[]> possibles = new ArrayList<>();
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};

        dfs(emoticons.length, new int[emoticons.length], 0);
        
        int ansCnt = 0;
        int ansTotal = 0;
        
        for (int[] p : possibles) {
            int cnt = 0;
            int total = 0;
            
            for (int i = 0; i < users.length; i++) {
                int sum = 0;
                
                for (int j = 0; j < emoticons.length; j++) {   // 해당 유저의 이모티콘 구매
                    if (users[i][0] > p[j]) {   // 유저 할인률보다 이모티콘 할인률이 낮은 경우는 pass
                        continue;
                    }
                    sum += emoticons[j] * (100 - p[j]) / 100;
                }
                
                if (sum >= users[i][1]) {
                    cnt ++;        
                } else {
                    total += sum;
                }
            }
            
            if (ansCnt < cnt) {
                ansCnt = cnt;
                ansTotal = total;
            } else if (ansCnt == cnt) {
                ansTotal = Math.max(ansTotal, total);
            }
        }
        
        return new int[] {ansCnt, ansTotal};
    }
    
    private void dfs(int bound, int[] possible, int depth) {
        if (depth == bound) {
            possibles.add(possible.clone());
            return;
        }
        
        for (int r = 10 ; r <= 40; r += 10) {
            possible[depth] = r;
            dfs(bound, possible, depth + 1);
        }
    }
}