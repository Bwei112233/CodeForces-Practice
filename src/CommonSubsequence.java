import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CommonSubsequence {

    public static void main(String [] args) {
        final FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int a = 0; a < t; a++) {
            int n = scanner.nextInt();
            int [] stones = scanner.readArray(n);
            solve(stones);
        }
    }



    public static void solve(int [] stones) {
        // true if first player can win starting at index i
        boolean [] dp = new boolean[stones.length];

        for (int i = stones.length - 1; i >= 0; i--) {
            if (i == stones.length - 1) {
                dp[i] = true;
            } else {
                if (stones[i] == 1) {
                    dp[i] = !dp[i + 1];
                } else {
                    dp[i] = true;
                }
            }

        }
        if (dp[0]) {
            System.out.println("First");
        } else {
            System.out.println("Second");
        }



    }

    public String doubleToInt(double b) {
        String s = String.format("%.0f", b);
        return s;
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}





