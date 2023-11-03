fun main() {
    val num = 123
    val result = notesAndShillings(num)
    println(result)
}
fun notesAndShillings(num: Int) :String{
    if (num == 0){
        return "Zero"
    }
    val ones = listOf("","one","two","three","four","five","six","seven","eight","nine")
    val teens = listOf("", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
    val tens = listOf("","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety")
    val thousands = listOf("", "Thousand", "Million", "Billion")

    fun convert(group: Int) :String{
        if (group<1000 && group>=100){
            val w = group/100
            if (group%100 != 0 && group%100 >= 50){
                val x = group%100
                val t = x -50
                val y = t%10
                val z = t/10
                return "${ones[w]} 1 Hundred Shillings note 1 Fifty Shillings note${tens[z]} ${ones[y]} 1 Shilling coin"
            }
            else if (group%100 != 0){
                val x = group%100
                val y = x%10
                val z = x/10
                return "${ones[w]} 1 Hundred note ${tens[z]} ${ones[y]} 1 Shilling coin"
            }
            else{
                return "${ones[w]} 1 Hundred Shillings note"
            }
        }
         else if (group < 100 && group >= 50){
            val i = group - 50
            val j = i/10
            val k = i%10
            return "1 Fifty Shilling note ${tens[j]} ${ones[k]} 1 Shilling coin"
        }
        else if (group < 50){
            return when(group < 50){
                (group < 10) -> {
                    "${ones[group]} 1 Shilling coin"
                }
                (group < 20) -> {
                    "${teens[group-10]} 1 Shilling coin"
                }
                else -> {
                    "${tens[group/10]} ${ones[group%10]} 1 Shilling coin"
                }
            }

        }
        else{
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