package Implementation.baekjoon;

// 문제 : A → B
// 풀이 일자 : 2025.06.03
// 설명 : https://www.acmicpc.net/problem/16953

import java.io.*;
import java.util.*;

public class No_16953 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long initail = Long.parseLong(st.nextToken());
        long goal = Long.parseLong(st.nextToken());

        long count = 1, num = goal;
        while(initail < num) {
            if(num % 2 == 0) {
                num /= 2;
            } else if(num % 10 == 1){
                num /= 10;
            } else {
                break;
            }
            count += 1;
        }

        if(num != initail) {
            count = -1;
        } 
        System.out.println(count);
    }
    
}
