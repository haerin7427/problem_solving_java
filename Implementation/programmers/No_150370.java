package Implementation.programmers;

// 문제 : 개인정보 수집 유효기간
// 풀이 일자 : 2026.05.06
// https://school.programmers.co.kr/learn/courses/30/lessons/150370

import java.util.*;
public class No_150370 {
    class Solution {
        class Privacy_Date {
            int year;
            int month;
            int day;
            
            Privacy_Date(String s) {
                String[] info = s.split("\\.");
                this.year = Integer.parseInt(info[0]);
                month = Integer.parseInt(info[1]);
                day = Integer.parseInt(info[2]);
            }
            
            
            void add_date(int period) {
                this.year += (period / 12);
                this.month += (period % 12);
                
                if(this.month > 12) {
                    this.month %= 12;
                    this.year += 1;
                }
                
                if(this.day == 1) {
                    if(this.month == 1) {
                        this.year -= 1;
                        this.month = 12;
                    }else
                        this.month -= 1;
                    this.day = 28;
                }else {
                    this.day -= 1;
                }
            }
            
            boolean is_before(Privacy_Date o) {
                if(this.year < o.year) {
                    return true;
                }else if(this.year == o.year) {
                    if(this.month * 28 + this.day <= o.month * 28 + o.day){
                        return true;
                    }
                }
                return false;
            }
        }
        public int[] solution(String today, String[] terms, String[] privacies) {
            
            
            Privacy_Date today_date = new Privacy_Date(today);
            Map<String, Integer> map = new HashMap<>();
            for(String term : terms) {
                String[] t = term.split(" ");
                map.put(t[0], Integer.parseInt(t[1]));
            }
            
            List<Integer> list = new LinkedList<>();
            int n = privacies.length;
            for(int i = 0; i<n ; i++) {
                int id = i+1;
                String[] privacy = privacies[i].split(" ");
                Privacy_Date privacy_date = new Privacy_Date(privacy[0]);
                
                privacy_date.add_date(map.get(privacy[1]));
                
                if(!today_date.is_before(privacy_date)){
                    list.add(id);
                }
            }
            
            int[] answer = new int[list.size()];
            for(int i=0; i<list.size(); i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}
