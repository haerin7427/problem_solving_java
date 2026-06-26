package Binary_Search.programmers;

// 문제 : 입국심사
// 풀이 일자 : 2026.06.26
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/43238

import java.util.*;
public class No_43238 {
    class Solution {
        public long solution(int n, int[] times) {
            Arrays.sort(times);
            int num_person = times.length;
            
            long left = 0; long right = (long) times[num_person-1] * n;
            long answer = times[num_person-1] * n;
            
            while(left <= right) {
                long mid = (left + right) / 2;
                
                long persons = 0;
                for(int time : times) {
                    persons += mid / time;
                }
                
                if(n > persons) {
                    left = mid+1;
                }else {
                    answer = mid;
                    right = mid-1;
                }
            }
            return answer;
        }
    }
}
