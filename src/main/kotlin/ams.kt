fun main() {
    val num = 1956712036
    val result = numberToWords(num)
    println(result)
}
fun numberToWords(num: Int): String {
    if (num == 0) {
        return "Zero"
    }

    val ones = listOf("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine")
    val teens = listOf("", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
    val tens = listOf("", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
    val thousands = listOf("", "Thousand", "Million", "Billion")

    fun convert(group: Int) :String{
        if (group == 0) {
            return ""
        } else if (group < 10) {
            return ones[group]
        } else if (group < 20) {
            return teens[group - 10]
        } else if (group  < 100){
            val y = group/10
            if (group%10 != 0){
                val z = group%10
                return "${tens[y]} ${ones[z]}"
            }else{
                return "${tens[y]}"
            }
        } else if (group < 1000){
            val r = group/100
            if (group%100 != 0){
                val s = group%100
                val t = s/10
                val u = s%10
                return "${ones[r]} Hundred ${tens[t]} ${ones[u]}"
            } else{
                return "${ones[r]} Hundred"
            }
        }else{
            return ""
        }
    }

val words = mutableListOf<String>()
var i = 0

var number = num

while (number > 0) {

    val group = number % 1000
    if (group != 0) {
        words.add("${convert(group)} ${thousands[i]}")
    }
    number /= 1000
    i++
}

return words.reversed().joinToString(" ")
}