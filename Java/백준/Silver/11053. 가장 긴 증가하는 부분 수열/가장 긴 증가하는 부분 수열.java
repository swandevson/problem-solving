import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int[] dp = new int[n];


		int length = 1;
		dp[0] = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] > dp[length-1]) {
				dp[length++] = arr[i];
				continue;
			}
			if (arr[i] == dp[length-1]) {
				continue;
			}
			int idx = Arrays.binarySearch(dp, 0, length-1, arr[i]);
			idx = idx < 0 ? -idx-1 : idx;
			dp[idx] = arr[i];
		}

		System.out.println(length);
	}
}