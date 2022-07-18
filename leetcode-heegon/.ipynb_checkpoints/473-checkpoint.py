class Solution(object):
    def makesquare(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        nums.sort(reverse=True)
        if len(nums) < 4:
            return False
        total = sum(nums)
        if total % 4 != 0:
            return False
        target = total / 4
        if any(n > target for n in nums):
            return False
        return self.dfs([target] * 4, 0, nums)

    def dfs(self, lefts, idx, nums):
        if idx == len(nums):
            return True
        n = nums[idx]
        used = set()
        for i, left in enumerate(lefts):
            if left >= n and left not in used:
                lefts[i] -= n
                if self.dfs(lefts, idx + 1, nums):
                    return True
                lefts[i] += n
                used.add(left)
        return False