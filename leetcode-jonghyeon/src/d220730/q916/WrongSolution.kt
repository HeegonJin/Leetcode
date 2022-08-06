package leetcode.d220730.q916

class WrongSolution {
    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val result = mutableListOf<String>()
        val map = HashMap<String, Int>()
        for (u in words2) {
            map[u] = map.getOrDefault(u, 0) + 1
        }

        for (u in words1) {
            var temp = HashMap<String, Int>(map)

            for (k in map.keys) {
                if (temp.size == 0) {
                    result.add(u)
                    break
                }
                if (u.contains(k)) temp.remove(k)
            }
            if (temp.size == 0) {
                result.add(u)
            }
        }
        return result
    }
}