class Solution:
    def minMoves2(self, nums: list[int]) -> int:
        nums.sort()
        n=len(nums)
        tar=nums[n//2]
        op=0
        for i in range(len(nums)):
            op+=abs(nums[i]-tar)
        return op