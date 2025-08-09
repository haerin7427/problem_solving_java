package Implementation.programmers;

// 문제 : 충돌위험 찾기
// 풀이 일자 : 2025.08.09
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/340211

import java.util.*;

public class No_340211 {
    class Solution {
    
        private class Robot{
            int no;
            int current_r;
            int current_c;
            int goal_index;
            int goal_r;
            int goal_c;
            
            Robot(int n, int r, int c, int gr, int gc) {
                no = n;
                current_r = r;
                current_c = c;
                goal_index = 1;
                goal_r = gr;
                goal_c = gc;
            }
            
            void move_row (int r) {
                current_r = r;
            }
            void move_col (int c) {
                current_c = c;
            }
            
            void set_goal (int[][] points, int[][] routes) {
                goal_index += 1;
                goal_r = points[routes[no][goal_index]-1][0];
                goal_c = points[routes[no][goal_index]-1][1];
            }
        }
        
        public int solution(int[][] points, int[][] routes) {
            Queue<Robot> queue = new LinkedList<>();
            for(int i=0; i<routes.length; i++) {
                int r = points[routes[i][0]-1][0];
                int c = points[routes[i][0]-1][1];
                
                int gr = points[routes[i][1]-1][0];
                int gc = points[routes[i][1]-1][1];
                queue.add(new Robot(i, r, c, gr, gc));
            }
            
            int row_size = 0, col_size = 0, route_size = routes[0].length-1;
            for(int[] point : points) {
                if(row_size < point[0]) {
                    row_size = point[0];
                }
                if(col_size < point[1]) {
                    col_size = point[1];
                }
            }
            
            int answer = 0;
            while(!queue.isEmpty()){
                
                int count = queue.size();
                
                int[][] visited = new int[row_size+1][col_size+1];
                for(int j=0; j<count; j++){
                    Robot r = queue.remove();
                    
                    // 현재 위치가 충돌 위험이 있는 지 확인
                    if(visited[r.current_r][r.current_c] == 0) {
                        visited[r.current_r][r.current_c] = 1;
                    }else if(visited[r.current_r][r.current_c] == 1) {
                        answer += 1;
                        visited[r.current_r][r.current_c] = 2;
                    }
                    
                    // 현재 위치와 목표 위치 비교
                    if(r.current_r == r.goal_r && r.current_c == r.goal_c) {
                        
                        // 최종 목적지 도달
                        if(r.goal_index == route_size) {
                            continue;
                        }else {
                            r.set_goal(points, routes);
                        }
                    }
                    
                    // 로봇 이동
                    if(r.current_r != r.goal_r) {
                        if(r.current_r < r.goal_r) {
                            r.move_row(r.current_r+1);
                        }else {
                            r.move_row(r.current_r-1);
                        }
                    }else if(r.current_c != r.goal_c) {
                        if(r.current_c < r.goal_c) {
                            r.move_col(r.current_c+1);
                        }else {
                            r.move_col(r.current_c-1);
                        }
                    }
                    queue.add(r);
                }
            }
            return answer;
        }
    }
}