class Solution {
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        var answer = 0
        val answerList = mutableListOf<MutableList<String>>()
        
        banned_id.forEach { banned ->
            val bannedList = mutableListOf<String>()
            user_id.forEach { user -> 
                
                if ( banned.length != user.length ) return@forEach
                
                for (i in 0 until user.length) {
                    if (banned[i] == '*') continue
                    else if (user[i] != banned[i]) return@forEach
                    
                }
                
                bannedList.add(user)
            }
            
            answerList.add(bannedList)
        }
        
        val resultSet = mutableSetOf<Set<String>>()
        
        fun dfs(idx:Int, curSet:MutableSet<String>) {
            if (idx == banned_id.size) {
                resultSet.add(curSet.toSet())
                return
            }
            
            for (user in answerList[idx]) {
                if (!curSet.contains(user)) {
                    curSet.add(user)
                    dfs(idx + 1, curSet)
                    curSet.remove(user)
                }
            }
            
        } 
        
        dfs(0, mutableSetOf())
        
        return resultSet.size
    }
}