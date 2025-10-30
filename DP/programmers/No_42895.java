package DP.programmers;

// 문제 : N으로 표현
// 풀이 일자 : 2025.10.29
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/42895?language=java

import java.util.*;
public class No_42895 {
    class Solution {
        public int solution(int N, int number) {
            
            if(N == number) {
                return 1;
            }
            
            List<Set<Integer>> dp = new ArrayList<>();
            for(int i=0; i<9; i++) {
                dp.add(new HashSet<>());
            }

            int answer = -1;
            dp.get(1).add(N);  // N을 1개 써서 표현할 수 있는 수
            
            for(int i=2; i<dp.size(); i++) {
                int repeatN = Integer.parseInt(String.valueOf(N).repeat(i));
                dp.get(i).add(repeatN);
                
                for(int j=1; j<i; j++) {
                    for(int num1 : dp.get(j)) {
                        for(int num2 : dp.get(i-j)) {
                            dp.get(i).add(num1 + num2);
                            dp.get(i).add(num1 - num2);
                            dp.get(i).add(num2 - num1);
                            dp.get(i).add(num1 * num2);
                            if(num2 != 0)
                                dp.get(i).add(num1 / num2);
                            if(num1 != 0)
                                dp.get(i).add(num2 / num1);
                        }
                    }
                }
                
                if(dp.get(i).contains(number)) {
                    answer = i;
                    break;
                }
            }
            return answer;
        }
    }
}
