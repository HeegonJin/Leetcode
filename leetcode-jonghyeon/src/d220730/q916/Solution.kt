package leetcode.d220730.q916

class Solution {
    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val result = mutableListOf<String>()
        var map = HashMap<String, Int>();
        for (u in words2){
            var temp = HashMap<String, Int>()
            val sp = u.split("").subList(1, u.length + 1)
            for (v in sp){
                temp[v] = temp.getOrDefault(v,0) + 1
            }
            temp.forEach { (key, value) -> if (key in map.keys && map[key]!! > value){
                temp[key] = map[key]!!
            } }
            map.putAll(temp)
        }

        for (u in words1) {
            var temp = HashMap<String, Int>(map)

            var split = u.split("")
            for (v in split){
                if (temp.size == 0) {
                    result.add(u)
                    break
                }
                if (v !in temp.keys) continue
                temp[v] = temp[v]!! - 1

                if (temp[v] == 0) temp.remove(v)
            }
        }
        return result

    }
}

fun main() {

    val words1 = arrayOf("amazon", "apple", "facebook", "google", "leetcode")
    val words2 = arrayOf("e", "oo")
    val sol = Solution();
    println(sol.wordSubsets(words1, words2).toString())

//    val hashMap1 = HashMap<String, Int>()
//    hashMap1["a"]=1
//    hashMap1["b"]=2
//    hashMap1["c"]=1
//    val hashMap2 = HashMap<String, Int>()
//    hashMap2["a"]=2
//    hashMap2["b"]=1
//    hashMap2["c"]=1
//
//    hashMap2.forEach { (key, value) -> if (key in hashMap1.keys && hashMap1[key]!! > value){
//        hashMap2[key] = hashMap1[key]!!
//    } }
//    println(hashMap2.toString())
//    var a = "asdasd"
//    val split = a.split("").subList(1,a.length+1)
//    print(split.toString())
}