import java.io.File
import java.io.InputStream
import kotlin.math.absoluteValue


fun main(){
    val e = code2()
    e.main()
}


class code2 {

    fun main(){
        val list = getList()
        var total = 0
        for (i in list){
            if(isValid(i)){
                total++
            }
        }
        println(total)
    }


    private fun getList(): Array<Array<Int>> {
        val inputStream: InputStream = File("input/2.txt").inputStream()
        val list = mutableListOf<Array<Int>>()

        inputStream.bufferedReader().forEachLine {
            val elem = it.split(" ")
            list.add(elem.map(String::toInt).toTypedArray())
        }
        return list.toTypedArray()

    }

    private fun isValid(list: Array<Int>): Boolean {
        var direction = 1
        if (list[0] - list[1] < 0) {
            direction = -1
        }
        val possibleValue = (1..3).toList().map { it * direction }

        for (i in 0..list.size - 2) {
            val distance = list[i] - list[i+1]
            if (distance !in possibleValue) {
                return false
            }
        }
        return true
    }
}