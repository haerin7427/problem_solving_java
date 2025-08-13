package Sort.programmers;

// 문제 : 운영체제
// 풀이 일자 : 2025.08.13
// 설명 : https://school.programmers.co.kr/learn/courses/15008/lessons/121686

import java.util.*;
public class No_121686 {
    class Solution {
        private class Program {
            int score;
            long start_time;
            long process_time;
            
            Program(int s, int st, int pt) {
                score = s;
                start_time = st;
                process_time = pt;
            }
        }
        
        public long[] solution(int[][] program) {
            
            Program[] programs = new Program[program.length];
            for(int i=0; i<programs.length; i++) {
                programs[i] = new Program(program[i][0], program[i][1], program[i][2]);
            }
                    
            Arrays.sort(programs, new Comparator<Program>() {
                @Override
                public int compare(Program o1, Program o2) {
                    if(o1.start_time != o2.start_time) {
                        return Long.compare(o1.start_time, o2.start_time);
                    }else {
                        return Integer.compare(o1.score, o2.score);
                    }
                }
            });
            
            PriorityQueue<Program> pq = new PriorityQueue<>(new Comparator<Program>() {
                @Override
                public int compare(Program o1, Program o2) {
                    if(o1.score != o2.score) {
                        return Integer.compare(o1.score, o2.score);
                    }else {
                        return Long.compare(o1.start_time, o2.start_time);
                    }
                }
            });
            
            pq.add(programs[0]);
            long time = programs[0].start_time;
            int index = 1;
            
            long[] answer = new long[11];
            while(!pq.isEmpty()) {
                Program finish_program = pq.remove();
                
                answer[finish_program.score] += (time - finish_program.start_time);
                time += finish_program.process_time;
                
                if(pq.isEmpty() &&index < programs.length && time < programs[index].start_time) {
                    time = programs[index].start_time;
                }
                
                while(index < programs.length) {
                    if(programs[index].start_time <= time) {
                        pq.add(programs[index]);
                        index += 1;
                    }else {
                        break;
                    }
                }
            }
            
            answer[0] = time;
            return answer;
        }
    }
}
