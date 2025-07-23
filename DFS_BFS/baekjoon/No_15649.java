package DFS_BFS.baekjoon;

// 문제 : N과 M (1)
// 풀이 일자 : 2025.07.23
// 설명 : https://www.acmicpc.net/problem/15649

import java.util.*;
import java.io.*;

public class No_15649 {
    static int n, m;
    static List<Integer> list = new LinkedList<>();
    static StringBuffer answer = new StringBuffer();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(1);
        System.out.print(answer);

    }

    private static void dfs (int value) {
        if(m == list.size()) {
            print_value();
        }else {
            for(int i = 1; i<=n; i++) {
                if(!list.contains(i)) {
                    list.add(i);
                    dfs(value+1);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    private static void print_value() {
        for(int value : list) {
            answer.append(value + " ");
        }
        answer.append("\n");
    }
}