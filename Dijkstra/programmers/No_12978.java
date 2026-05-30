package Dijkstra.programmers;

// 문제 : 배달
// 풀이 일자 : 2026.04.28
// https://school.programmers.co.kr/learn/courses/30/lessons/12978

import java.util.*;
public class No_12978 {
    class Solution {
        private class Info {
            int node;
            int cost;
            
            Info(int n, int c) {
                node = n;
                cost = c;
            }
        }
        
        public int solution(int N, int[][] road, int K) {
            
            // init
            boolean[] visited = new boolean[N+1];
            int[] dist = new int[N+1];
            Arrays.fill(dist, 50 * 10000);
            
            List<Info>[] graph = new LinkedList[N+1];
            for(int i=0; i<graph.length; i++) {
                graph[i] = new LinkedList<>();
            }
            for(int[] r : road) {
                graph[r[0]].add(new Info(r[1], r[2]));
                graph[r[1]].add(new Info(r[0], r[2]));
            }
            
            PriorityQueue pq = new PriorityQueue<Info>((a, b) -> a.cost - b.cost);
            pq.add(new Info(1, 0));
            
            while(!pq.isEmpty()) {
                Info o = (Info) pq.remove();
                visited[o.node] = true;
                dist[o.node] = Math.min(dist[o.node], o.cost);
                
                for(Info next : graph[o.node]){
                    if(visited[next.node]) continue;
                    pq.add(new Info(next.node, o.cost+next.cost));
                }
            }
            
            int answer = 0;
            for(int i=0; i<dist.length; i++) {
                if(dist[i] <= K) {
                    answer += 1;
                }
            }
            

            return answer;
        }
    }
}
