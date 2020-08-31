import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DifferentRules {
    public static void main(String [] args) {
        final FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int a = 0; a < t; a++) {
            int n = scanner.nextInt(), x = scanner.nextInt(), y = scanner.nextInt();
            System.out.println(solve(n, x, y));
        }
    }


    static String solve(int n, int x, int y) {
        int bestPlace = 0, worstPlace = 0, score = x + y;

        // find best place, or maximize number > x + y
        int xptr = 1, yptr = n;

        int count = 0;
        while (xptr <= n && yptr >= 0) {
            if (xptr == x || yptr == y) {
                if (xptr == x) {
                    xptr ++;
                }
                if (yptr == y) {
                    yptr--;
                }
                continue;
            } else {
                if (xptr + yptr > score) {
                    count ++;
                    xptr++;
                    yptr --;

                } else {
                    xptr++;
                }
            }
        }
        bestPlace = n - count;


        count = 0;
        xptr = 1;
        yptr = n;

        // maximize number of pairs less than or equal to score
        while (xptr <= n && yptr > 0) {
            if (xptr == x || yptr == y) {
                if (xptr == x) {
                    xptr ++;
                }
                if (yptr == y) {
                    yptr--;
                }
                continue;
            } else {
                if (xptr + yptr <= score) {
                    count ++;
                    xptr++;
                    yptr --;
                } else {
                    yptr--;
                }
            }
        }
        worstPlace = count + 1;




        return bestPlace + " " + worstPlace;
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
