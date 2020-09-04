package Round520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Banhmi {

    static int [][] memo;
    static int [] ones;

    public static void main(String [] args) {
        final FastScanner scanner = new FastScanner();
        int n = scanner.nextInt(), q = scanner.nextInt();
        char [] arr = scanner.next().toCharArray();


//        memo = new int[n + 1][n + 1];
        ones = new int[n];
        if (arr[0] == '1') {
            ones[0] = 1;
        }


        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '1') {
                ones[i] = ones[i - 1] + 1;
            } else {
                ones[i] = ones[i - 1];
            }
        }


//
//        Arrays.fill(memo, -1);



        for (int a = 0; a < q; a++) {
            int start = scanner.nextInt(), end = scanner.nextInt();
            System.out.println(solve(arr, start, end));
        }
    }


    static int solve(char [] arr, int start, int end) {
        int numOnes = 0;
        int numZeros = 0;

        if (start == 1) {
            numOnes = ones[end - 1];
            numZeros = (end - start + 1) - numOnes;
        } else {
            numOnes = ones[end - 1] - ones[start - 2];
            numZeros = (end - start + 1) - numOnes;
        }


//        System.out.println("number of zeros is " + numZeros);
//        System.out.println("number of ones is " + numOnes);

        if (numOnes == 0) {
            return 0;
        }

        double total = 0;
        double zerosStart = (1 << numOnes) - 1;
        double y = ((double)(1 << numZeros) - 1);
        total += (1 << numOnes) - 1;
        total += zerosStart * y;

        return (int) (total % 1000000007);
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
}
