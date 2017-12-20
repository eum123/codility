package example;

/**
 * 입력한 두 숫자를 곱한 값을 bit를 구하여 '1'인 개수의 합
 */
public class BinaryCount {
    public int solution(int A, int B) {
        int oneCount =0;

        String binary = Integer.toBinaryString(A*B);
        char[] array = binary.toCharArray();

        for(char c : array) {
            if(c == '1') {
                oneCount ++;
            }
        }

        return oneCount;
    }
}
