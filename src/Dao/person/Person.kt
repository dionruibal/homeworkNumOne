package org.csuf.cspc411.Dao.claim

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

data class Claim (var id:String?,var title:String?, var date:String?, var isSolved:Int)
data class Partof (var title:String?, var date:String?)

fun main() {
    // JSON Serialization
    /*var pObj = Person(id1, )
    var jsonStr = Gson().toJson(pObj)
    println("The converted JSON string : ${jsonStr}")

    // Serialization of List<Person>
    var pList : MutableList<Person> = mutableListOf()
    pList.add(pObj)
    pList.add(Person("Amie", "Lam", "647383829"))
    val listJsonString = Gson().toJson(pList)
    //JSONArray object
    println("${listJsonString}")

    // List<Person> object deserialization
    val personListType : Type = object : TypeToken<Person>(){}.type

    // JSON Deserialization
    var pObj1 : Person
    jsonStr = "{\"lastName\":\"Lam\", \"ssn\":\"647483839\"}"
    pObj1 = Gson().fromJson(jsonStr, Person::class.java)
    println("${pObj1.toString()}")
*/
}