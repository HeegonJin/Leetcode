from collections import deque

class Solution:
    def levelOrder(self, root):
        queue = deque([(0, root)])
        d = {}

        while queue:
            row, node = queue.popleft()
            if node:
                d[row] = d.get(row, []) + [node.val]
                queue += (row+1, node.left), (row+1, node.right)

        return [d[row] for row in sorted(d.keys())]
                