'''
Min Cost Climbing Stairs
https://leetcode.com/problems/min-cost-climbing-stairs/
'''

class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        #동적 계획법 활용
        #T(N)= min(T(N-2)+cost[N-2]], T(N-1)+cost[N-1])
        #T(2)= min(cost[0], cost[1])
        #T(3)= min(cost[0]+cost[2], cost[1])
        #T(4)= min(T(2)+cost[-1], T(3))
        
        stairNum = len(cost)
        
        minCostList = [0, 0]
        if stairNum == 2:
            return min(cost[0], cost[1])
        elif stairNum == 3:
            return min(cost[0]+cost[2], cost[1])
        
        minCostList = [0, 0, min(cost[0], cost[1]), min(cost[0]+cost[2], cost[1])]
        
        for i in range(4, stairNum+1):
            minCostList.append(min(minCostList[i-2]+cost[i-2], minCostList[i-1]+cost[i-1]))

        return minCostList[stairNum]
            
'''
Runtime: 97 ms, faster than 42.23% of Python3 online submissions for Min Cost Climbing Stairs.
Memory Usage: 14 MB, less than 75.92% of Python3 online submissions for Min Cost Climbing Stairs.
'''   