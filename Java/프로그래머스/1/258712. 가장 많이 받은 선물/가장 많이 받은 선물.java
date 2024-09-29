import java.util.*;
    
// 1. 같은 달에 선물을 더 많이 준 사람이 받음
// 2. 같은 달에 주고 받은 기록이 없거나 같은 경우 -> 선물 지수가 더 큰 사람이 받음
// 2-1. 선물지수는 여태껏 모든사람에게 (준 선물 수) - (받은 선물 수)
// 3. 선물지수까지 같다면 안주고받음


class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> idxMap = new HashMap<>();
        Map<Integer, Integer> pointMap = new HashMap<>();
        int[][] mat = new int[50][50];  // 주는사람, 받는사람 순서로 저장
        Map<Integer, Integer> ansMap = new HashMap<>(); // 받아야하는 선물 갯수
        
        for (int i = 0; i < friends.length; i++) {
            String name = friends[i];
            idxMap.put(name, i);
            pointMap.put(i, 0);
            ansMap.put(i, 0);
        }
        
        for (String gift : gifts) {
            String[] names = gift.split(" ");
            int s = idxMap.get(names[0]);    // 주는 사람
            int r = idxMap.get(names[1]);    // 받는 사람
            
            
            pointMap.put(s, pointMap.get(s) + 1);
            pointMap.put(r, pointMap.get(r) - 1);
            
            mat[s][r]++;
        }
    
        
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                // 임의의 두명이 주고받은 선물 갯수
                int a = mat[i][j];
                int b = mat[j][i];
                
                if (a > b) {
                    ansMap.put(i, ansMap.get(i) + 1);
                } else if (a < b) {
                    ansMap.put(j, ansMap.get(j) + 1);
                }  else {
                    // 선물지수 비교
                    int ap = pointMap.get(i);
                    int bp = pointMap.get(j);
                    
                    if (ap > bp) {
                        ansMap.put(i, ansMap.get(i) + 1);
                    } else if (ap < bp) {
                        ansMap.put(j, ansMap.get(j) + 1);
                    }
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < friends.length; i++) {
            System.out.println(friends[i] + " " + ansMap.get(i));
            ans = Math.max(ans, ansMap.get(i));
        }
        
        return ans;
    }
}