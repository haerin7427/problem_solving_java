package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test3 {
    private static int N, M, max_safe_area=0;
    private static int[][] room;
    private static int[][] move = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {

        // 1. 벽을 세울 수 있는 가능한 조합 만들기 DFS
        // 2. 벽을 세웠을 때 바이러스 퍼뜨리기
        // 3. 안전한 영역 카운트 하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];

        for(int y=0; y<N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<M; x++) {
                room[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        create_wall(0);
        System.out.println(max_safe_area);
    }

    private static void create_wall(int depth) {
        if(depth == 3) {
            max_safe_area = Math.max(max_safe_area, check_safe_area(check_virus()));
            return;
        }

        for(int y=0; y<N; y++) {
            for(int x=0; x<M; x++) {
                if(room[y][x] == 0) {
                    room[y][x] = 1;
                    create_wall(depth+1);
                    room[y][x] = 0;
                }
            }
        }
    }

    private static int[][] check_virus() {
        int[][] new_room = new int[N][M];
        for(int y=0; y<N; y++) {
            new_room[y] = room[y].clone();
        }

        
        Queue<int[]> queue = new LinkedList<>();
        for(int y=0; y<N; y++) {
            for(int x=0; x<M; x++) {
                if(room[y][x] == 2) {
                    queue.add(new int[]{y, x});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] current = queue.remove();

            for(int[] m : move) {
                int ny = current[0] + m[0];
                int nx = current[1] + m[1];

                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if(new_room[ny][nx] == 0) {
                    new_room[ny][nx] = 2;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
        return new_room;
    }

    private static int check_safe_area(int[][] result) {
        int count = 0;

        for(int y=0; y<N; y++) {
            for(int x=0; x<M; x++) {
                if(result[y][x] == 0) {
                    count += 1;
                }
            }
        }

        return count;
    }
}
