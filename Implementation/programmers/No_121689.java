package Implementation.programmers;

// 문제 : 카페 확장
// 풀이 일자 : 2025.08.14
// 설명 : https://school.programmers.co.kr/learn/courses/15009/lessons/121689

import java.util.*;

public class No_121689 {
    class Solution {
        public int solution(int[] menu, int[] order, int k) {
            
            int answer = 1;
            Queue<Integer> waiting_list = new LinkedList<>();
            waiting_list.add(order[0]);
            int start_time = 0, finish_time = menu[waiting_list.peek()];
            int index = 1;
            
            while(!waiting_list.isEmpty() || index < order.length) {
                
                
                // 음료를 만드는 사이에 들어온 사람 수 확인
                int temp = start_time + 1;
                while(temp % k != 0) {
                        temp += 1;
                }
                while(temp < finish_time && index < order.length) {
                    waiting_list.add(order[index++]);
                    temp += k;
                }
                
                // 대기 인원 확인
                if(answer < waiting_list.size()) {
                    answer = waiting_list.size();
                }
                            
                // 음료 완성
                if(!waiting_list.isEmpty()) {
                    waiting_list.remove();
                }
                
                // 새로운 사람 들어오는 타이밍 확인
                if(finish_time % k == 0 && index < order.length) {
                    waiting_list.add(order[index++]);
                }
                
                // 새로운 음료 결정
                if(!waiting_list.isEmpty()) {
                    start_time = finish_time;
                    finish_time = start_time + menu[waiting_list.peek()];
                }else {
                    start_time = finish_time;
                    while(finish_time % k != 0) {
                        finish_time += 1;
                    }
                }
            }
            return answer;
        }
    }
}
