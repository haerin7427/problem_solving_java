package Greedy.programmers;

// 문제 : 단속카메라
// 풀이 일자 : 2025.10.31
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/42884

import java.util.*;
public class No_42884 {
    class Solution {
        class Record implements Comparable<Record> {
            int in;
            int out;
            
            Record (int i, int o) {
                this.in = i;
                this.out = o;
            }
            
            @Override
            public int compareTo(Record o) {
                if(this.in != o.in) {
                    return this.in - o.in;
                }else {
                    return o.out - this.out;
                }
            }
        }
        public int solution(int[][] routes) {
            List<Record> list = new ArrayList<>();
            for(int[] route : routes) {
                list.add(new Record(route[0], route[1]));
            }
            Collections.sort(list);
            
            int answer = 1, start = -30001, end = 30001;
            for(Record o : list) {
                start = o.in;
                if(o.in <= end) {
                    end = Math.min(end, o.out);
                }else {
                    answer += 1;
                    end = o.out;
                }
            }
            return answer;
        }
    }
}
