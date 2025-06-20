package Implementation.baekjoon;

// 문제 : 곱셈
// 풀이 일자 : 2025.06.20
// 설명 : https://www.acmicpc.net/problem/1629

import java.util.*;
import java.io.*;

public class No_1629 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long answer = pow(a, b, c);
        System.out.println(answer);
    }

    static long pow(long a, long b, long mod) {
        if (b == 0)
            return 1;

        long n = pow(a, b / 2, mod);
        if (b % 2 == 0)
            return n * n % mod;
        else
            return (n * n % mod) * a % mod;
    }
}