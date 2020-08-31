import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class SkyScraper {

    public static void main(String [] args) {
        final FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        double [] nums = scanner.readAsDouble(n);
        int [] sol = solve(nums);
        System.out.println(printArr(sol));
    }

    public static String printArr(int [] arr) {
        StringBuilder s = new StringBuilder();
        for (int i : arr) {
            s.append(i);
            s.append(" ");
        }
        return s.toString();
    }


    static int [] solve(double [] nums) {
        double [] leftToRight = new double[nums.length];
        double [] rightToLeft = new double[nums.length];
        Stack<Integer> stack = new Stack<>();

        // init dp
        leftToRight[0] = nums[0];
        stack.push(0);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[stack.peek()]) {
                leftToRight[i] = (nums[i] * (i - stack.peek())) + leftToRight[stack.peek()];
            } else {
                int last = 0;
                while (stack.size() > 0 && nums[stack.peek()] > nums[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    leftToRight[i] = nums[i] * (i + 1);
                } else {
//                    System.out.println("last is " + last + " and i is " + i);
                    last = stack.peek();
                    leftToRight[i] = leftToRight[last] + (nums[i] * (i - last));
                }
            }
            stack.push(i);
        }

        stack.clear();
        rightToLeft[nums.length - 1] = nums[nums.length - 1];
        stack.push(nums.length - 1);

        double max = 0;
        int biggestIndex = 0;

        for (int i = nums.length - 1; i >= 0; i --) {
            if (nums[i] >= nums[stack.peek()]) {
                rightToLeft[i] = (nums[i] * Math.abs(i - stack.peek())) + rightToLeft[stack.peek()];
            } else {
                int last = 0;
                while (stack.size() > 0 && nums[stack.peek()] > nums[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    rightToLeft[i] = nums[i] * (nums.length - i);
                } else {
                    last = stack.peek();
                    rightToLeft[i] = rightToLeft[last] + (nums[i] * Math.abs(i - last));
                }
            }
            stack.push(i);

            double curr = rightToLeft[i] - nums[i] + leftToRight[i];
            if (curr > max) {
                max = curr;
                biggestIndex = i;
            }
        }

        int [] sol = new int[nums.length];
        double x = nums[biggestIndex];
        sol[biggestIndex] = (int) x;
        for (int i = biggestIndex - 1; i >= 0; i--) {
            x = Math.min(x, nums[i]);
            sol[i] = (int) x;
        }

        x = nums[biggestIndex];
        for (int i = biggestIndex + 1; i < nums.length; i++) {
            x = Math.min(x, nums[i]);
            sol[i] = (int) x;
        }


//        System.out.println(Arrays.toString(leftToRight));
//        System.out.println(Arrays.toString(rightToLeft));

        return sol;
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
