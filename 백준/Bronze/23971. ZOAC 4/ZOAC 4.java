import java.util.*;

// 1. count max people number each column
// 2. next column at same
public class Main {
    static int H;
    static int W;
    static int N;
    static int M;

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        H = sc.nextInt();
        W = sc.nextInt();
        N = sc.nextInt();
        M = sc.nextInt();
        
        int rowCnt = 0;
        // max count at same row
        for (int i = 0; i < H; i = (i + N + 1)) {
            rowCnt++;
            
        }
        
        int colCnt = 0;
        // max count at same column
        for (int i = 0; i < W; i = (i + M + 1)) {
            colCnt++;
        }
        
        System.out.println(rowCnt * colCnt);

        sc.close();
    }
}