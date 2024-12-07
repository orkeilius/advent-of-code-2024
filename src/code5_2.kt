class code5_2 : code5() {

    override fun main(){
        getPrintInfo()
        var output = 0
        printCommand.forEach {
            if (!isValidCommand(it)){
                val ordered = reOrder(it)
                val index = (ordered.size / 2)
                output += ordered[index]
            }
        }
        println(output)
    }

    fun reOrder(array: Array<Int>) : Array<Int>{
        val comparator = Comparator { int1: Int, int2: Int -> customComparateur(int1,int2)}
        return array.sortedWith(comparator).toTypedArray()
    }

    fun customComparateur(int1 : Int,int2:Int) : Int{
        printOrder.forEach {
            if (int1 in it  && int2 in it){
                return if (it[0] == int1) {
                    1
                } else{
                    -1
                }
            }
        }
        return 0
    }
}

fun main(){
    val e = code5_2()
    e.main()

}