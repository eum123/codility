package example;

/**
 * You have an array of numbers and you would like to print these
 numbers in a tabular format to make them look more organized. Each cell
 of the table contains exactly one number and is surrounded by exactly
 four edges:

 Capture1

 As you can see above, each corner of the cell is represented by a “+” sign, vertical edges by “-” signs and horizontal edges by “|”
 signs. The width of the cell adjusts to accommodate the number of
 digits of the number written within it. There can be many cells in a
 row. Adjacent cells share an edge:

 Capture1

 Note that each cell has the same width. The width of the cell adjusts
 to match the width of the longest number in the table. The numbers in
 cells are aligned to the right, with any unused area in each cell filled
 with spaces.

 The table can consist of many rows, and adjacent rows share an edge:

 capture2.png


 Your goal is to output a table containing all the numbers from a
 given array such that each row contains exactly K numbers. The last row
 can contain fewer numbers.

 Write a function:

 class Solution { public void solution(int[] A, int K); }

 that, given a non-empty array A consisting of N integers and an
 integer K, prints a string representing the formatted array. The numbers
 in the table should appear in the same order as the numbers in the
 array.

 For example, given array A = [4, 35, 80, 123, 12345, 44, 8, 5] and K =
 10, the resultant table will contain exactly one row, as shown below:

 Capture3

 For K = 4, the table would appear as follows:

 capture31.png

 Given A = [4, 35, 80, 123, 12345, 44, 8, 5, 24, 3, 22, 35] and K = 4, the table would appear as follows:

 Capture3

 The function shouldn’t return any value.

 You can print a string to the output (without or with the end-of-line character) as follows:

 System.out.print("sample string");

 System.out.println("whole line");

 Assume that:

 N is an integer within the range [1..200];
 K is an integer within the range [1..1,000,000,000];
 each element of array A is an integer within the range [0..1,000,000,000].
 In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.


 https://yudiwiradinata.wordpress.com/2017/08/29/test-java-codility/

 */
public class TableArray {
    public static void main(String[] args) {
        // TODO code application logic here
        int[] A = new int[10];
        A[0] = 4;
        A[1] = 35;
        A[2] = 80;
        A[3] = 123;
        A[4] = 12345;
        A[5] = 44;
        A[6] = 8;
        A[7] = 5;
        A[8] = 24;
        A[9] = 3;

        int K = 2;
        Integer c = (Integer.valueOf(A[0]).toString().toCharArray()).length;
        char[] c1 = c.toString().toCharArray();

        for (int i = 0; i < A.length; i++) {
            c1 = Integer.valueOf(A[i]).toString().toCharArray();
            if (c < c1.length) {
                c = c1.length;
            }
        }
        solution(A, c, K);
    }
    private static void solution(int[] A, Integer c, int loop) {
        int K = loop;
        if (loop > A.length) {
            K = loop - (loop % A.length);
        }

        for (int i = 0; i < K; i++) {
            System.out.print("+");
            for (int j = 0; j < c; j++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
        int v = 0;
        int e = 0;
        if (A.length % loop > 0) {
            e = (A.length / loop) + 1;
        } else {
            e = A.length / loop;
        }

        for (int r = 0; r < e; r++) {
            System.out.print("|");
            for (int i = 0; i < K; i++) {
                for (int j = c; j >= 1; j--) {
                    if (v >= A.length) {
                        break;
                    }
                    if ((Integer.valueOf(A[v]).toString().toCharArray()).length == j) {
                        System.out.print(A[v]);
                        j = j - (Integer.valueOf(A[v]).toString().toCharArray()).length;
                    } else {
                        System.out.print(" ");
                    }
                }
                if (v >= A.length) {
                    break;
                }
                System.out.print("|");
                v++;
            }
            System.out.print("\n");
            //footer
            if (v >= A.length) {
                if (A.length > loop) {
                    for (int i = 0; i < (A.length % loop == 0 ? loop : A.length % loop); i++) {
                        System.out.print("+");
                        for (int j = 0; j < c; j++) {
                            System.out.print("-");
                        }
                    }
                    System.out.println("+");
                } else {
                    for (int i = 0; i < K; i++) {
                        System.out.print("+");
                        for (int j = 0; j < c; j++) {
                            System.out.print("-");
                        }
                    }
                    System.out.println("+");
                }
                break;
            }
            for (int i = 0; i < K; i++) {
                System.out.print("+");
                for (int j = 0; j < c; j++) {
                    System.out.print("-");
                }
            }
            System.out.println("+");
        }
    }
}
