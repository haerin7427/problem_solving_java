package Greedy.programmers;

// 문제 : 큰 수 만들기
// 풀이 일자 : 2026.02.23
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/42883

import java.util.*;
public class No_42883 {
    class Solution {
        public String solution(String number, int k) {
            Stack<Character> stack = new Stack<>();
            stack.push(number.charAt(0));
            
            int cnt = 0;
            int n = number.length();
            int idx = n;
            for(int i=1; i<n; i++) {
        
                while(cnt < k && !stack.empty() && stack.peek() < number.charAt(i)) {
                    stack.pop();
                    cnt += 1;
                }
                stack.push(number.charAt(i));
                
                if(cnt == k) {
                    idx = i+1;
                    break;
                }
            }
            
            while(cnt != k) {
                stack.pop();
                cnt += 1;
            }
            
            StringBuffer sb = new StringBuffer();
            while(!stack.empty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString() + number.substring(idx);
        }
    }

    class Solution2 {
        public String solution(String number, int k) {
            Stack<Character> stack = new Stack<>();
            stack.push(number.charAt(0));
            
            int cnt = 0;
            int n = number.length();
            for(int i=1; i<n; i++) {
                while(cnt < k && !stack.empty() && stack.peek() < number.charAt(i)) {
                    stack.pop();
                    cnt += 1;
                }
                stack.push(number.charAt(i));
            }

            StringBuffer sb = new StringBuffer();
            for(int i=0; i<n-k; i++) {
                sb.append(stack.get(i));
            }
            return sb.toString();
        }
    }
}
