// CUSTOM CLASS TO STORE ITEMS
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)
// -----------------------

// MAIN FUNCTION; RUNS THE processList METHOD
fun main() {
    val result = processList(listOf(20, 25, 2, 7, "hola", "", true, false, null, 2.0))
    println(result)
}

// CHECKS EVERY ITEM IN THE inputList PARAMETER AND RETURNS A LIST WITH INFORMATION OF
// EACH OBJECT
fun processList(inputList: List<Any?>?): List<ItemData>? {
    if (inputList == null) { return null }
    val returnList: MutableList<ItemData> = mutableListOf<ItemData>() // LIST TO RETURN
    var i = 0 // TO STORE THE originalPos
    inputList.forEach {
        if (it != null) returnList.add(
            when (it) {
                is String -> ItemData(i, it, "cadena", "l" + it.length)
                is Int -> ItemData(i, it, "entero", if (it % 10 == 0) "M10" else if (it % 5 == 0) "M5" else if (it % 2 == 0) "M2" else null)
                is Boolean -> ItemData(i, it, "booleano", if (it) "Verdadero" else "Falso")
                else -> ItemData(i, it, null, null)
            }
        )
        i++
    }
    return returnList
}