package Implementation.baekjoon;

// 문제 : 욕심쟁이 돼지
// 풀이 일자 : 2025.03.25
// 설명 : https://www.acmicpc.net/problem/3060

import java.util.*;
import java.io.*;

public class No_3060 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        float[] pigs = new float[6];
        StringBuffer answer = new StringBuffer();
        for(int i=0; i<test_case; i++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            float total = 0;
            int day = 1;
            for(int j=0; j<pigs.length; j++) {
                pigs[j] = Float.parseFloat(st.nextToken());
                total += pigs[j];
            }

            while(N >= total) {
                day += 1;
                total = 0;

                float[] temp = new float[6];
                for(int j=0; j<pigs.length; j++) {
                    int left = (j+1) % (pigs.length);
                    int right = ((j-1) < 0 ? pigs.length-1 : j-1) % (pigs.length);
                    int front = (j+3) % (pigs.length);
                    temp[j] = pigs[j] + pigs[left] + pigs[right] + pigs[front];
                }

                for(int j=0; j<pigs.length; j++) {
                    pigs[j] = temp[j];
                    total += pigs[j];
                }
            }
            answer.append(day).append("\n");
        }
        System.out.print(answer);
        
    }
    
}
