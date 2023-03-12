class Solution:
    def maxScore(self, nums: List[int]) -> int:
        count = 0
        nums.sort()
        prefix = nums[len(nums)-1]
        if prefix > 0:
            count+=1
        
        i = len(nums)-2
        while i>=0:
            prefix += nums[i]
            if prefix>0:
                count+=1
            i-=1    
        return count    
        