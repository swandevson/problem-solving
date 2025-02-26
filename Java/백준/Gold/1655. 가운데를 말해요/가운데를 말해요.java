import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
		    int v = Integer.parseInt(br.readLine());
		    
		    if (i % 2 == 0) {
		        max.add(v);
		    } else {
		        min.add(v);
		    }
		    
		    if (!min.isEmpty() && !max.isEmpty() && max.peek() > min.peek()) {
		        int p = max.remove();
                max.add(min.remove());
		        min.add(p);
		    }
		   
            int median = max.peek();		   
		    bw.write(String.valueOf(median));
		    bw.newLine();
		}
		
		bw.flush();
	}
}