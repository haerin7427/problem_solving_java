package String.backjoon;

// 문제 : 숫자의 합
// 풀이 일자 : 2025.04.23
// 설명 : https://www.acmicpc.net/problem/11720

import java.io.*;

public class No_11720 {

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String numbers = br.readLine();

        int answer = 0;
        for(int i=0; i<N; i++) {
            answer += (numbers.charAt(i) - '0');
        }

        System.out.println(answer);

    }
    
}
