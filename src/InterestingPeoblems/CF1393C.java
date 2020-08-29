package InterestingPeoblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1393C {
    public static void main(String [] args) {
        final FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int a = 0; a < t; a++) {

        }
    }


    public int solve(int [] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 1));
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (map.get(o1) - map.get(o2)) * -1;
            }
        });

        for (Integer key : map.keySet()) {
            heap.add(key);
        }

        Queue invalid = new LinkedList();

        // bsearch
        int low = 1, high = map.size() - 1;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (canMake(mid, heap, invalid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        if (canMake(high, heap, invalid)) {
            return high;
        } else {
            return low;
        }
    }


    static boolean canMake(int length, PriorityQueue<Integer> heap, Queue invalid) {
            return true;
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
