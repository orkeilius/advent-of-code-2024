import java.io.File
import java.io.InputStream
import kotlin.math.absoluteValue


fun main(){
    val list = getList()
    val totalDistance = calculDistance(list)
    println(totalDistance)
}

fun getList() : Array<Array<Int>> {
    val inputStream: InputStream = File("input/1.txt").inputStream()
    val leftList = mutableListOf<Int>()
    val rightList = mutableListOf<Int>()

    inputStream.bufferedReader().forEachLine{
        val elem = it.split (" ")
        leftList.add(elem[0].toInt())
        rightList.add(elem[3].toInt())
    }
    leftList.sort()
    rightList.sort()
    return arrayOf(
        leftList.toTypedArray(),
        rightList.toTypedArray()
    )
}

fun calculDistance(list : Array<Array<Int>> ) : Int{
    var totalDistance = 0
    for (i in 0..list[0].size - 1){
        val distance = list[0][i] - list[1][i]
        totalDistance += distance.absoluteValue
    }
    return totalDistance
}
