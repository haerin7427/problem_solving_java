package Implementation.baekjoon;

// 문제 : 이진수 덧셈
// 풀이 일자 : 2025.07.22
// 설명 : https://www.acmicpc.net/problem/2729

import java.util.*;
import java.io.*;

public class No_2729 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuffer answer = new StringBuffer();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String num1 = new StringBuilder(st.nextToken()).reverse().toString();
            String num2 = new StringBuilder(st.nextToken()).reverse().toString();

            int len = Math.max(num1.length(), num2.length());
            int next = 0;
            StringBuilder temp = new StringBuilder();
            for(int h=0; h<len; h++) {
                int value1 = num1.length() > h ? num1.charAt(h) - '0' : 0;
                int value2 = num2.length() > h ? num2.charAt(h) - '0' : 0;

                int sum = value1 + value2 + next;

                temp.append(sum % 2);
                next = sum / 2;
            }
            temp.append(next);
            answer.append(remove_zero(temp.reverse().toString()) + "\n");
        }
        System.out.print(answer);
    }

    private static String remove_zero(String s) {

        if(s.length() == 0) {
            return "0";
        }
        int index = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) != '0') {
                break;
            }else{
                index += 1;
            }
        }
        return index >= s.length() ? "0" : s.substring(index);
    }
}
