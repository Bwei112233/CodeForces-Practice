package Round520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class APrank {

    public static void main(String [] args) {
        final FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int [] nums = scanner.readArray(n);
        List<Integer> list = new ArrayList<>();
        list.add(0);

        for (int num : nums) list.add(num);


        list.add(1001);


        System.out.println(solve(list));

    }



    static int solve(List<Integer> nums) {
        int n = nums.size();

        int max = 0;
        int count = 0;

        for (int i = 0; i <= nums.size() - 3; i++) {
            int a = nums.get(i), b = nums.get(i + 1), c = nums.get(i + 2);
            if (a == b - 1 && b == c - 1) {
                count ++;
            } else {
                count = 0;
            }
            max = Math.max(count, max);
        }
        return max;
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


class UnionFind {
    public int size;
    public int numGroups;
    public int [] parent;
    public int [] groupSize;

    public UnionFind(int vertices) {
        size = vertices;
        numGroups = vertices;
        parent = new int[vertices];
        groupSize = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            groupSize[i] = 1;
        }
    }


    public int find(int vertex) {
        if (parent[vertex] == vertex) {
            return vertex;
        } else {
            int cur_parent = parent[vertex];
            int root = find(cur_parent);
            parent[vertex] = root;
            return root;
        }
    }


    public void union(int v1, int v2) {
        int root1 = find(v1), root2 = find(v2);
        if (root1 != root2) {
            if (groupSize[root1] > groupSize[root2]) {
                parent[root2] = root1;
                groupSize[root1] += groupSize[root2];
            } else {
                parent[root1] = root2;
                groupSize[root2] += groupSize[root1];
            }
            numGroups--;
        }
    }


    public boolean connected(int v1, int v2) {
        return find(v1) == find(v2);
    }

}




