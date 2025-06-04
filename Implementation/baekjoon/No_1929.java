package Implementation.baekjoon;

// 문제 : 소수 구하기
// 풀이 일자 : 2025.06.04
// 설명 : https://www.acmicpc.net/problem/1929

import java.util.*;
import java.io.*;

public class No_1929 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder answer = new StringBuilder();
        boolean[] visited = new boolean[b+1];
        for(int num=2; num<=b; num++) {
            if(!visited[num] && check_prime_number(num)) {
                if(num >= a) {
                    answer.append(num+"\n");
                }

                int cnt = 2;
                while(num * cnt <=b) {
                    visited[num*cnt] = true;
                    cnt += 1;
                }
            }
        }
        System.out.print(answer.toString());
    }

    private static boolean check_prime_number(int number) {

        for(int i=2; i*i<=number; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}