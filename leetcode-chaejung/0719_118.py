'''
118. Pascal's Triangle
https://leetcode.com/problems/pascals-triangle/
'''

class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        firstRow = [1]
        secondRow = [1, 1]
        answer = [firstRow, secondRow]
        
        if numRows<=2:
            return answer[:numRows]
        
        for i in range(2, numRows):
            tempCurrentRow = []
            tempPreviousRow = [0]+answer[i-1]+[0]
            for nums in range(len(tempPreviousRow)-1):
                tempCurrentRow.append(tempPreviousRow[nums]+tempPreviousRow[nums+1])
            answer.append(tempCurrentRow)

        return answer[:numRows]

'''
Runtime: 65 ms, faster than 10.08% of Python3 online submissions for Pascal's Triangle.
Memory Usage: 13.9 MB, less than 66.48% of Python3 online submissions for Pascal's Triangle.
'''