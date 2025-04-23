package String.backjoon;

// 문제 : 단어 공부
// 풀이 일자 : 2025.04.23
// 설명 : https://www.acmicpc.net/problem/1157

import java.io.*;

public class No_1157 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input_word = br.readLine();

        int[] counts = new int[26];
        int max =0; char answer = '?';
        for(int i=0; i<input_word.length(); i++) {
            char key = input_word.charAt(i);
            if(key >= 'a') {
                key -= ('a' - 'A');
            }
            int index = key - 'A';
            counts[index] += 1;

            if(max < counts[index]) {
                max = counts[index];
                answer = key;
            } else if(max == counts[index]) {
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}
