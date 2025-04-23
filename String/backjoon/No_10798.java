package String.backjoon;

import java.util.LinkedList;

// 문제 : 세로읽기
// 풀이 일자 : 2025.04.23
// 설명 : https://www.acmicpc.net/problem/10798

import java.io.*;
import java.util.*;

public class No_10798 {
    public static class Sentence {
        int len;
        String content;

        Sentence (int len, String content) {
            this.len = len;
            this.content = content;
        }
    }
    public static void main(String[] args) throws Exception {

        List<Sentence> board = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        for(int i=0; i<5; i++) {
            String str = br.readLine();
            if(max < str.length()) {
                max = str.length();
            }
            board.add(new Sentence(str.length(), str));
        }

        StringBuffer answer = new StringBuffer();

        for(int i=0; i<max; i++) {
            for(int j=0; j<5; j++) {
                if(board.get(j).len <= i) continue;

                answer.append(board.get(j).content.charAt(i));
            }
        }
        System.out.println(answer);
    }
}
