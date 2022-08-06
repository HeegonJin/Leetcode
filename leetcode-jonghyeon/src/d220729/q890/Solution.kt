package leetcode.d220729.q890

class Solution {
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
        val convertedPattern = convert(pattern)
        return words.filter { s -> convert(s) == convertedPattern }
    }

    fun convert(s: String) : String {
        var result = ""
        val split = s.toCharArray()
        val distinct = split.distinct()
        val map = HashMap<Char, Int>()
        for (i : Int in distinct.indices){
            map[distinct[i]] = i
        }
        for (i : Int in split.indices){
            result += map[split[i]]
        }

        return result
    }
}

fun main() {
    val words = arrayOf("abc", "deq", "mee", "aqq", "dkd", "ccc")
    val pattern = "abb"
    val sol = Solution()
    println(sol.findAndReplacePattern(words, pattern).toString())
}