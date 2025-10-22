package Implementation.programmers;

// 문제 : [PCCP 기출문제] 4번 / 수레 움직이기
// 풀이 일자 : 2025.10.22
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/250134

public class No_250134 {
    class Solution {
        private boolean[][] visited_red;
        private boolean[][] visited_blue;
        private int answer = 100;
        private int[][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        private int[][] global_maze;
        private int goal_ry, goal_rx, goal_by, goal_bx;
        private int n, m;
        
        class Wagon {
            int y;
            int x;
            boolean isArrived = false;
            
            Wagon () {}
            
            Wagon (int y, int x) {
                this.y = y;
                this.x = x;
            }
            
            void set_location(int y, int x) {
                this.y = y;
                this.x = x;
            }
            
            void set_arrived() {
                isArrived = true;
            }
            
        }
        
        public int solution(int[][] maze) {
            n = maze.length;
            m = maze[0].length;
            Wagon red = new Wagon();
            Wagon blue = new Wagon();
            
            global_maze = new int[n][m];
            visited_red = new boolean[n][m];
            visited_blue = new boolean[n][m];
            
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(maze[i][j] == 1) {
                        red.set_location(i, j);
                        visited_red[i][j] = true;
                    }else if(maze[i][j] == 2) {
                        blue.set_location(i, j);
                        visited_blue[i][j] = true;
                    }else if(maze[i][j] == 3) {
                        goal_ry = i;
                        goal_rx = j;
                    }else if(maze[i][j] == 4) {
                        goal_by = i;
                        goal_bx = j;
                    }
                    global_maze[i][j] = maze[i][j];
                }
            }
            dfs(red, blue, 0);
            return answer == 100 ? 0 : answer;
        }
        
        
        private void dfs(Wagon red, Wagon blue, int count) {
            
            if(!red.isArrived) {
                if(red.y == goal_ry && red.x == goal_rx) {
                    red.set_arrived();
                }
            }
            if(!blue.isArrived) {
                if(blue.y == goal_by && blue.x == goal_bx) {
                    blue.set_arrived();
                }
            }
            
            if(red.isArrived && blue.isArrived) {
                answer = Math.min(answer, count);
                return ;
            }
            
            for(int i=0; i<4; i++) {
                int ry = red.y, rx = red.x;
                
                if(!red.isArrived) {
                    ry += move[i][0];
                    rx += move[i][1];
                    
                    if(ry < 0 || rx < 0 || ry >= n || rx >= m) continue;
                    if(visited_red[ry][rx] || global_maze[ry][rx] == 5) continue;

                    if(blue.isArrived && ry == blue.y && rx == blue.x) continue;
                    visited_red[ry][rx] = true;
                }
                
                for(int j=0; j<4; j++) {
                    int by = blue.y, bx = blue.x;
                    if(!blue.isArrived) {
                        by += move[j][0];
                        bx +=  move[j][1];
                        
                        if(by < 0 || bx < 0 || by >= n|| bx >= m) continue;
                        if(visited_blue[by][bx] || global_maze[by][bx] == 5) continue;

                        if(ry == by && rx == bx) continue; 
                        if(ry == blue.y && rx == blue.x && by == red.y && bx == red.x) continue;
                        visited_blue[by][bx] = true;
                    }
                    
                    dfs(new Wagon(ry, rx), new Wagon(by, bx), count + 1);
                    
                    if(blue.isArrived) {
                        break;
                    }else{
                        visited_blue[by][bx] = false;
                    }
                }
                
                if(red.isArrived) {
                    break;
                }else{
                    visited_red[ry][rx] = false;
                }
            }
        }
    }
}