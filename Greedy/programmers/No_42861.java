package Greedy.programmers;

// 문제 : 섬 연결하기
// 풀이 일자 : 2025.10.31
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/42861

import java.util.*;
public class No_42861 {
    class Solution {
        private int[] parents;
        private class Edge implements Comparable<Edge> {
            int from;
            int to;
            int weight;
            
            Edge(int f, int t, int w) {
                this.from = f;
                this.to = t;
                this.weight = w;
            }
            
            @Override
            public int compareTo(Edge o) {
                return this.weight - o.weight;
            }
        }
        
        private void union(int a, int b) {
            a = find(a);
            b = find(b);
            if(a != b) {
                parents[b] = a;
            }
        }
        
        private int find (int a) {
            if(parents[a] == a) return a;
            else return find(parents[a]);
        }
        
        public int solution(int n, int[][] costs) {
            int answer = 0;
            parents = new int[n+1];
            
            List<Edge> list = new ArrayList<>();
            for(int[] c : costs) {
                list.add(new Edge(c[0], c[1], c[2]));
                list.add(new Edge(c[1], c[0], c[2]));
            }
            
            Collections.sort(list);
            for(int i=1; i<=n; i++) {
                parents[i] = i;
            }
            
            for(Edge e : list) {
                if(find(e.from) == find(e.to)) continue;
                
                union(e.from, e.to);
                answer += e.weight;
            }
            
            
            
            return answer;
        }
    }
}
