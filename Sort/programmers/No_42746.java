package Sort.programmers;

// 문제 : 가장 큰 수
// 풀이 일자 : 2025.08.09
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
}
