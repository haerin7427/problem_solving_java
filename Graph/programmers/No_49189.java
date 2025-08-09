package Graph.programmers;

// 문제 : 가장 먼 노드
// 풀이 일자 : 2025.08.09
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/49189

import java.util.*;

public class No_49189 {
    class Solution {
        private class Node {
            int value;
            int distance;
            
            Node(int v, int d) {
                value = v;
                distance = d;
            }
        }
        
        public int solution(int n, int[][] edge) {
            List<Integer>[] list = new ArrayList[n+1];
            for(int i=0; i<=n; i++) {
                list[i] = new ArrayList<>();
            }
            
            for(int[] o : edge) {
                list[o[0]].add(o[1]);
                list[o[1]].add(o[0]);
            }
            
            return bfs(list, n);
        }
        
        private int bfs(List<Integer>[] list, int n) {
            Queue<Node> queue = new LinkedList<>();
            boolean[] visited = new boolean[n+1];
            visited[1] = true;
            queue.add(new Node(1, 0));
            
            int answer = 0;
            int max_distance = 0;
            while(!queue.isEmpty()) {
                Node current_node = queue.remove();
                
                if(max_distance < current_node.distance) {
                    max_distance = current_node.distance;
                    answer = 1;
                }else if(max_distance == current_node.distance) {
                    answer += 1;
                }
                
                for(int next : list[current_node.value]){
                    if(visited[next]) continue;
                    
                    visited[next] = true;
                    queue.add(new Node(next, current_node.distance+1));
                }
            }
            return answer;
        }
    }
}