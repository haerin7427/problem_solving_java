package Implementation.programmers;

// 문제 : 서버 증설 횟수
// 풀이 일자 : 2025.09.23
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/389479

import java.util.*;

public class No_389479 {
    class Solution {
        public int solution(int[] players, int m, int k) {
            int answer = 0;
            Queue<Integer> queue = new LinkedList<>();
            for(int i=0; i<players.length; i++) {
                int time = i;
                while(!queue.isEmpty()) {
                    if(queue.peek() >= time) {
                        break;
                    }else {
                        queue.remove();
                    }
                }
                
                if(players[time] >= m) {
                    int required_server = players[time] / m;
                    while(required_server > queue.size()) {
                        queue.add(time + k - 1);
                        answer += 1;
                    }
                }
            }
            return answer;
        }
    }
}
