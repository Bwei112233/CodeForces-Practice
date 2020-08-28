package InterestingPeoblems;

import com.sun.javafx.binding.StringFormatter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SpyString {

    public static void main(String [] args) {
        final FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int a = 0; a < t; a++) {
            int n = scanner.nextInt(), m = scanner.nextInt();
            String [] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();
            }
            System.out.println(solve(strings, m));
        }
    }




    static String solve(String [] strings, int m) {
        if (m == 1 || strings.length == 1) {
            return strings[0];
        }
        String [][] dp = new String[m][(int) Math.pow(2, strings.length)];
        HashSet<Character> needToCheck = new HashSet<>();
        for (String s : strings) {
            needToCheck.add(s.charAt(0));
        }


        for (Character start : needToCheck) {
            int mask = getMask(start, strings, 0);
            String res = start + helper(strings, m, 1, mask, dp);
            if (res.length() == m) {
                return res;
            }
        }
        return "-1";
    }


    static String helper(String [] strings, int m, int index, int mask, String [][] dp) {
        if (index >= m) {
            return "";
        }
//        System.out.println(index + " " + mask);
//        System.out.println(dp[0].length);
        if (dp[index][mask] != null) {
            return dp[index][mask];
        }

        if (mask == 0) {
            HashSet<Character> needToCheck = new HashSet<>();
            for (String s : strings) {
                needToCheck.add(s.charAt(index));
            }
            for (Character start : needToCheck) {
                int newMask = getMask(start, strings, index);
                String res = start + helper(strings, m, index + 1, newMask, dp);
                if (res.length() == m - index) {
                    dp[index][mask] = res;
                    return res;
                }
            }
            return "";
        } else {
            int bit = 1;
            char needed = '*';

            for (int i = 0; i < strings.length; i++) {
                if ((mask & bit) == bit) {
                    if (needed == '*') {
                        needed = strings[i].charAt(index);
                    } else {
                        if (strings[i].charAt(index) != needed) {
                            return "";
                        }
                    }
                }
                bit = bit << 1;
            }

            for (int i = 0; i < strings.length; i++) {
                if (strings[i].charAt(index) != needed) {
                    mask += 1 << i;
                }
            }

            dp[index][mask] = needed + helper(strings, m, index + 1, mask, dp);
            return dp[index][mask];
        }

    }


    static int getMask(char c, String [] strings, int pos) {
        int mask = 0;
        for (int i = 0; i < strings.length; i++) {
            if (c != strings[i].charAt(pos)) {
                mask += 1 << i;
            }
        }
        return mask;
    }






    private static String doubleAsInt(double b) {
        return String.format("%.0f", b);
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