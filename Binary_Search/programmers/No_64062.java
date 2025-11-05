package Binary_Search.programmers;

// 문제 : 징검다리 건너기
// 풀이 일자 : 2025.11.05
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/64062

import java.util.*;
public class No_64062 {
    class Solution {
        public int solution(int[] stones, int k) {
            int start = 0, end = 200000000;
            while(start < end) {
                int mid = (start + end) / 2;
                if(isPossible(stones, k, mid)) {
                    start = mid + 1;
                }else {
                    end = mid;
                }
            }
            return start;
        }
        
        private boolean isPossible(int[] stones, int k, int people) {
            int cnt = 0;
            for(int i=0; i<stones.length; i++) {
                if(stones[i] <= people) {
                    cnt += 1;
                    if(cnt == k) {
                        return false;
                    }
                }else {
                    cnt = 0;
                }
            }
            return true;
        }
    }
}
