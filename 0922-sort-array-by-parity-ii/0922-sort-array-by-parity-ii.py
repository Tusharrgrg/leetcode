class Solution:
    def sortArrayByParityII(self, nums: List[int]) -> List[int]:
        i = 0
        j = 1
        ans = []
        for num in nums:
            if num%2 == 0:
                ans.insert(i,num)
                i+=2
            else :
                ans.insert(j,num)
                j+=2
        return ans
    
   