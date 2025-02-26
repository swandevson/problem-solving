import java.util.*;
import java.io.*;

public class Main {
    static int r, c;
    static Queue<int[]> waterQueue = new LinkedList<>();
    static Queue<int[]> swanQueue = new LinkedList<>();
    static Queue<int[]> nextWaterQueue = new LinkedList<>();
    static Queue<int[]> nextSwanQueue = new LinkedList<>();
    static boolean[][] visited;
    static int[] swanPos = new int[2];
    static char[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        matrix = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            matrix[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '.' || matrix[i][j] == 'L') {
                    waterQueue.add(new int[]{i, j});
                }
                if (matrix[i][j] == 'L') {
                    swanPos = new int[]{i, j};
                }
            }
        }

        swanQueue.add(swanPos);
        visited[swanPos[0]][swanPos[1]] = true;

        int day = 0;
        while (true) {
            if (solve()) {
                System.out.println(day);
                return;
            }
            updateMatrix();
            day++;
        }
    }

    public static boolean solve() {
        final int[] dx = {1, 0, -1, 0};
        final int[] dy = {0, 1, 0, -1};

        while (!swanQueue.isEmpty()) {
            int[] pos = swanQueue.poll();
            int x = pos[0];
            int y = pos[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;

                if (matrix[nx][ny] == 'X') {
                    nextSwanQueue.add(new int[]{nx, ny});
                } else if (matrix[nx][ny] == 'L') {
                    return true;
                } else {
                    swanQueue.add(new int[]{nx, ny});
                }
            }
        }

        swanQueue = nextSwanQueue;
        nextSwanQueue = new LinkedList<>();
        return false;
    }

    public static void updateMatrix() {
        final int[] dx = {1, 0, -1, 0};
        final int[] dy = {0, 1, 0, -1};

        while (!waterQueue.isEmpty()) {
            int[] pos = waterQueue.poll();
            int x = pos[0];
            int y = pos[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }

                if (matrix[nx][ny] == 'X') {
                    matrix[nx][ny] = '.';
                    nextWaterQueue.add(new int[]{nx, ny});
                }
            }
        }

        waterQueue = nextWaterQueue;
        nextWaterQueue = new LinkedList<>();
    }
}