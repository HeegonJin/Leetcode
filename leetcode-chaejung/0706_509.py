'''
509. Fibonacci Number
https://leetcode.com/problems/fibonacci-number/
'''

class Solution:
    def fib(self, n: int) -> int:
        # 메모이제이션을 이용한 동적계획법
        memo = [0, 1, 1]
        if n<=2:
            return memo[n]
        
        for i in range(3, n):
            memo.append(memo[i-2]+memo[i-1])
            
        return memo[n-2]+memo[n-1]

'''
Runtime: 32 ms, faster than 93.39% of Python3 online submissions for Fibonacci Number.
Memory Usage: 13.9 MB, less than 9.43% of Python3 online submissions for Fibonacci Number.
'''