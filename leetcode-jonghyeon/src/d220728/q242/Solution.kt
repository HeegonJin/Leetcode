package leetcode.d220728.q242

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val sArray = s.toCharArray()
        val tArray = t.toCharArray()

        sArray.sort()
        tArray.sort()

        for (i: Int in 0..sArray.size - 1) {
            if (sArray[i] != tArray[i]) return false
        }
        return true
    }
}

fun main() {
    var sol = Solution()
    println(sol.isAnagram(s = "anagram", t = "nagaram"))
}