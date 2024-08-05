import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    
    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0 ; i < n; i++) {
        a[i] = Integer.parseInt(st.nextToken());
    }
    
    int[] b = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0 ; i < m; i++) {
        b[i] = Integer.parseInt(st.nextToken());
    }
    
    // 동일한 시작점에서 작은 것을 먼저 넣고 다음칸 이동
    int aIdx = 0;
    int bIdx = 0;
    
    int[] ans = new int[n+m];
    int idx = 0;
    while (aIdx < n && bIdx < m) {
        if (a[aIdx] > b[bIdx]) {
            ans[idx] = b[bIdx];
            bIdx++;
        } else {
            ans[idx] = a[aIdx];
            aIdx++;
        }
        idx ++;
    }
    
    // 두 배열 중 남은 것을 모두 넣음 (정렬되어 있기때문에 별도 작업 없이 넣으면 됨)
    while(aIdx < n) {
        ans[idx++] = a[aIdx++];
    }
    
    while(bIdx < m) {
        ans[idx++] = b[bIdx++];
    }
    
    for(int i = 0; i < n+m; i++) {
        bw.write(String.valueOf(ans[i]));
        bw.write(" ");
    }
    bw.close();
  }
} 
