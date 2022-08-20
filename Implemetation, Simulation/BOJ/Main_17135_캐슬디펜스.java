package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스{
    
    static public class Enemy {
        int r;
        int c;
        int d;
        public Enemy(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
        
        public void setD(int d) {
            this.d = d;
        }
        public void setR(int r) {
            this.r = r;
        }
        public void setC(int c) {
            this.c = c;
        }
        public int getR() {
            return r;
        }
        public int getD() {
            return d;
        }
        public int getC() {
            return c;
        }
        
    }
    static int N, M, D;
    static int[][] map;
    static int[] p;
    static int psize;
    static int[] dr = {0, -1, 0};
    static int[] dc = {-1, 0, 1};
    static int maxKill = -1;
    static List<Enemy> enemies;
    static int eSize;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        p = new int[M];
        enemies = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int data = Integer.parseInt(st.nextToken());
                if(data == 1) enemies.add(new Enemy(i, j, 0)); 
            }
        }
        
        for (int i = 0; i < M; i++) {
            p[i] = i;
        }
        
        ncr(0, 0, new int[3]);
        System.out.println(maxKill);
    }

    private static void ncr(int start, int cnt, int[] nums) {
        if (cnt == 3) {
            
            List<Enemy> tempEnemies = new ArrayList<>();
            for (Enemy e : enemies) {
                tempEnemies.add(new Enemy(e.r, e.c, e.d));
            }
            
            eSize = enemies.size();
            int kill = play(nums, tempEnemies);
            maxKill = Math.max(maxKill, kill);
            return;
        }
        
        for (int i = start; i < M ; i++) {
            nums[cnt] = p[i];
            ncr(i+1, cnt+1, nums);
        }
    }

    private static int play(int[] nums, List<Enemy> enemies) {
        Queue<int[]> q = new LinkedList<>();
        int kill = 0;
        
        while(eSize > 0) {
            Set<Enemy> killList = new HashSet<>(3);
            for (int i = 0; i < 3; i++) {
                int ar = N;
                int ac = nums[i];
                PriorityQueue<Enemy> rmHeaq = new PriorityQueue<>(new Comparator<Enemy>() {
                    @Override
                    public int compare(Enemy o1, Enemy o2) {
                        if(o1.d == o2.d) {
                            return o1.c - o2.c;
                        }
                        else return o1.d - o2.d;
                    }
                });
                
                for (Enemy e : enemies) {
                    int d = Math.abs(ar - e.r) + Math.abs(ac - e.c);
                    if (d <= D) {
                        e.setD(d);
                        rmHeaq.add(e);
                    }
                }
                
                if(!rmHeaq.isEmpty()) {
                    Enemy e = rmHeaq.poll();
                    killList.add(e);
                }
            }
            for (Enemy e : killList) {
                enemies.remove(e);
                eSize--;
                kill++;
            }
            
            //적을 중복으로 죽일 경우
            for (int i = eSize-1; i >= 0 ; i--) {
                Enemy e = enemies.get(i);
                if (e.r+1 == N) {
                    enemies.remove(i);
                    eSize--;
                }
                // 한 칸 내려옴
                else e.setR(++e.r);
            }
        }
        
        return kill;
    }
}