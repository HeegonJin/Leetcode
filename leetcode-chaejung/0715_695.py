'''
695. Max Area of Island
https://leetcode.com/problems/max-area-of-island/
'''
class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        
        dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]
        
        m, n = len(grid), len(grid[0])
        
        visited = [[0 for _ in range(n)] for _ in range(m)]
        
        def BFS(start_v):
            area = 0
            queue = [start_v]
            while queue:
                
                x, y = queue.pop(0)
                
                for i in range(4):
                    newdx, newdy = x + dx[i], y + dy[i]
                    if newdx < 0 or newdy < 0 or newdx >= m or newdy >= n: continue
                    if grid[newdx][newdy] == 0: continue
                    if visited[newdx][newdy] != 1:
                        area += 1
                        queue.append((newdx, newdy))
                        visited[newdx][newdy] = 1
            return area
        
        maxArea = 0
        
        for curX in range(m):
            for curY in range(n):
                if grid[curX][curY]==1 and visited[curX][curY] != 1:
                    maxArea = max(1, maxArea, BFS((curX, curY)))
        return maxArea

'''
Runtime: 208 ms, faster than 56.62% of Python3 online submissions for Max Area of Island.
Memory Usage: 14.2 MB, less than 92.54% of Python3 online submissions for Max Area of Island.
'''