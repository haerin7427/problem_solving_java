package DFS_BFS.baekjoon;

// 문제 : 소-난다!
// 풀이 일자 : 2025.08.02
// 설명 : https://www.acmicpc.net/problem/19699

import java.util.*;
import java.io.*;

public class No_19699 {
    static int n, m;
    static int[] cows;
    static List<Integer> list = new ArrayList();
    static StringBuffer answer = new StringBuffer();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cows = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        if(list.isEmpty()) {
            System.out.println("-1");
        }else {
            Collections.sort(list);
            for(int num : list) {
                answer.append(num+ " ");
            }
            System.out.println(answer);
        }
    }

    private static void dfs(int index, int count, int sum) {
        if(count == m) {
            if(isPrime(sum) && !list.contains(sum)) {
                list.add(sum);
            }
            return;
        }else if(index >= n) {
            return;
        }

        dfs(index+1, count+1, sum + cows[index]);
        dfs(index+1, count, sum);
    }

    private static boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }
}