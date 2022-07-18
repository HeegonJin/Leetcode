# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        def collect(this, depth):
            if this:
                if depth == len(view):
                    view.append(this.val)
                collect(this.right, depth + 1)
                collect(this.left, depth + 1)
        view = []
        this = root
        depth = 0
        collect(this, depth)
        return view