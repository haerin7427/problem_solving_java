package Hash;

// 문제 : 완주하지 못한 선수
// 풀이 일자 : 2026.04.28
// https://school.programmers.co.kr/learn/courses/30/lessons/42576

import java.util.*;
public class No_42576 {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            HashMap<String, Integer> map = new HashMap<>();
            for(String name : participant) {
                map.put(name, map.getOrDefault(name, 0) +1);
            }
            
            for(String name : completion) {
                map.put(name, map.get(name) - 1);
            }
            
            String answer = "";
            for(String key : map.keySet()){
                if(map.get(key) != 0) {
                    answer = key;
                    break;
                }
            }
            return answer;
        }
    }
}
