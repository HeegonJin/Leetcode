'''
102. Binary Tree Level Order Traversal
https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        if root is None:
            return []
        
        treeQ, answer = deque([root]), []
        
        while treeQ:
            treeSize = len(treeQ)
            tempAnswer = []
            while treeSize>0:
                
                curValue = treeQ.popleft()
                tempAnswer.append(curValue.val)
                if curValue.left:
                    treeQ.append(curValue.left)
                if curValue.right:
                    treeQ.append(curValue.right)
                treeSize -= 1
            answer.append(tempAnswer)
        return answer


'''
Runtime: 44 ms, faster than 74.01% of Python3 online submissions for Binary Tree Level Order Traversal.
Memory Usage: 14.2 MB, less than 51.36% of Python3 online submissions for Binary Tree Level Order Traversal.
'''