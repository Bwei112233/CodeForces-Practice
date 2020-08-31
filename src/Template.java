import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Template {

    public static void main(String [] args) {
        final FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int a = 0; a < t; a++) {

        }
    }


    public static String printArr(int [] arr) {
        StringBuilder s = new StringBuilder();
        for (int i : arr) {
            s.append(i);
            s.append(" ");
        }
        return s.toString();
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


        double [] readAsDouble(int n) {
            double [] a = new double[n];
            for (int i=0; i<n; i++) a[i]=(double) nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}





