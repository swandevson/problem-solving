import java.io.*;
import java.util.*;

public class Main {
	static Map<Integer, List<int[]>> adj = new HashMap<>();
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());


		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			List<int[]> routes = adj.getOrDefault(start, new ArrayList<>());
			routes.add(new int[]{dest, cost});
			adj.put(start, routes);
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());

		System.out.println(solve(start, dest));
	}

	static int solve(int start, int dest) {
		boolean[] visited = new boolean[n+1];
		int[] dist = new int[n+1];

		for (int i = 0; i <= n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));

		pq.add(new int[]{start, 0});
		dist[start] = 0;

		while(!pq.isEmpty()) {
			int[] route = pq.poll();
			int cur = route[0];
			if (dist[cur] < route[1] || visited[cur]) {	// 거리로 비교하면 visited도 사실상 필요없음
				continue;
			}
			visited[cur] = true;

			List<int[]> routes = adj.getOrDefault(cur, new ArrayList<>());
			for (int[] r : routes) {
				if (visited[r[0]]) {
					continue;
				}

				if (dist[r[0]] > dist[cur] + r[1]) {

					dist[r[0]] = dist[cur] + r[1];
					pq.add(new int[]{r[0], dist[r[0]]});
				}
			}

		}


		return dist[dest];
	}
}