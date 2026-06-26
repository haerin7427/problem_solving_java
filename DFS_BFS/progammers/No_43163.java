package DFS_BFS.progammers;

// 문제 : 단어 변환
// 풀이 일자 : 2026.06.26
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/43163

import java.util.*;
    public class No_43163 {
        class Solution {
        public boolean[] used;
        public String[] words_ver_copy;
        public int answer = 100;
        public int n;
        public int solution(String begin, String target, String[] words) {
            n = words.length;
            used = new boolean[n];
            words_ver_copy = Arrays.copyOf(words, words.length);
            dfs(begin, target, 0);
            return answer == 100 ? 0 : answer;
        }
        
        public void dfs(String word, String target, int count) {
            if(word.equals(target)) {
                answer = Math.min(answer, count);
                return;
            }else if(answer < count) {
                return;
            }
            
            for(int i=0; i<n; i++) {
                if(!is_change_possible(word, i)) continue;
                
                used[i] = true;
                dfs(words_ver_copy[i], target, count+1);
                used[i] = false;
            }
        }
        
        public boolean is_change_possible(String origin, int index) {
            if(used[index]) return false;
            
            int count = 0;
            for(int i=0; i<origin.length(); i++) {
                if(origin.charAt(i) != words_ver_copy[index].charAt(i)) {
                    count += 1;
                    if(count > 1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
