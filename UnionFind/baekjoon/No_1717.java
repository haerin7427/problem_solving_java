package UnionFind.baekjoon;

// 문제 : 집합의 표현
// 풀이 일자 : 2025.06.19
// 설명 : https://www.acmicpc.net/problem/1717

import java.io.*;
import java.util.*;

public class No_1717 {
    static int[] values;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        values = new int[n+1];
        for(int i=0; i<=n; i++) {
            values[i] = i;
        }

        StringBuffer answer = new StringBuffer();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(command == 0) {
                union(a, b);
            }else if(command == 1) {
                if(find(a) == find(b)) {
                    answer.append("YES\n");
                }else {
                    answer.append("NO\n");
                }
            }
        }
        System.out.print(answer);
    }

    private static int find(int num) {        
        if(num != values[num]) {
            values[num] = find(values[num]);
        }
        return values[num];
    }

    private static void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);

        if(root_a < root_b) {
            values[root_b] = root_a;
        }else if (root_b < root_a) {
            values[root_a] = root_b;
        }
    }
}