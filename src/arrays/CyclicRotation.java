package arrays;

import java.util.Arrays;

/**
 * <pre>
 * A zero-indexed array A consisting of N integers is given. Rotation of the
 * array means that each element is shifted right by one index, and the last
 * element of the array is also moved to the first place.
 * 
 * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7].
 * The goal is to rotate array A K times; that is, each element of A will be
 * shifted to the right by K indexes.
 * 
 * Write a function:
 * 
 * class Solution { public int[] solution(int[] A, int K); } that, given a
 * zero-indexed array A consisting of N integers and an integer K, returns the
 * array A rotated K times.
 * 
 * For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should
 * return [9, 7, 6, 3, 8].
 * 
 * Assume that:
 * 
 * N and K are integers within the range [0..100]; each element of array A is an
 * integer within the range [−1,000..1,000]. In your solution, focus on
 * correctness. The performance of your solution will not be the focus of the
 * assessment.
 * </pre>
 * 
 * @author jin
 *
 */
public class CyclicRotation {
	public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
		
		if(A.length <= 0) {
			return A;
		}
		int index = K>A.length? K%A.length:K;
		
		
		int[] B = new int[A.length];
		
		for(int i=0 ;i<A.length ; i++) {
			if((i + index) < A.length ) {
				B[i + index] = A[i];
			} else {
				B[(i + index) - A.length] = A[i];
			}
		}
		
		return B;
    }
	
	public static void main(String[] args) {
		CyclicRotation c = new CyclicRotation();
		int[] A = {};
		
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(c.solution(A, 2)));
		
		
	}
	
}
