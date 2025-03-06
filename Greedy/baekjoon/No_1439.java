package Greedy.baekjoon;

// 문제 : 뒤집기
// 풀이 일자 : 2025.03.06
// 설명 : https://www.acmicpc.net/problem/1439

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_1439 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int count0 = 0, count1 = 0;
        char pre = '2';
        for(char num : str.toCharArray()) {
            if(pre != num) {
                pre = num;
                if(num == '0') {
                    count0 += 1;
                }else {
                    count1 += 1;
                }
            }
        }
        System.out.println(Math.min(count0, count1));
    }
    
}
