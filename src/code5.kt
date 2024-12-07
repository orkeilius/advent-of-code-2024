import java.io.File

open class code5 {

    var printOrder  :  Array<Array<Int>> = arrayOf()
    var printCommand : Array<Array<Int>> = arrayOf()

    open fun main(){
        getPrintInfo()
        var output = 0
        printCommand.forEach {
            if (isValidCommand(it)){
                val index = (it.size / 2)
                output += it[index]
            }
        }
        println(output)
    }

    fun getPrintInfo(){
        val printOrderList = ArrayList<Array<Int>>()
        val printCommandList = ArrayList<Array<Int>>()
        var isLineAnOrder = true
        File("input/5.txt").forEachLine {
            if (it.trim() == ""){
                isLineAnOrder = false
            }
            else if(isLineAnOrder){
                printOrderList.add(it.trim().split("|").map(String::toInt).toTypedArray() )
            }
            else{
                printCommandList.add(it.trim().split(",").map(String::toInt).toTypedArray() )
            }
        }
        printOrder = printOrderList.toTypedArray()
        printCommand = printCommandList.toTypedArray()
    }

    fun isValidCommand(array: Array<Int>) : Boolean{
        printOrder.forEach {
            if (it[0] in array && it[1] in array){
                val page0Index = array.indexOf(it[0])
                val page1Index = array.indexOf(it[1])
                if (page1Index < page0Index){
                    return false
                }
            }
        }
        return true
    }
}

fun main(){
    val e = code5()
    e.main()

}