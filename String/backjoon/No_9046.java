package String.backjoon;

// 문제 : 복호화
// 풀이 일자 : 2025.04.23
// 설명 : https://www.acmicpc.net/problem/9046

import java.io.*;
import java.util.*;

public class No_9046 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            String sentence = br.readLine();

            Map<Character, Integer> map = new HashMap<>();

            int max = 0;
            char answer = '?';
            for(char key : sentence.toCharArray()) {
                if(key != ' ') {
                    int count = map.getOrDefault(key, 0) + 1;
                    map.put(key, count);

                    if(max < count) {
                        max = count;
                        answer = key;
                    }else if(max == count) {
                        answer = '?';
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
