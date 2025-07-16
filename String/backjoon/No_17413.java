package String.backjoon;

// 문제 : 단어 뒤집기 2
// 풀이 일자 : 2025.07.16
// 설명 : https://www.acmicpc.net/problem/17413

import java.util.*;
import java.io.*;

public class No_17413 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        StringBuffer answer = new StringBuffer();

        boolean is_tag = false;
        for(char word : s.toCharArray()) {

            if(word == '<') {
                while (!stack.empty()) {
                    answer.append(stack.pop());
                }

                answer.append(word);
                is_tag = true;
            }else if(is_tag) {
                answer.append(word);

                if(word == '>') {
                    is_tag = false;
                }
            }else if(word == ' ') {
                while (!stack.empty()) {
                    answer.append(stack.pop());
                }
                answer.append(word);
            }else {
                stack.add(word);
            }
        }

        while (!stack.empty()) {
            answer.append(stack.pop());
        }

        System.out.println(answer);

    }
    
}