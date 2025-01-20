import java.util.*;
import java.io.*;

// 1. count max people number each column
// 2. next column at same
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        int p = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= p; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            
            List<Integer> line = new ArrayList<>();
            int cnt = 0;
            while(st.hasMoreTokens()) {
                int h = Integer.parseInt(st.nextToken());
                
                if (line.isEmpty()) {
                    line.add(h);
                    continue;
                }
                
                int last = line.get(line.size() - 1);
                
                if (h > last) {
                    line.add(h);
                    continue;
                }
                
                for (int i = 0; i < line.size(); i++) {
                    if (line.get(i) > h) {
                        line.add(i, h);
                        cnt += (line.size()- i - 1);
                        break;
                    }
                }
            }
            
            bw.write(String.valueOf(t) + " " + String.valueOf(cnt));
            bw.newLine();
            bw.flush();
        }
    }
}