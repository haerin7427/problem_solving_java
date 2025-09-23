package Implementation.programmers;

// 문제 : 다단계 칫솔 판매
// 풀이 일자 : 2025.09.23
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/77486

import java.util.*;

public class No_77486 {
    class Solution {
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            Map<String, String> enroll_ref = new HashMap<>();
            Map<String, Integer> profit = new HashMap<>();
            for(int i=0; i<enroll.length; i++) {
                enroll_ref.put(enroll[i], referral[i]);
            }
            
            for(int i=0; i<seller.length; i++) {
                int money = amount[i] * 100;
                String person = seller[i];
                
                while(enroll_ref.get(person) != null) {
                    if(money / 10 == 0) {
                        profit.put(person, profit.getOrDefault(person, 0) + money);
                        break;
                    }else {
                        profit.put(person, profit.getOrDefault(person, 0) + (money - money / 10));
                        money /= 10;
                        person = enroll_ref.get(person);
                    }
                }
            }
            
            int[] answer = new int[enroll.length];
            for(int i=0; i<enroll.length; i++) {
                answer[i] = profit.getOrDefault(enroll[i], 0);
            }
            return answer;
        }
    }
}
