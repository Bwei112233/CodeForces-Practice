package InterestingPeoblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CD556C {

    static HashSet<Character> vowels = new HashSet<>();

    static {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }

    public static void main(String [] args) {
        final FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        String [] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }
    }




    static void solve(String [] words) {
        HashMap<String, Integer> vowelCount = new HashMap<>();
        HashMap<String, Character> lastVowel = new HashMap<>();

        for (String s : words) {
            if (!vowelCount.containsKey(s)) {
                int count = 0;;
                char last = '1';
                for (int i = 0; i < s.length(); i++) {
                    if (vowels.contains(s.charAt(i))) {
                        count ++;
                        last = s.charAt(i);
                    }
                }
                vowelCount.put(s, count);
                lastVowel.put(s, last);
            }
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int diff = vowelCount.get(o1) - vowelCount.get(o2);
                if (diff != 0) {
                    return diff;
                } else {
                    return lastVowel.get(o1) - lastVowel.get(o2);
                }
            }
        });

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
