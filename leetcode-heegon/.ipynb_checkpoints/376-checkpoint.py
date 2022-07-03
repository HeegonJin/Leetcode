class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        dx = 0
        max_count = 1
        count = 1
        for i in range(len(nums)-1):
            if i == 0:
                dx = nums[i+1] - nums[i]
                if dx != 0:
                    count += 1
            elif dx == 0 and (nums[i+1] - nums[i]) != 0:
                dx = nums[i+1] - nums[i]
                count += 1
            elif dx * (nums[i+1] - nums[i]) < 0:  
                dx = nums[i+1] - nums[i]
                count += 1
            if count > max_count:
                max_count = count            
                
        return max_count