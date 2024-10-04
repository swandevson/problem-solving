

// 도넛 모양 그래프 -> 8자 그래프 확인 필요

// 그래프의 중심 == 해당 정점과 연결된 곳이 각 그래프의 최종점인 경우

import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>(); // 해당 정점으로 들어오는 간선 수
        Map<Integer, Integer> out = new HashMap<>();    // 해당 정점에서 나가는 간선 수
        
        for (int i = 0; i < edges.length; i++) {
            List<Integer> v = adj.getOrDefault(edges[i][0], new ArrayList<>());
            v.add(edges[i][1]);
            
            adj.put(edges[i][0], v);
            adj.put(edges[i][1], new ArrayList<>());
            
            in.put(edges[i][1], in.getOrDefault(edges[i][1], 0) + 1);
            out.put(edges[i][0], out.getOrDefault(edges[i][0], 0) + 1);
        }

        // 생성 정점의 조건: 나가는 간선의 수 >= 2 and 들어오는 간선의 수 0
        // 막대 그래프: 들어오는 간선이 1개인 경우
        // 8자 그래프: 나가는 간선 2개, 들어오는 간선 2개인 경우
        // 도넛 그래프: 전체 그래프 수 - (막대 + 8자)
        
        // 0 == 중심점, 1 == 도넛, 2 == 막대, 3 == 8자
        int[] ans = new int[4];
        for (Integer k : adj.keySet()) {
            int inCnt = in.getOrDefault(k, 0);
            int outCnt = out.getOrDefault(k, 0);
            
            // System.out.println(k + " " + inCnt + " " + outCnt);
            
            if (inCnt == 0 && outCnt >= 2) {
                ans[0] = k;
            } else if (inCnt >= 2 && outCnt >= 2) {
                ans[3] ++;
            } else if (inCnt > 0 && outCnt == 0) {
                ans[2] ++;
            }
        }
        
        ans[1] = adj.get(ans[0]).size() - (ans[2] + ans[3]);
        
        return ans;
    }
}