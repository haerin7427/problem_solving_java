package DFS_BFS.baekjoon;

// 문제 : 가르침
// 풀이 일자 : 2025.08.08
// 설명 : https://www.acmicpc.net/problem/1062

import java.util.*;
import java.io.*;

public class No_1062 {
    static int n, k;
    static List<String> list = new ArrayList<>();
    static boolean[] visited = new boolean[26];
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();

            list.add(temp.substring(4, temp.length() - 4));
        }

        if(k >= 5) {
            visited['a' - 'a'] = true;
            visited['c' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;

            find(1, k-5);
        }
        System.out.println(answer);
    }

    private static void find(int index, int count) {
        if(count == 0) {
            check_sentence();
            return;
        }
        
        for(int i=index; i<26; i++) {
            if(visited[i]) {
                continue;
            }

            visited[i] = true;
            find(i+1, count-1);
            visited[i] = false;
        }
    }

    private static void check_sentence() {
        int count = 0;
        for(String value : list) {
            boolean flag = true;
            for(int i=0; i<value.length(); i++) {
                if(!visited[value.charAt(i)- 'a']) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                count += 1;
            }
        }

        if(count > answer) {
            answer = count;
        }
    }
}