'''
473. Matchsticks to Square
https://leetcode.com/problems/matchsticks-to-square/
'''

class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        size, one_side = len(matchsticks), sum(matchsticks)/4
        matchsticks.sort(reverse=True)

        # 트래킹 돌리기 전에 파악할 수 있는 조건
        # 1. 개수 합이 4로 나눠떨어지지 않을 때
        # 2. 가장 큰 성냥개비가 한 변의 길이를 넘을 때
        if one_side != int(one_side) or matchsticks[0] > one_side:
            return False
        
        # index: 성냥개비 리스트의 인덱스
        # space: 한 변에다가 한 개씩 갖다 넣으면서 남은 길이
        # confirmed: 몇 개의 변이 만들어지기로 확정됐는지
        def tracking(index, space, confirmed):
            if confirmed == 3:
                return True
            while index < size:
                cur_match = matchsticks[index]

                # 현재 성냥개비가 남은 길이보다 클 때 다음 인덱스의 것으로 넘기기
                # 
                if cur_match > space:
                    index += 1
                    continue

                # 이걸로 만들 것으로 확정됐으면, 해당 성냥개비 아웃시키기
                matchsticks[index] = one_side + 1

                # 한 변 만들 때 현재 성냥개비가 딱 맞을 때
                if cur_match == space:
                    result = tracking(1, one_side, confirmed + 1)
                else:
                    result = tracking(index+1, space-cur_match, confirmed)
                
                if result:
                    return True

                # 끝까지 검사해도 맞는 성냥개비가 없으면 되돌려놓기
                matchsticks[index] = cur_match

                # 검사하는 성냥개비가 같은 것은 뛰어넘기
                while index < size and matchsticks[index] == cur_match:
                    index += 1
            return False
        return tracking(0, one_side, 0)

'''
Runtime: 86 ms, faster than 97.42% of Python3 online submissions for Matchsticks to Square.
Memory Usage: 14 MB, less than 57.39% of Python3 online submissions for Matchsticks to Square.

'''