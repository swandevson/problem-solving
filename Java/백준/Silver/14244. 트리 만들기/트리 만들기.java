import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    
    if (m == 2) {
        for (int i = 0; i < n - 1; i++) {
            bw.write(i + " " + (i+1));
            bw.write("\n");
        }
        bw.close();
        return;
    }
    
    for (int i = 1; i <= m; i++) {
        bw.write(0 + " " + i);
        bw.write("\n");
    }
    for (int i = m+1; i < n; i++) {
        bw.write((i-1) + " " + i);
        bw.write("\n");
    }
    
    bw.close();
  }
}