import java.io.*;
import java.util.*;

public class Main {
	static Map<Integer, List<int[]>> adj = new HashMap<>();
	static int n;
	static int m;
	static int x;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			List<int[]> nodes = adj.getOrDefault(s, new ArrayList<>());
			nodes.add(new int[]{e, w});
			adj.put(s, nodes);
		}

		int[][] fromDist = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			fromDist[i] = solve(i);
		}


		int ans = 0;
		for (int i = 1; i<= n; i++) {
			if (i == x) continue;
			ans = Math.max(ans, fromDist[i][x] + fromDist[x][i]);
		}

		System.out.println(ans);
	}

	static int[] solve(int s) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;

		pq.add(new int[]{s, 0});
		dist[s] = 0;

		while(!pq.isEmpty()) {
			int[] node = pq.poll();
			int cur = node[0];
			int curDist = node[1];

			if (curDist > dist[cur]) continue;

			List<int[]> nextNodes = adj.getOrDefault(cur, new ArrayList<>());
			for (int[] nextNode : nextNodes) {
				int next = nextNode[0];
				int nextDist = nextNode[1];

				if (dist[next] > dist[cur] + nextDist) {
					dist[next] = dist[cur] + nextDist;
					pq.add(new int[]{next, dist[next]});
				}
			}
		}


		return dist;
	}
}