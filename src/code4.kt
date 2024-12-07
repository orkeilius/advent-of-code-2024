import java.io.File

class code4 {
    fun main(){
        val crossword = getCrossword()
        val total = getLine(crossword)


        println(total)
    }

    private fun getCrossword() : Array<CharArray> {
        var list = ArrayList<CharArray>()
        val text = File("input/4.txt").forEachLine {
            list.add(it.toCharArray())
        }
        return list.toTypedArray()
    }

    private fun getLine(crossword : Array<CharArray>): Int{
        var listHorizontal = Array<ArrayList<Char>>(crossword[0].size){i -> ArrayList() }
        var listVertical = Array<ArrayList<Char>>(crossword.size){i -> ArrayList()}
        var listDiagonal = Array<ArrayList<Char>>(crossword[0].size + crossword.size){ i -> ArrayList()}
        var listDiagonalReverse = Array<ArrayList<Char>>(crossword[0].size + crossword.size){ i -> ArrayList()}

        for (x in crossword.indices){
            for (y in crossword[0].indices){
                listHorizontal[x].add(crossword[y][x])
                listVertical[y].add(crossword[y][x])
                listDiagonal[x+y].add(crossword[y][x])

                var index = (x-y-crossword.size-1)
                while (index < 0){
                    index += listDiagonalReverse.size
                }
                listDiagonalReverse[index].add(crossword[x][y])
            }
        }

        var listFull = ArrayList<String>()
        listFull.addAll(listHorizontal.map{elem -> String(elem.toCharArray())})
        listFull.addAll(listVertical.map{elem -> String(elem.toCharArray())})
        listFull.addAll(listDiagonal.map{elem -> String(elem.toCharArray())})
        listFull.addAll(listDiagonalReverse.map{elem -> String(elem.toCharArray())})

        return getMatch(listFull) + getMatch(listFull.map(String::reversed))
    }



    private fun getMatch(lines : List<String>) : Int{
        val regex = Regex("XMAS")
        var total = 0

        lines.forEach {
            total += regex.findAll(it).count()
        }
        return total
    }

}

fun main(){
    val code = code4()
    code.main()
}