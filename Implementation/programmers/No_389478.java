package Implementation.programmers;

// 문제 : 택배 상자 꺼내기
// 풀이 일자 : 2025.08.12
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/389478

public class No_389478 {
    class Solution {
        public int solution(int n, int w, int num) {
            int target_y = (int)Math.ceil((double)num / w);
            int target_x = num % w == 0 ? w : num % w;
            if(target_y % 2 == 0) {
                target_x = (w+1) - target_x;
            }
            
            int height = (n/w);
            if(n % w != 0) {
                int count_last_box = n % w;
                if(height % 2 == 0 && target_x <= count_last_box) {
                    height += 1;
                }else if(height % 2 == 1 && target_x > w - count_last_box) {
                    height += 1;
                }
            }
            return height - target_y + 1;
        }
    }
}