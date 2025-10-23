package Implementation.programmers;

// 문제 : [PCCP 기출문제] 3번 / 아날로그 시계
// 풀이 일자 : 2025.10.23
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/250135

public class No_250135 {
    class Solution {
        private int prev_seconds;
        public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
            int start = convertToSeconds(h1, m1, s1);
            int end = convertToSeconds(h2, m2, s2);
            
            prev_seconds = start;
            
            int answer = check_start(start);
            while(start < end) {
                start += 1;
                answer += check_case(start);
            }
            return answer;
        }
        
        public int check_start(int seconds) {
            int sound = 0;
            
            double current_second_y = calculate_y(seconds, 60, 6.0, false);
            double current_minute_y = calculate_y(seconds, 60*60, 1/10.0, false);
            double current_hour_y = calculate_y(seconds, 12*60*60, 1/120.0, false);
            
            if(current_second_y == current_minute_y) {
                sound += 1;
            }
            if(current_second_y == current_hour_y) {
                sound += 1;
            }
            
            if(current_hour_y == current_minute_y) {
                sound -= 1;
            }
            return sound;
        }
        
        public int check_case(int seconds) {
            int sound = 0;
            
            double prev_second_y = calculate_y(prev_seconds, 60, 6.0, true);
            double prev_minute_y = calculate_y(prev_seconds, 60*60, 1/10.0, true);
            double prev_hour_y = calculate_y(prev_seconds, 12*60*60, 1/120.0, true);
            
            double current_second_y = calculate_y(seconds, 60, 6.0, false);
            double current_minute_y = calculate_y(seconds, 60*60, 1/10.0, false);
            double current_hour_y = calculate_y(seconds, 12*60*60, 1/120.0, false);
            
            
            if(prev_second_y < prev_minute_y && current_second_y >= current_minute_y) {
                sound += 1;
            }
            if(prev_second_y < prev_hour_y && current_second_y >= current_hour_y) {
                sound += 1;
            }
            
            if(prev_hour_y > prev_minute_y && prev_hour_y > prev_second_y &&  current_hour_y <= current_second_y && current_hour_y <= current_minute_y) {
                sound -= 1;
            }
            
            prev_seconds = seconds;
            return sound;
        }
        
        public double calculate_y (int seconds, int unit, double d, boolean isPrev) {
            if(seconds % unit == 0 && !isPrev) {
                return 360;
            }else
                return d * (seconds % unit);
        }
        
        public int convertToSeconds(int h, int m, int s) {
            return h * 60 * 60 + m * 60 + s;
        }
    }
}
