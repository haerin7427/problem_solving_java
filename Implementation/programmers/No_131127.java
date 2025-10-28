package Implementation.programmers;

// 문제 : 할인 행사
// 풀이 일자 : 2025.10.28
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/131127

import java.util.*;
public class No_131127 {
    class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            Map<String, Integer> set = new HashMap<>();
            int answer = 0;
            for(int i=0; i<discount.length; i++) {
                if(i>=10) {
                    int idx = i - 10;
                    int value = set.get(discount[idx]);
                    if(value == 1) {
                        set.remove(discount[idx]);
                    }else {
                        set.put(discount[idx], value - 1);
                    }
                }
                set.put(discount[i], set.getOrDefault(discount[i], 0) + 1);
                
                if(i >= 9) {

                    boolean isPossible = true;
                    for(int j=0; j<want.length; j++) {
                        if(set.get(want[j]) == null || set.get(want[j]) < number[j]) {
                            isPossible = false;
                            break;
                        }
                    }
                    
                    if(isPossible) {
                        answer += 1;
                    }
                }
                
            }
            return answer;
        }
    }
}
