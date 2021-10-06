package SWEA.ssafy.date0930;

import java.io.*;
import java.util.*;

public class SWEA1249_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int N, map[][], dijkstra[][], T;
	static int delta[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static PriorityQueue<int[]> pq = new PriorityQueue<int[]>((v1, v2)->(v1[2]-v2[2]));

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dijkstra = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = Character.getNumericValue(input.charAt(j));
					dijkstra[i][j] = Integer.MAX_VALUE;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(dijkstra()).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int dijkstra() {
		pq.clear();
		pq.offer(new int[] {0, 0, map[0][0]});
		dijkstra[0][0] = map[0][0];
		
		int vertex[], i, j, di, dj;
		while(!pq.isEmpty()) {
			vertex = pq.poll();
			i = vertex[0];
			j = vertex[1];
			
			for(int[] d : delta) {
				di = i + d[0];
				dj = j + d[1];
				
				if(!isOOB(di, dj) && dijkstra[di][dj] > dijkstra[i][j] + map[di][dj]) {
					dijkstra[di][dj] = dijkstra[i][j] + map[di][dj];
					pq.offer(new int[] {di, dj, dijkstra[di][dj]});
				}
			}
		}
		return dijkstra[N-1][N-1];
	}
	
	public static boolean isOOB(int i, int j) {
		if(i>N-1 || i<0 || j>N-1 || j<0) return true;
		else return false;
	}
}
