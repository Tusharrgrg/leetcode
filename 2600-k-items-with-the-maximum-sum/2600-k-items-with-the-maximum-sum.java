class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int total = numZeros+numOnes;
        if(total>=k){
            return Math.min(numOnes,k);
        }else{
            int rem = k-total;
            if(rem<=numNegOnes){
                return numOnes-rem;
            }
        }
        return 0;
    }
}