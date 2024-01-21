import java.math.*;

class Solution {
    public int solution(int balls, int share) {
        return combination(balls,share).intValue();
    }

    public BigInteger combination(int n, int r){
        if(n-r==1)return BigInteger.valueOf(n);

        BigInteger numer = BigInteger.ONE;
        BigInteger denom = BigInteger.ONE;

        for (int i = 0; i < r; i++) {
            numer = numer.multiply(BigInteger.valueOf(n - i));
        }

        for(int j=1; j<=r; j++){
            denom = denom.multiply(BigInteger.valueOf(j));
        }
        return numer.divide(denom);
    }
}