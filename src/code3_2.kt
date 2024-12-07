import java.io.File

class code3_2 : code3() {
    override fun main(){
        val operation = getOperation()
        var total = 0
        operation.forEach {
            total += calcul(it)
        }
        println(total)
    }

    private fun getOperation() : Array<String> {
        val text = File("input/3*.txt").readText()
        val regex = Regex("(mul\\(\\d{1,3},\\d{1,3}\\)|((do|don't)\\(\\)))")

        val match =  regex.findAll(text).toList().map(MatchResult::value).toTypedArray()
        var isEnable = true
        var operation = ArrayList<String>()
        match.forEach {
            if (it == "do()"){
                isEnable = true
            }
            else if (it == "don't()"){
                isEnable = false
            }
            else if (isEnable) {
                operation.add(it)
            }
        }
        return operation.toTypedArray()
    }
}

fun main(){
    val code = code3_2()
    code.main()
}