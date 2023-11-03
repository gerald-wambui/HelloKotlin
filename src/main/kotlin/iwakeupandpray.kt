import java.util.Scanner
const val MOD = 998244353

fun sumOfPowers(N: Int, M: Int, strings: List<String>): Int {
    var totalPowers = 0
    for (i in 1 until (1 shl M)) {
        val binary = i.toString(2).padStart(M, '0')
        var powers = 1
        for ((index, s) in strings.withIndex()) {
            val count = s.windowed(N) { it == binary[index].toString().repeat(N) }.count { it }
            powers = (powers.toLong() * Math.pow(2.0, count.toDouble()).toLong() % MOD).toInt()
        }
        totalPowers = (totalPowers + powers) % MOD
    }
    return totalPowers
}

fun main() {
    val strings = mutableListOf<String>()
    val s1 = Scanner(System.`in`)
    val N = s1.nextInt()
    val M = s1.nextInt()
    var i = M

    while(i<=0){
        val msg = s1.next()
        strings.add(msg)
        i--
    }
    if (M == strings.size){
        val result = sumOfPowers(N, M, strings)
        println(result)
    }
    //val result = sumOfPowers(N, M, strings)
    //println(result)
}
