import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

//  몬스터를 처치하자!

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    data class Skill(val coolTime:Int, val damage: Int)

    var answer = Int.MAX_VALUE
    val (N, HP) = br.readLine().split(" ").map { it.toInt() }
    val skillList = Array(N) { Skill(0,0) }
    val timeList = Array(N) {0}

    for (i in 0..<N) {
        val (cooltime, damage) = br.readLine().split(" ").map { it.toInt() }
        skillList[i] = Skill(cooltime, damage)
        timeList[i] = 0
    }

    fun dfs(hp: Int, time: Int, currentCooldowns: Array<Int>) {
        // 이미 더 긴 시간을 사용했다면 탐색 중단 (가지치기)
        if (time >= answer) {
            return
        }

        if (hp <= 0) {
            answer = min(answer, time)
            return
        }

        val nextCooldowns = currentCooldowns.map { max(0, it - 1) }.toTypedArray()
        val nextTime = time + 1

        var isAnySkillUsed = false
        for (i in 0..<N) {
            if (nextCooldowns[i] == 0) {
                isAnySkillUsed = true
                val skill = skillList[i]

                // 이 스킬을 "사용하기로 결정"한 경우의 새로운 상태를 만듦
                val cooldownsForThisBranch = nextCooldowns.copyOf()
                cooldownsForThisBranch[i] = skill.coolTime

                dfs(hp - skill.damage, nextTime, cooldownsForThisBranch)
            }
        }

        if (!isAnySkillUsed) {
            dfs(hp, nextTime, nextCooldowns)
        }
    }

    dfs(HP, 0, timeList)

    print(answer)
}
