package Graph.programmers;

// 문제 : 배달
// 풀이 일자 : 2025.08.10, 2025.10.31
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/12978

import java.util.*;

public class No_12978 {
    class Solution {
        private class Node implements Comparable<Node> {
            int to;
            int weight;
            
            Node(int t, int w) {
                this.to = t;
                this.weight = w;
            }
            
            @Override
            public int compareTo(Node o) {
                return this.weight - o.weight;
            }
        }

        public int solution(int N, int[][] road, int K) {
            
            List<Node>[] input = new ArrayList[N+1];
            int[] dist = new int[N+1];
            
            Arrays.fill(dist, Integer.MAX_VALUE);
            for(int i=0; i<=N; i++) {
                input[i] = new ArrayList<>();
            }
            
            for(int[] r : road) {
                input[r[0]].add(new Node(r[1], r[2]));
                input[r[1]].add(new Node(r[0], r[2]));
            }
            
            PriorityQueue<Node> pq = new PriorityQueue<>();
            
            pq.add(new Node(1, 0));
            dist[1] = 0;
            while(!pq.isEmpty()){
                Node cur = pq.remove();
                
                if(dist[cur.to] < cur.weight) {
                    continue;
                }
                
                for(Node next : input[cur.to]) {
                    if(dist[next.to] > dist[cur.to] + next.weight) {
                        dist[next.to] = dist[cur.to] + next.weight;
                        pq.add(new Node(next.to, dist[next.to]));
                    }
                }
            }
            
            int answer = 0;
            for(int i=1; i<=N; i++) {
                if(dist[i] <= K) {
                    answer += 1;
                }
            }
            return answer;
        }
    }
}