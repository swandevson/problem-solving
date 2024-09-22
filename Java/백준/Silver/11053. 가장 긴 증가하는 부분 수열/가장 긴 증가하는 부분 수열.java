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


		int length = 0;
		for (int num : arr) {
			int idx = Arrays.binarySearch(dp, 0, length, num);

			if (idx < 0) {
				idx = -idx - 1;
			}
			// System.out.println(idx);
			dp[idx] = num;

			if (idx == length) {
				length++;
			}
		}

		System.out.println(length);
	}
}