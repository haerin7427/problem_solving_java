package Graph.programmers;

// 문제 : 가장 먼 노드
// 풀이 일자 : 2025.08.09, 2025.10.28
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/49189

import java.util.*;

public class No_49189 {
    class Solution {
        class Node {
            int value;
            int distance;
            
            Node (int v, int d) {
                this.value = v;
                this.distance = d;
            }
        }
        public int solution(int n, int[][] edge) {
            boolean[] visited = new boolean[n+1];
            List<Integer>[] list = new LinkedList[n+1];
            for(int i=0; i<=n; i++) {
                list[i] = new LinkedList<>();
            }
            
            for(int[] e : edge) {
                list[e[0]].add(e[1]);
                list[e[1]].add(e[0]);
            }
            
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(1, 0));
            visited[1] = true;
            
            int max_distance = 0;
            int answer = 1;
            while(!q.isEmpty()){
                Node cur = q.remove();
                if(max_distance < cur.distance) {
                    max_distance = cur.distance;
                    answer = 1;
                }else if(max_distance == cur.distance) {
                    answer += 1;
                }
                
                for(int value : list[cur.value]) {
                    if(visited[value]) continue;
                    visited[value] = true;
                    q.add(new Node(value, cur.distance+1));
                }
            }
            return answer;
        }
    }
}