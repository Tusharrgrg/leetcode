class Solution {
    public int diagonalPrime(int[][] nums) {
        int maxPrime = 0;
        
        for(int i = 0; i<nums.length; i++){
            int prime1 = nums[i][i];
            int prime2 = nums[i][nums.length-i-1];
            
            if(isPrime(prime1)){
                maxPrime = Math.max(maxPrime, prime1);
            }
            
            if(isPrime(prime2)){
                maxPrime = Math.max(maxPrime, prime2);
            }
            
        }
        
        return maxPrime;
    }
    
     static boolean isPrime(int n){
        // Corner case
        if(n<2)
        {
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
}