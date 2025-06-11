package Implementation.baekjoon;

// 문제 : 톱니바퀴
// 풀이 일자 : 2025.06.11(1h 40m)
// 설명 : https://www.acmicpc.net/problem/14891

import java.io.*;
import java.util.*;

public class No_14891 {
    static final int NUM_COGWHEEL = 4;
    static final int NUM_COG = 8;
    static int[][] tool = new int[NUM_COGWHEEL+1][NUM_COG];
    static int[] top = new int[NUM_COGWHEEL+1];

    private static class COGWHEEL {
        int id;
        int direction;

        COGWHEEL(int i, int d) {
            id = i;
            direction = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String info;
        for(int i=1; i<=NUM_COGWHEEL; i++) {
            info = br.readLine();
            for(int j=0; j<NUM_COG; j++) {
                tool[i][j] = info.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<k; i++) {
            Queue<COGWHEEL> queue = new LinkedList<>();
            boolean[] visited = new boolean[NUM_COGWHEEL+1];

            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            queue.add(new COGWHEEL(id, direction));
            visited[id] = true;

            while (!queue.isEmpty()) {
                COGWHEEL cogwheel = queue.remove();
                int origin_west = get_side_no(cogwheel.id, true);
                int origin_east = get_side_no(cogwheel.id, false);
                int[] values = new int[]{0, tool[cogwheel.id][origin_west], tool[cogwheel.id][origin_east]};

                // 회전
                rotate_cogwheel(cogwheel);
                
                // 회전 해야할 주변 톱니바퀴 찾기
                for(int h=1; h<3; h++) {
                    int next_cog_no = cogwheel.id + (int)Math.pow(-1, h);
                    if(next_cog_no < 1 || next_cog_no > NUM_COGWHEEL || visited[next_cog_no]) continue;

                    int cog_side_no = get_side_no(next_cog_no, h==1 ? false : true);
                    int cog_side_value = tool[next_cog_no][cog_side_no];

                    if(values[h] == cog_side_value) {
                        continue;
                    }else {
                        queue.add(new COGWHEEL(next_cog_no, cogwheel.direction * (-1)));
                        visited[next_cog_no] = true;
                    }
                }
            }
        }

        int total_score = 0;
        for(int i=0; i<NUM_COGWHEEL; i++) {
            int index = i+1;
            if(tool[index][top[index]] == 1) {
                total_score += (int)Math.pow(2, i);
            }
        }
        System.out.println(total_score);
    }

    private static int get_side_no(int cogwheel_no, boolean is_west) {
        if(is_west) {
            return (NUM_COG + top[cogwheel_no] - 2) % NUM_COG;
        }else {
            return (NUM_COG + top[cogwheel_no] + 2) % NUM_COG;
        }
    }

    private static void rotate_cogwheel (COGWHEEL cogwheel) {
        int new_top_cog_id = (NUM_COG + top[cogwheel.id] - cogwheel.direction) % NUM_COG;
        top[cogwheel.id] = new_top_cog_id;
    }
    
}