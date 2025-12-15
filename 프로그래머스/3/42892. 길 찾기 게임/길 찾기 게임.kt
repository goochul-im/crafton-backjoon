class Solution {
    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        
        data class Node(var idx:Int ,val num:Int,val x:Int,val y:Int, var left:Node?, var right:Node?, var parent:Node?)
        val list = mutableListOf<Node>()
        
        for (i in 0 until nodeinfo.size) {
            val (x,y) = nodeinfo[i]
            list.add(Node(i, i + 1, x, y, null, null, null))
        }
        list.sortWith ( compareByDescending<Node> {it.y}.thenBy {it.x} )
        for (i in 0 until nodeinfo.size) {
            list[i].idx = i
        }
        
        // for (node in list) {
        //     println("idx: ${node.idx}, num : ${node.num} ,x : ${node.x} ,y :${node.y}")
        // }
        
        fun getNextNodeIdx(curIdx:Int) : Int {
            var find = curIdx
            while (find < list.size && list[find].y == list[curIdx].y) find++
            println("find : $find")
            return find
        }
        
        fun getMyParentTreeX(cur: Node, isLeft: Boolean) : Int {
            if (cur.parent == null) return if (isLeft) -1 else Int.MAX_VALUE
            val parent = cur.parent!!
            if (isLeft && parent.right == cur) return parent.x
            if (!isLeft && parent.left == cur) return parent.x
            return getMyParentTreeX(parent, isLeft)
        }
        
        fun dfs(cur: Node) {
            
            // println("===idx: ${cur.idx} num: ${cur.num}, x:${cur.x}, y:${cur.y}, parent:${cur.parent?.num ?: -1}===")
            val start = getNextNodeIdx(cur.idx)
            val end = getNextNodeIdx(start)
            for (i in start until end) {
                val node = list[i]
                if (cur.parent == null) {
                    if (node.x < cur.x) cur.left = node
                    if (node.x > cur.x) cur.right = node
                    node.parent = cur
                    dfs(node)
                }
                else if (node.x < cur.x && node.x > getMyParentTreeX(cur, true)) {
                    cur.left = node
                    node.parent = cur
                    dfs(node)
                }
                else if (node.x > cur.x && node.x < getMyParentTreeX(cur, false)) {
                    cur.right = node
                    node.parent = cur
                    dfs(node)
                }
                
            }
            
        }
        
        dfs(list[0])
        
        val post = mutableListOf<Int>()
        fun postOrder(cur: Node?){
            if (cur == null) return
            postOrder(cur.left)
            postOrder(cur.right)
            post.add(cur.num)
        }
        
        val pre = mutableListOf<Int>()
        fun preOrder(cur: Node?) {
            if (cur == null) return
            pre.add(cur.num)
            preOrder(cur.left)
            preOrder(cur.right)
        }
        
        postOrder(list[0])
        preOrder(list[0])
        
        var answer = arrayOf<IntArray>(pre.toIntArray(), post.toIntArray())
        
        return answer
    }
}