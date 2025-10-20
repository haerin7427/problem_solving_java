package Implementation.programmers;

// 문제 : 이모티콘 할인행사
// 풀이 일자 : 2025.10.20
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/150368?language=java

public class No_150368 {
    class Solution {
        private int[] emoticons_ratio;
        private int max_user=0, max_profit=0;
        
        public int[] solution(int[][] users, int[] emoticons) {

            emoticons_ratio = new int[emoticons.length];
            set_ratio(0, users, emoticons);
            
            int[] answer = {max_user, max_profit};
            return answer;
        }
        
        private void set_ratio(int index, int[][] users, int[] emoticons) {
            if(index == emoticons_ratio.length) {
                calculate_profit(users, emoticons);
                return;
            }
            
            for(int i=10; i<=40; i+=10) {
                emoticons_ratio[index] = i;
                set_ratio(index+1, users, emoticons);
            }
        }
        
        private void calculate_profit(int[][] users, int[] emoticons) {
                    
            int profit = 0, count_user = 0;
            for(int[] user : users) {
                int ratio = user[0];
                int standard = user[1];
                int result = 0;

                int idx = 0;
                for(int emoticon : emoticons) {
                    if(ratio <= emoticons_ratio[idx]) {
                        result += (emoticon / 100 * (100 - emoticons_ratio[idx]));
                    }
                    idx += 1;
                }

                if(result >= standard) {
                    count_user += 1;
                }else {
                    profit += result;
                }
                
            }
            if(max_user < count_user) {
                max_user = count_user;
                max_profit = profit;
            }else if(max_user == count_user && max_profit < profit) {
                max_profit = profit;
            }
        }
    }
}