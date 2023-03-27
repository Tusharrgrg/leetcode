class Solution {
    public boolean primeSubOperation(int[] nums) {
        
       for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                continue;
            }
            if(nums[i+1]==1) return false;
            if((nums[i]==2 || nums[i]==1)) return false;
            int p = pickPrime(nums[i]-1);
            int temp = p;
            while(nums[i]-p<nums[i+1]){
                temp=p;
                p = pickPrime(p-1);
            }
            nums[i]-=temp;
        }

        //check whether the array is sorted or not
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                continue;
            }
            return false;
        }
        return true;
        
    }


    //picking the smallest prime.
    public int pickPrime(int n){
        while(n>1){
            if(isPrime(n)) return n;
            n--;
        }
        return 0;
    }

    //verifying whether it is a prime or not.
    public boolean isPrime(int n){
        if(n<=1) return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
    }
}