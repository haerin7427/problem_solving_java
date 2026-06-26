package Greedy.programmers;

// 문제 : 요격 시스템
// 풀이 일자 : 2026.06.26
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/181188

import java.util.*;
public class No_181188 {
    class Solution {
        public int solution(int[][] targets) {       
            Arrays.sort(targets, new Comparator<int[]>(){
                @Override
                public int compare (int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            
            int answer = 1;
            int s = targets[0][0];
            int e = targets[0][1];
            for(int i=1; i<targets.length; i++) {
                if(e <= targets[i][0]) {
                    answer += 1;
                    e = targets[i][1];
                }else {
                    if(e > targets[i][1]) {
                        e = targets[i][1];
                    }
                }
                s = targets[i][0];
            }
            return answer;
        }
    }
}
