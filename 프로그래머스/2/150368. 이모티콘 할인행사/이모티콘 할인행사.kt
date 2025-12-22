class Solution {
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        val discounts = intArrayOf(10,20,30,40)
        var plus = 0
        var cost = 0
        
        fun getDiscountCost(rate:Int, cost:Int) : Int {
            return cost * (100 - rate) / 100
        }
        
        fun process(curDiscounsts: IntArray) : Pair<Int, Int> {
            var plusUser = 0
            var buyCost = 0
            for ((minRate, minCost) in users) {
                var curSum = 0
                for (i in 0 until emoticons.size) {
                    val rate = curDiscounsts[i]
                    if (minRate > rate) continue
                    curSum += getDiscountCost(rate, emoticons[i])
                }
                
                if (curSum >= minCost) {
                    plusUser ++
                } else {
                    buyCost += curSum
                }
            }
            
            return Pair(plusUser, buyCost)
        }
        
        fun dfs(depth: Int, curDiscounts: IntArray) {
            if (depth == emoticons.size) {
                val (plusUser, buyCost) = process(curDiscounts)
                if (plusUser > plus) {
                    plus = plusUser
                    cost = buyCost
                } else if (plusUser == plus) {
                    cost = Math.max(cost, buyCost)
                }
                return
            }
            
            for (rate in discounts) {
                curDiscounts[depth] = rate
                dfs(depth + 1, curDiscounts)
            }
            
        }
        
        dfs(0, IntArray(emoticons.size) {0})
        
        return intArrayOf(plus,cost)
    }
    
}