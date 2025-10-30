package Graph.programmers;

// 문제 : 합승 택시 요금
// 풀이 일자 : 2025.10.30
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/72413

import java.util.*;
public class No_72413 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int N = n+1;
        int[][] map = new int[N][N];
        for(int i=0; i<N; i++) {
            Arrays.fill(map[i], 20000000);
            map[i][i] = 0;
        }
        
        for(int[] fare : fares) {
            map[fare[0]][fare[1]] = fare[2];
            map[fare[1]][fare[0]] = fare[2];
        }
        
        for(int i=1; i<N; i++) {
            for(int j=1; j<N; j++) {
                for(int k=1; k<N; k++) {                    
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }
        
        
        int answer = map[s][a] + map[s][b];
        for(int i=1; i<N; i++) {
            answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
        }
        
        return answer;
    }
}
