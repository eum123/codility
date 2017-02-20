package counting;

import java.util.HashSet;

/**
 * <pre>
 * A non-empty zero-indexed array A consisting of N integers is given.
 * 
 * A permutation is a sequence containing each element from 1 to N once, and
 * only once.
 * 
 * For example, array A such that:
 * 
 * A[0] = 4 A[1] = 1 A[2] = 3 A[3] = 2 is a permutation, but array A such that:
 * 
 * A[0] = 4 A[1] = 1 A[2] = 3 is not a permutation, because value 2 is missing.
 * 
 * The goal is to check whether array A is a permutation.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a zero-indexed array A, returns 1 if array A is a permutation and
 * 0 if it is not.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 4 A[1] = 1 A[2] = 3 A[3] = 2 the function should return 1.
 * 
 * Given array A such that:
 * 
 * A[0] = 4 A[1] = 1 A[2] = 3 the function should return 0.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [1..1,000,000,000]. Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 * 
 * </pre>
 * 
 * @author jin
 *
 */
public class PermCheck {
	public int solution(int[] A) {
		// write your code in Java SE 8
		
		int max = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0 ;i<A.length ;i++) {
			set.add(A[i]);
			max = Math.max(max, A[i]);
		}
		if(A.length != set.size()) {
			return 0;
		}
		for(int i=1 ;i<max; i++) {
			if(!set.contains(new Integer(i))) {
				return 0;
			}
		}
		
		return 1;
		
	}
	
	public static void main(String[] args) {
		PermCheck t = new PermCheck();
		System.out.println(t.solution(new int[] {4,1,3,2}));
		System.out.println(t.solution(new int[] {4,1,3}));
		
		System.out.println(t.solution(new int[] {1}));
	}
}
