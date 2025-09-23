package Implementation.programmers;

// 문제 : 불량 사용자
// 풀이 일자 : 2025.09.23
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/64064

import java.util.*;

public class No_64064 {
    class Solution {
        private Set<String> answer = new HashSet<>();
        private boolean[] used;
        public int solution(String[] user_id, String[] banned_id) {
            used = new boolean[user_id.length];
            make_case(user_id, banned_id, 0);
            return answer.size();
        }
        
        private void make_case (String[] user_id, String[] banned_id, int banned_idx) {
            if(banned_idx == banned_id.length) {
                check_answer();
                return;
            }
            
            for(int i=0; i<user_id.length; i++) {
                if(used[i]) continue;
                if(check_word(banned_id[banned_idx], user_id[i])){
                    used[i] = true;
                    make_case(user_id, banned_id, banned_idx+1);
                    used[i] = false;
                }
            }
        }
        
        private void check_answer() {
            StringBuffer temp = new StringBuffer();
            for(int i=0; i<used.length; i++) {
                if(used[i]) {
                    temp.append(i);
                }
            }
            answer.add(temp.toString());
        }
        
        private boolean check_word(String s1, String s2) {
            if(s1.length() != s2.length()) {
                return false;
            }
            
            for(int i=0; i<s1.length(); i++) {
                if(s1.charAt(i) == '*') {
                    continue;
                }else if(s1.charAt(i) != s2.charAt(i)) {
                    return false;
                }
            }
            
            return true;
        }
    }
}
