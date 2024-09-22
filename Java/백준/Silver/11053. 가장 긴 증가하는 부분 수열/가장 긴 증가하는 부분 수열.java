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
			int idx = Arrays.binarySearch(dp, 0, length - 1, arr[i]);
			if (idx < 0) {
				idx = -idx - 1;
			}
			dp[idx] = arr[i];
		}

		System.out.println(length);


		// lis_dp(dp, arr, n);
	}

	static int binary_search(int[] lis, int left, int right, int target) {
		int mid;

		while (left < right) {
			mid = (left + right) / 2;

			if(lis[mid] < target) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}

		return right;
	}

	static int lis_dp(int[] lis, int[] arr, int N) {
		lis[0] = arr[0];

		int len = 1;
		for (int i = 1; i < N; i++) {
			if (lis[len - 1] < arr[i]) {
				lis[len++] = arr[i];
			}
			else if (lis[len - 1] > arr[i]){
				int idx = binary_search(lis, 0, len - 1, arr[i]);
				lis[idx] = arr[i];
			}
		}
		return len;
	}
}