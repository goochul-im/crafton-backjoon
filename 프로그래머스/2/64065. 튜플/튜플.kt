class Solution {
    fun solution(s: String): IntArray {
        var answer = intArrayOf()
        
        val list = s.replace('{',' ')
                    .replace("}}","")
                    .split("},")
                    .map { it.trim() }
                    
        val S = mutableSetOf<Int>()
        val newList = list.map { it.split(",") }
            .sortedBy { it.size }
        
        for (s in newList) {
            val intList = s.map { it.toInt() }
            S.addAll(intList)
        }
        
        return S.toIntArray()
    }
}