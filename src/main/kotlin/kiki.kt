fun numberToWord(num: Int): String {
    if (num == 0) {
        return "Zero"
    }

    val ones = arrayOf("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine")
    val teens = arrayOf("Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
    val tens = arrayOf("", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")

    fun toWords(n: Int): String {
        return when {
            n == 0 -> ""
            n < 10 -> ones[n]
            n < 20 -> teens[n - 10]
            else -> {
                val ten = n / 10
                val one = n % 10
                return "${tens[ten]}${if (one > 0) " " + ones[one] else ""}"
            }
        }
    }

    val thousands = arrayOf("", "Thousand", "Million", "Billion")

    val words = mutableListOf<String>()
    var i = 0
    var number = num

    while (number > 0) {
        val chunk = number % 1000
        if (chunk != 0) {
            words.add("${toWords(chunk)} ${thousands[i]}")
        }
        number /= 1000
        i++
    }

    return words.asReversed().joinToString(" ").trim()
}

fun main() {
    val number = 127
    val result = numberToWord(number)
    println(result)  // Output: "One Thousand Two Hundred Thirty-Four"
}
