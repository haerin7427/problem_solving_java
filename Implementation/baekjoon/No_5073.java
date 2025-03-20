package Implementation.baekjoon;

// 문제 : 삼각형과 세 변
// 풀이 일자 : 2025.03.20
// 설명 : https://www.acmicpc.net/problem/5073

import java.util.*;
import java.io.*;

public class No_5073 {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuffer answer = new StringBuffer();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a ==0 && b==0 && c==0) {
                break;
            }

            if(!isPossible(a, b, c)) {
                answer.append("Invalid").append("\n");
                continue;
            }

            if(a == b && b == c) {
                answer.append("Equilateral").append("\n");
            } else if(a == b && a != c) {
                answer.append("Isosceles").append("\n");
            } else if(a == c && a != b) {
                answer.append("Isosceles").append("\n");
            } else if(b == c && b != a) {
                answer.append("Isosceles").append("\n");
            } else {
                answer.append("Scalene").append("\n");
            }
        } 
        System.out.print(answer);
    }

    private static boolean isPossible(int a, int b, int c) {
        int[] array = new int[]{a, b, c};
        Arrays.sort(array);

        if(array[2] < array[0] + array[1]) {
            return true;
        } else {
            return false;
        }
    }
    
}
