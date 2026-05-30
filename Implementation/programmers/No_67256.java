package Implementation.programmers;

// 문제 : 키패드 누르기
// 풀이 일자 : 2026.05.05
// https://school.programmers.co.kr/learn/courses/30/lessons/67256

public class No_67256 {
    class Solution {
        class Hand {
            int x;
            int y;
            
            Hand(int x, int y) {
                this.x = x;
                this.y = y;
            }
            
            void update(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        
        private StringBuffer answer = new StringBuffer();
        public String solution(int[] numbers, String hand) {
            
            Hand left = new Hand(0,3);
            Hand right = new Hand(2,3);
            
            for(int number : numbers) {
                if(number == 1 || number == 4 || number == 7) {
                    move_hand(left, "L", number);
                }else if(number == 3 || number == 6 || number == 9) {
                    move_hand(right, "R", number);
                }else {
                    int left_case = get_distance(left, number);
                    int right_case = get_distance(right, number);
                    
                    if(left_case < right_case) {
                        move_hand(left, "L", number);
                    }else if(left_case > right_case) {
                        move_hand(right, "R", number);
                    }else {
                        if(hand.equals("left")) {
                            move_hand(left, "L", number);
                        }else {
                            move_hand(right, "R", number);
                        }
                    }
                    
                }
            }
            return answer.toString();
        }
        
        private void move_hand (Hand o, String s, int number) {
            answer.append(s);
            o.update(get_x(number), get_y(number));
        }
        
        private int get_distance (Hand o, int num) {
            return Math.abs(o.x - get_x(num)) + Math.abs(o.y - get_y(num));
        }
        
        private int get_x (int num) {
            if(num == 0) return 1;
            return (num-1) % 3; 
        }
        
        private int get_y (int num) {
            if(num == 0) return 3;
            return (num-1) / 3; 
        }
    }
}