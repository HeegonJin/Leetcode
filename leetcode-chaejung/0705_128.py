'''
128. Longest Consecutive Sequence
https://leetcode.com/problems/longest-consecutive-sequence/
'''

'테스트 코드에서 지속적으로 오류 발생 -> 조건부 처리를 잘 못함'

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # 중복 제거 및 순차 정렬
        preprocessed = sorted(list(set(nums)))
        
        if len(preprocessed) == 0:
            return 0
        
        prevNum = min(preprocessed)
        maxLen = 1
        tempLen = 1
        
        # 1일 증가하는 수열을 하나씩 만들고 최장 길이를 maxLen에 담기
        for i in preprocessed[1:]:
            if prevNum + 1 == i:
                tempLen += 1
            else:
                if tempLen > maxLen:
                    maxLen = tempLen
                tempLen = 1
            prevNum = i
        if tempLen > maxLen:
            maxLen = tempLen
        return maxLen

'''
Runtime: 512 ms, faster than 66.73% of Python3 online submissions for Longest Consecutive Sequence.
Memory Usage: 29.1 MB, less than 18.82% of Python3 online submissions for Longest Consecutive Sequence.
'''