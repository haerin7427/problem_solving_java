package Sort.programmers;

// 문제 : 가장 큰 수
// 풀이 일자 : 2025.08.09, 2026.06.25
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/42746

import java.util.*;

public class No_42746 {
    class Solution {
        public String solution(int[] numbers) {
            List<String> numbers_list = new ArrayList<>();
            for(int number : numbers) {
                numbers_list.add(String.valueOf(number));
            }
            
            Collections.sort(numbers_list, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    String word1 = s1 + s2;
                    String word2 = s2 + s1;
                    return Integer.parseInt(word2) - Integer.parseInt(word1) ;
                }
            });
            
            StringBuffer sb = new StringBuffer();
            for(String num : numbers_list) {
                sb.append(num);
            }
            
            if(sb.toString().charAt(0) == '0') {
                return "0";
            }else {
                return sb.toString();
            }
        }
    }

    // 2026.06.25
    class Solution2 {
        public String solution(int[] numbers) {
            int n = numbers.length;
            String[] numbers_string = new String[n];
            for(int i=0; i<n; i++) {
                numbers_string[i] = String.valueOf(numbers[i]);
            }
            
            Arrays.sort(numbers_string, new Comparator<String>(){
                @Override
                public int compare(String o1, String o2) {
                    return Integer.valueOf(o2 + o1) - Integer.valueOf(o1 + o2);
                }
            });

            
            StringBuffer answer = new StringBuffer();
            if(numbers_string[0].equals("0")) return "0";
            for(int i=0; i<n; i++) {
                answer.append(numbers_string[i]);
                
            }
            return answer.toString();
        }
    }
}