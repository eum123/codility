package prefix;

public class PassingCars {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int toEast = 0;

        long pairCount = 0;

        for(int i = 0 ; i < A.length ; i++){
            if(A[i] == 0){
                toEast++;
            } else{
                pairCount += toEast;
            }
        }

        if(pairCount > 1000000000){
            return -1;
        }

        return (int)pairCount;
    }
}
