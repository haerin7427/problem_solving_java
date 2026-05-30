package Implementation.programmers;

// 문제 : 두 개 뽑아서 더하기
// 풀이 일자 : 2026.05.05
// https://school.programmers.co.kr/learn/courses/30/lessons/68644

import java.util.*;
public class No_68644 {
    class Solution {
        public int[] solution(int[] numbers) {
            Set<Integer> sum_numbers_set = new HashSet<>();
            for(int i=0; i<numbers.length-1; i++) {
                for(int j=i+1; j<numbers.length; j++) {
                    sum_numbers_set.add(numbers[i] + numbers[j]);
                }
            }
            
            int n = sum_numbers_set.size();
            int[] arr = new int[n];
            int cnt = 0;
            for(int num : sum_numbers_set) {
                arr[cnt++] = num;
            }
            Arrays.sort(arr);
            return arr;
        }
    }
}
