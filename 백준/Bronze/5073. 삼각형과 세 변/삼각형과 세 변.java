import java.util.*;
import java.io.*;

// 1. count max people number each column
// 2. next column at same
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if(a == 0 && b == 0 && c == 0) {
                br.close();
                bw.close();
                return;
            }
            
            if (a >= (b+c) || b >= (a+c) || c >= (a+b)) {
                bw.write("Invalid\n");
            } else if(a == b && b == c && c == a) {
                bw.write("Equilateral\n");
            } else if (a == b || a == c || b == c) {
                bw.write("Isosceles\n");
            } else {
                bw.write("Scalene\n");
            }
            
            bw.flush();
        }
        
        
    }
}