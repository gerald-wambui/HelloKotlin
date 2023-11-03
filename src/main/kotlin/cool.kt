import java.util.Scanner
val MD = 998244353

fun binomialCoefficient(n: Int, k: Int): Int {
    var result = 1
    for (i in 0 until k) {
        result = (result * (n - i)) / (i + 1)
    }
    return result
}
fun sequence(k: Int, n: Int): Array<Int> {
    val size = Math.pow(2.0, k.toDouble()).toInt() // Calculate the size of the array
    val a = Array(size) { 0 }
    a[0] = 1

    for (t in 1 until size) {
        a[t] = (0 until size).filter { i -> i % size == t % n }
            .sumOf { binomialCoefficient(it, n) } % MD
    }
    return a
}



fun main() {
    val s1 = Scanner(System.`in`)
    val k = s1.nextInt()
    val n = s1.nextInt()
    val result = sequence(k, n)
    println(result)
}
