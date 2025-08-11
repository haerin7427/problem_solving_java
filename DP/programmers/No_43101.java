package DP.programmers;

// 문제 : 정수 삼각형
// 풀이 일자 : 2025.08.10
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/43105

public class No_43101 {
    class Solution {
        public int solution(int[][] triangle) {
            
            for(int y = 1; y<triangle.length; y++) {
                triangle[y][0] += triangle[y-1][0];
                for(int x = 1; x<triangle[y].length-1; x++) {
                    triangle[y][x] += Math.max(triangle[y-1][x-1], triangle[y-1][x]);
                }
                triangle[y][triangle[y].length-1] += triangle[y-1][triangle[y-1].length-1];
            }
            int answer = 0;
            for(int x = 0; x<triangle[triangle.length-1].length; x++) {
                answer = Math.max(answer, triangle[triangle.length-1][x]);
            }
            return answer;
        }
        }
}
