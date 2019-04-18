import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		int[] a = new int[n];
		int[] b = new int[n-k+1];
		
		stk = new StringTokenizer(br.readLine(), " ");
		a[0] = Integer.parseInt(stk.nextToken());
		
		for(int i = 1; i < n; i++) {
			a[i] = Integer.parseInt(stk.nextToken()) + a[i-1];
		}
		
		b[0] = a[k-1];
		
		for(int i = 1; i < n-(k-1); i++) {
			b[i] = a[i+k-1]-a[i-1];
		}
		
		Arrays.sort(b);
		System.out.println(b[b.length-1]);
	}
}
