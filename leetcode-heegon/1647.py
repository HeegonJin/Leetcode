from collections import defaultdict

class Solution:
    def minDeletions(self, s: str) -> int:
        d = defaultdict(int)
        check = defaultdict(bool)
        for i in s:
            d[i] += 1
        d = dict(sorted(d.items(), key=lambda item:item[1]))
        ans = 0
        for k, v in d.items():
            tmp = v
            while True:
                if check[tmp] is False:
                    check[tmp] = True
                    break
                else:
                    tmp -= 1
                    ans += 1
                if tmp == 0:
                    break
        return ans