import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    long n = Long.parseLong(st.nextToken());
    
    long sum = 0;
    for (long i = 1; i <= n; i++) {
        if (i == 1) {
            sum += (n-1);
        } else {
            sum += 2*(n-i);
        }
    }

    bw.write(sum + "\n");
    for (long i = 2; i <= n; i++) {
        bw.write(1 + " " + i);
        bw.newLine();
    }
    
    
    bw.close();
  }
}