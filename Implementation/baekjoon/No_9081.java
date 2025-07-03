package Implementation.baekjoon;

// 문제 : 단어 맞추기
// 풀이 일자 : 2025.07.01
// 설명 : https://www.acmicpc.net/problem/9081

import java.util.*;
import java.io.*;

public class No_9081 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for(int i=0; i<t; i++) {
            String s = br.readLine();

            for(int j=s.length()-1; j>0; j--) {
                if(s.charAt(j-1) < s.charAt(j)) {
                    List<Character> list = new ArrayList<>();
                    Character point = 'a';
                    for(int h=j-1; h<s.length(); h++) {
                        list.add(s.charAt(h));

                        if(s.charAt(j-1) < s.charAt(h) && point > s.charAt(h)) {
                            point = s.charAt(h);
                        }
                    }
                    list.remove(point);
                    Collections.sort(list);
                    if(j > 1) {
                        sb.append(s.substring(0, 0));
                    }
                    sb.append(s.substring(0, j-1) + point);
                    for(char c : list) {
                        sb.append(c);
                    }
                    sb.append("\n");
                    break;
                }else if(j == 1) {
                    sb.append(s+"\n");
                }

            }
        }
        System.out.print(sb);
    }
}
