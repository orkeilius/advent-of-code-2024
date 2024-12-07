import java.io.File

open class code3 {
    open fun main(){
        val operation = getOperation()
        var total = 0
        operation.forEach {
            total += calcul(it)
        }
        println(total)
    }

    private fun getOperation() : Array<String> {
        val text = File("input/3.txt").readText()
        val regex = Regex("mul\\(\\d{1,3},\\d{1,3}\\)")

        return regex.findAll(text).toList().map(MatchResult::value).toTypedArray()
    }

    fun calcul(string: String) : Int{
        val regex = Regex("\\d{1,3}")
        val value = regex.findAll(string).toList().map(MatchResult::value).map(String::toInt)
        println(value)
        return value[0] * value[1]
    }
}

fun main(){
    val code = code3()
    code.main()
}