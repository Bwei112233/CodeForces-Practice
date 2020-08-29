import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CD556A {

    public static void main(String [] args) {
        final FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int [] dp = new int[n];

        if (n % 2 == 1) {
            System.out.println(0);
        } else {
            double res = Math.pow(2, n / 2);
            System.out.println(doubleToInt(res));
        }
    }



    public static String doubleToInt(double b) {
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
