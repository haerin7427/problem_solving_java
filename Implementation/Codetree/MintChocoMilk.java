package Implementation.Codetree;

// 문제 : 민트 초코 우유
// 풀이 일자 : 2025.09.06
// 설명 : https://www.codetree.ai/ko/frequent-problems/samsung-sw/problems/mint-choco-milk/description

import java.util.*;
import java.io.*;

public class MintChocoMilk {
    private static int n, t;
    private static String[][] f;
    private static int[][] b;
    private static StringBuffer answer = new StringBuffer();
    private static int[][] move = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
    private static class Leader {
        String food;
        int score;
        int r;
        int c;

        Leader(String f, int s, int r, int c) {
            this.food = f;
            this.score = s;
            this.r = r;
            this.c = c;
        }

    }

    private static class Desk {
        int r;
        int c;

        Desk(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        f = new String[n][n];
        b = new int[n][n];

        for(int y=0; y<n; y++) {
            String str = br.readLine();
            for(int x=0; x<n; x++) {
                f[y][x] = str.substring(x, x+1);
            }
        }

        for(int y=0; y<n; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<n; x++) {
                b[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<t; i++) {
            // 1) 아침
            get_score();

            // 2) 점심
            List<Leader> leaders = make_group();

            // 3) 저녁 : 신앙 전파
            // 신앙심 전파 순서 : 신앙하는 음식명 길이 짧은 순 > 대표 신앙심 큰 순 > 행 번호 작은 순 > 열 번호 작은 순
            Collections.sort(leaders, new Comparator<Leader>(){
                @Override
                public int compare(Leader o1, Leader o2) {
                    if(o1.food.length() == o2.food.length()) {
                        if(o1.score == o2.score) {
                            if(o1.r == o2.r) {
                                return o1.c - o2.c;
                            }else {
                                return o1.r - o2.r;
                            }
                        }else {
                            return o2.score - o1.score;
                        }
                    }else {
                        return o1.food.length() - o2.food.length();
                    }
                }
            });

            
            // 전파 프로세스
            boolean[][] visited = new boolean[n][n];
            for(Leader l : leaders) {
                if(visited[l.r][l.c]) continue; // 전파를 당했다면, 해당 날짜에 전파를 할 수 없음, 전파를 중복으로 당할 수는 있음
                int direction = b[l.r][l.c] % 4; // 신앙심 % 4 에 따라 전파 방향 결정 > 전파 방향 대로 이동하며 전파 시도 
                int cr = l.r, cc = l.c;
                int x = l.score - 1; // 간절함 = 대표자 신앙심 - 1,
                b[l.r][l.c] = 1;     // 대표자의 신앙심 = 1

                while(x > 0) {
                    cr += move[direction][0];
                    cc += move[direction][1];

                    if(cr < 0 || cr >= n || cc < 0 || cc >= n) break;
                    if(f[cr][cc].equals(l.food)) continue; // 3-1 ) 신봉 음식이 같은 경우 -> 전파 안 함
  
                    visited[cr][cc] = true;
                    if(x > b[cr][cc]) {
                        // 3-2-1 ) 간절함이 대상의 신앙심보다 큰 경우
                        //          신봉 음식 변경
                        //          간절함 -= (신앙심 + 1), 신앙심 += 1
                        //          간절함 == 0 -> 종료 
                        f[cr][cc] = l.food;
                        b[cr][cc] += 1;
                        x -= b[cr][cc];
                    }else {
                        // 3-2-2 ) 간절함이 대상의 신앙심보다 크지 않은 경우
                        //          신봉음식 합체
                        //          간절함 = 0, 신앙심 += 간절함
                        f[cr][cc] = add_food(l.food, f[cr][cc]);
                        b[cr][cc] += x;
                        x = 0;
                    }

                }
            }
            
            // 4) 답 출력
            print_result();
        }
        System.out.print(answer);
    }

    private static void test_print_leader(Leader l) {
        System.out.println("[L] food:" + l.food + ", score:" + l.score + ", r:" + l.r + ", c:" + l.c);
    }

    private static void test_print_b_board() {
        for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                System.out.print(b[r][c] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("=========================================");
    }

    private static void print_result() {
        // TCM, TC, TM, CM, M, C, T 순서로 신앙심 총합 구하기
        Map<String, Integer> result = new HashMap<>();
        result.put("TCM", 0);
        result.put("TC", 1);
        result.put("TM", 2);
        result.put("CM", 3);
        result.put("M", 4);
        result.put("C", 5);
        result.put("T", 6);
        int[] score_sum = new int[result.size()];

        for(int y=0; y<n; y++) {
            for(int x=0; x<n; x++) {
                score_sum[result.get(f[y][x])] += b[y][x];
            }
        }

        for(int i=0; i<score_sum.length; i++) {
            answer.append(score_sum[i] +" ");
        }
        answer.append("\n");
    }

    private static String add_food(String word1, String word2) {
        StringBuffer s = new StringBuffer();
        if(word1.contains("T") || word2.contains("T")) {
            s.append("T");
        }
        if(word1.contains("C") || word2.contains("C")) {
            s.append("C");
        }
        if(word1.contains("M") || word2.contains("M")) {
            s.append("M");
        }
        return s.toString();
    }

    private static List<Leader> make_group() {
        List<Leader> leaders = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        
        // 신봉 음식이 같은 학생들과 그룹 만들기 -> BFS
        for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                if(!visited[r][c]) {
                    leaders.add(bfs(visited, r, c));
                }
            }
        }
        return leaders;
    }

    private static Leader bfs(boolean[][] visited, int r, int c) {
        Queue<Desk> queue = new LinkedList<>();
        int count = 0, lr=r, lc=c, ls=b[r][c];

        queue.add(new Desk(r,c));
        visited[r][c] = true;
        String food = f[r][c];
        b[r][c] -= 1;

        while(!queue.isEmpty()){
            count += 1;
            Desk d = queue.remove();
            for(int[] m : move) {
                int nr = d.r + m[0];
                int nc = d.c + m[1];

                if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if(!f[nr][nc].equals(food) || visited[nr][nc]) continue;

                queue.add(new Desk(nr, nc));
                visited[nr][nc] = true;

                if(ls < b[nr][nc]) {
                    lr = nr;
                    lc = nc;
                    ls = b[nr][nc];
                }else if(ls == b[nr][nc]) {
                    if(lr > nr || (lr == nr && lc > nc)) {
                        lr = nr;
                        lc = nc;
                        ls = b[nr][nc];
                    }
                }
                b[nr][nc] -= 1;
            }
        }

        // 대표자 선정 (신앙심 큰 순 > r값 작은 순 > c값 작은 순)
        // 대표자 신앙심 += (그룹원 수 +1), 각 그룹원 신앙심 -= 1
        b[lr][lc] += count;
        return new Leader(food, b[lr][lc], lr, lc);
    }

    private static void get_score() {
        // 신앙심 +1
        for(int y=0; y<n; y++) {
            for(int x=0; x<n; x++) {
                b[y][x] += 1;
            }
        }
    }
}