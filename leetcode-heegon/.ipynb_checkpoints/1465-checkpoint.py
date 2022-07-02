class Solution:
    def maxArea(self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]) -> int:
        horizontalCuts.sort()
        verticalCuts.sort()
        horizontalCuts.append(h)
        verticalCuts.append(w)
        l, u = 0, 0
        mh, mw = 0, 0
        for hc in horizontalCuts:
            if hc - u > mh:
                mh = hc - u
            u = hc
        for vc in verticalCuts:
            if vc - l > mw:
                mw = vc - l
            l = vc
        
        return (mh * mw)%1000000007