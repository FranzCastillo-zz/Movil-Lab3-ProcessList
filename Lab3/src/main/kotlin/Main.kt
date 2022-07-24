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
    if(inputList != null){ //IF THE PARAMETER ISN'T NULL
        var returnList: MutableList<ItemData> = mutableListOf<ItemData>() // LIST TO RETURN
        var i: Int = 0 // TO STORE THE originalPos

        inputList.forEach{
            if(it != null){
                when (it) {
                    is String 	-> returnList.add(isString(it, i))
                    is Int 		-> returnList.add(isInt(it, i))
                    is Boolean 	-> returnList.add(isBool(it, i))
                    else 		-> returnList.add(isOther(it, i))
                }
            }
            i++
        }

        return returnList
    }else{
        return null
    }
}

fun isString(item: String, pos: Int): ItemData{
    return ItemData(
        originalPos = pos,
        originalValue = item,
        type = "cadena",
        info = "l" + item.length
    )
}

fun isInt(item: Int, pos: Int): ItemData{
    var infoMod: String? = null

    if(item % 10 == 0){
        infoMod = "M10"
    }else if(item % 5 == 0){
        infoMod = "M5"
    }else if(item % 2 == 0){
        infoMod = "M2"
    }

    return ItemData(
        originalPos = pos,
        originalValue = item,
        type = "entero",
        info = infoMod
    )
}

fun isBool(item: Boolean, pos: Int): ItemData{
    var infoValue: String
    if(item){
        infoValue = "Verdadero"
    }else{
        infoValue = "Falso"
    }

    return ItemData(
        originalPos = pos,
        originalValue = item,
        type = "booleano",
        info = infoValue
    )
}

fun isOther(item: Any, pos: Int): ItemData{
    return ItemData(
        originalPos = pos,
        originalValue = item,
        type = null,
        info = null
    )
}