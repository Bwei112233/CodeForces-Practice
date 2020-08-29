import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CD556B {

    public static void main(String [] args) {
        final FastScanner scanner = new FastScanner();
        int h = scanner.nextInt(), w = scanner.nextInt();
        char [][] arr = new char[h][w];
        for (int i = 0; i < h; i++) {
            String s = scanner.next();
            arr[i] = s.toCharArray();
        }

        if (solve(arr)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }



    static boolean solve(char [][] arr) {
        boolean found = false;
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[0].length - 1; j++) {
                if (arr[i][j] == '*') {
                    if (found) {
                        return false;
                    } else if (arr[i - 1][j] == '*' && arr[i][j - 1] == '*' && arr[i + 1][j] == '*' && arr[i][j + 1] == '*') {
                        found = true;
                        arr[i][j] = '.';
                        clear1(arr, i + 1, j);
                        clear2(arr, i - 1, j);
                        clear3(arr, i, j + 1);
                        clear4(arr, i, j - 1);
                    }
                }
            }
        }


        for (char [] a : arr) {
            for (char c : a) {
                if (c == '*') {
                    return false;
                }
            }
        }

        return found;
    }


    static void clear1(char[][] arr, int i, int j) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) return;

        if (arr[i][j] == '*') {
            arr[i][j] = '.';
            clear1(arr, i + 1, j);
        }
    }

    static void clear2(char[][] arr, int i, int j) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) return;

        if (arr[i][j] == '*') {
            arr[i][j] = '.';
            clear2(arr, i - 1, j);
        }
    }

    static void clear3(char[][] arr, int i, int j) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) return;

        if (arr[i][j] == '*') {
            arr[i][j] = '.';
            clear3(arr, i, j + 1);
        }
    }

    static void clear4(char[][] arr, int i, int j) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) return;

        if (arr[i][j] == '*') {
            arr[i][j] = '.';
            clear4(arr, i, j - 1);
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
