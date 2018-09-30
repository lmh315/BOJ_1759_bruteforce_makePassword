package q1759;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int L,C;
	static int[] idx;
	static int[] weight;
	static boolean[] visited;
	static char[] input;
	
	public static void check_password() throws IOException {
		int i,total_weight = 0;

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(i=0;i<L;i++) {
			total_weight += weight[idx[i]];
		}
		if(total_weight >= 1 && total_weight <= L-2) {
			for(i=0;i<L;i++) {
				out.write(input[idx[i]]);
			}
			out.newLine();
		}
		out.flush();
	}
	
	public static void DFS(int v, int cnt) throws IOException {
		int i;
		
		if(cnt == L) {
			check_password();
			return;
		}
		
		for(i=v;i<C;i++) {
			if(visited[i]) continue;

			idx[cnt] = i;
			visited[i] = true;
			cnt++;
		
			DFS(i+1,cnt);
			
			visited[i] = false;
			cnt--;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		int i, j;
		char ch;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		input = new char[C];
		weight = new int[C];
		visited = new boolean[C];
		idx = new int[L];
		
		st = new StringTokenizer(in.readLine());
		for(i=0;i<C;i++) {
			ch = st.nextToken().charAt(0);
			input[i] = ch;
		}
		Arrays.sort(input);
		
		for(i=0;i<C;i++) {
			ch = input[i];
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') weight[i] = 1;
		}
		
		DFS(0,0);
		

		in.close();
	}
}
