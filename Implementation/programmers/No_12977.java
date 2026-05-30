package Implementation.programmers;

// 문제 : 소수 만들기
// 풀이 일자 : 2026.05.04
// https://school.programmers.co.kr/learn/courses/30/lessons/12977

import java.util.*;
public class No_12977 {
    class Solution {
        public int solution(int[] nums) {
            
            Arrays.sort(nums);
            int n = nums.length;
            int max = nums[n-1] + nums[n-2] + nums[n-3];
            boolean[] isPrime = new boolean[max+1];
            Arrays.fill(isPrime, true);
            init(isPrime, max);
            
            int answer = 0;
            boolean[] isUsed = new boolean[n];
            int digit = 0;
            for(int i=0; i<n; i++) {
                digit += nums[i];
                isUsed[i] = true;
                for(int j=i+1; j<n; j++) {
                    if(isUsed[j]) continue;
                    digit += nums[j];
                    isUsed[j] = true;
                    for(int s=j+1; s<n; s++) {
                        if(isUsed[s]) continue;
                        digit += nums[s];
                        isUsed[s] = true;
                        if(isPrime[digit]) {answer += 1;}
                        digit -= nums[s];
                        isUsed[s] = false;
                    }
                    digit -= nums[j];
                    isUsed[j] = false;
                }
                digit -= nums[i];
                isUsed[i] = false;
            }
            

            return answer;
        }
        
        private void init(boolean[] isPrime, int max) {
            for(int i=2; i<=Math.sqrt(max)+1; i++) {
                if(isPrime[i]) {
                    for(int j=2; i*j<=max; j++) {
                        isPrime[i*j] = false;
                    }
                }
            }
        }
    }

    class Solution2 {
        public int solution(int[] nums) {
            // 소수의 개수를 세기 위한 count 선언
            int count = 0;
            
            // 세 가지 수를 더하는 조합
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        // 세 수의 합
                        int num = nums[i] + nums[j] + nums[k];
                        // 소수 판별 후 count 증가
                        if (isPrime(num)) count += 1;
                    }
                }
            }

            return count;
        }
        
        // 소수 판별 메서드
        private boolean isPrime(int num) {
            if (num == 2) return true;
            for (int i = 2; i <= (int) Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
