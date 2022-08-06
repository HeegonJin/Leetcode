package leetcode.d220804.q858

class Solution {
    fun mirrorReflection(p: Int, q: Int): Int {
        var count  = 1
        var floor  = 1

        while ((p * floor != q * count)){
            if (q * count <  p * floor){
              count++
            } else{
                floor++
            }
        }

        return if (count % 2 == 1 && floor % 2 == 0){
            0
        } else if (count % 2 == 0 && floor % 2 == 1){
            2
        } else{
            1
        }

    }
}

fun main() {
    var sol = Solution()
    println(sol.mirrorReflection(3,2))
}