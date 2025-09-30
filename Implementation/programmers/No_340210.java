package Implementation.programmers;

// 문제 : 수식 복원하기
// 풀이 일자 : 2025.09.30
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/340210

import java.util.*;

public class No_340210 {
    class Solution {
        public String[] solution(String[] expressions) {
            String[][] input = new String[expressions.length][5];
            int min = 2, max = 9, count_x = 0;
            StringTokenizer st;
            
            for(int i=0; i<expressions.length; i++){
                st = new StringTokenizer(expressions[i]);
                
                for(int j=0; j<input[i].length; j++) {
                    input[i][j] = st.nextToken();
                    
                    if(j % 2 == 0) {
                        for(char c : input[i][j].toCharArray()) {
                            if(c < '0' || c > '9') continue;
                            if(min <= (c - '0')) {
                                min = (c - '0') + 1;
                            }
                        }
                    }
                }
                
                List<Integer> list = new ArrayList<>();
                if(input[i][4].equals("X")) {
                    count_x += 1;
                    continue;
                }
                
                for(int k=min; k<=max; k++) {
                    int num1 = Integer.parseInt(input[i][0], k);
                    int num2 = Integer.parseInt(input[i][2], k);
                    int num3 = Integer.parseInt(input[i][4], k);
                    int result = input[i][1].equals("-") ? num1 - num2 : num1 + num2;

                    if(result == num3) {
                        list.add(k);
                    }
                }
                Collections.sort(list);
                
                if(min < list.get(0)) {
                    min = list.get(0);
                }
                
                if(max > list.get(list.size()-1)) {
                    max = list.get(list.size()-1);
                }
            }

            String[] answer = new String[count_x];
            int idx = 0;
            for(String[] o : input) {
                if(!o[4].equals("X")) continue;
                
                boolean flag = true;
                int value = 10000;
                for(int k=min; k<=max; k++) {
                    int num1 = Integer.parseInt(o[0], k);
                    int num2 = Integer.parseInt(o[2], k);
                    String result = Integer.toString(o[1].equals("-") ? num1 - num2 : num1 + num2, k);
                    
                    if(value == 10000) {
                        value = Integer.parseInt(result);
                    }else if(value != Integer.parseInt(result)) {
                        flag = false;
                        break;
                    }
                }
                
                if(flag) {
                    answer[idx++] = o[0] + " " + o[1] + " " + o[2] + " = " + String.valueOf(value);
                }else {
                    answer[idx++] = o[0] + " " + o[1] + " " + o[2] + " = ?";
                }
            }
            return answer;
        }
    }
}
