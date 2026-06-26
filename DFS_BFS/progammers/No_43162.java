package DFS_BFS.progammers;

// 문제 : 네트워크
// 풀이 일자 : 2026.06.25
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/43162

import java.util.*;
public class No_43162 {
    class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] visited = new boolean[n];
            
            for(int i=0; i<n; i++) {
                if(visited[i]) continue;
                answer += 1;
                
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;
                while(!queue.isEmpty()){
                    int computer_no = queue.remove();
                    
                    for(int next_computer = 0; next_computer<n; next_computer++) {
                        if(visited[next_computer] || computers[computer_no][next_computer] == 0) continue;
                        queue.add(next_computer);
                        visited[next_computer] = true;
                    }
                }
            }
            return answer;
        }
    }
}
