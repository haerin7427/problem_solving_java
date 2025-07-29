package DFS_BFS.baekjoon;

// 문제 : 애너그램
// 풀이 일자 : 2025.07.29
// 설명 : https://www.acmicpc.net/problem/6443

import java.io.*;

public class No_6443 {
    static StringBuffer answer = new StringBuffer();
    static int[] used;
    static char[] word;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            used = new int[26];
            count_alpha(br.readLine());

            make_word(0);
        }
        System.out.print(answer);
    }

    private static void count_alpha(String s) {
        word = new char[s.length()];
        for(char o : s.toCharArray()) {
            used[o - 'a'] += 1;
        }
    }

    private static void make_word(int index) {
        if(index == word.length) {
            StringBuffer sb = new StringBuffer();
            for(char o : word) {
                sb.append(o);
            }
            answer.append(sb + "\n");
            return;
        }

        for(int i=0; i<used.length; i++) {
            if(used[i] > 0) {
                used[i] -= 1;
                word[index] = (char)(i + 'a');
                make_word(index+1);
                used[i] += 1;
            }
        }
    }
}