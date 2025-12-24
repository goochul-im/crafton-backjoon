class Solution {
    fun solution(s: String): String {
        var answer = ""
        
        return s.split(" ").joinToString(" ") { word ->
            word.lowercase().replaceFirstChar { it.uppercase() }
        }
    }
}