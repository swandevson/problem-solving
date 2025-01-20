import java.util.*;
import java.io.*;

// 1. count max people number each column
// 2. next column at same
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        int n = Integer.parseInt(br.readLine());
        
        List<String> casts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            casts.add(br.readLine());
        }
        List<String> copy1 = new ArrayList<>(casts);
        List<String> copy2 = new ArrayList<>(casts);
        
        
    
        String ans1 = "";
        // find kbs, and move to top
        int idx1 = copy1.indexOf("KBS1");
        ans1 += "1".repeat(idx1);
        copy1.remove(idx1);
        copy1.add(0, "KBS1");
        ans1 += "4".repeat(idx1);
        
        int idx2 = copy1.indexOf("KBS2");
        ans1 += "1".repeat(idx2);
        copy1.remove(idx2);
        copy1.add(1, "KBS2");
        ans1 += "4".repeat((idx2 - 1));
        
        
        System.out.println(ans1);
    }
}