package org.csuf.cspc411

import com.google.gson.Gson
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.utils.io.*
import org.csuf.cspc411.Dao.Database
import org.csuf.cspc411.Dao.claim.Partof
import org.csuf.cspc411.Dao.claim.Claim
import org.csuf.cspc411.Dao.claim.ClaimDao
import java.io.BufferedOutputStream
import java.io.Reader
import java.util.*

fun main(args: Array<String>): Unit {
    // Register PersonStore callback functions

    io.ktor.server.netty.EngineMain.main(args)
}

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    // extension
    // @annotation
    // routing constructor takes only one parameter which is a lambda function
    // DSL - Domain Specific Language
    routing{
        this.get("/get"){
            println("HTTP message is using GET method with /get ")

        }

        get("/ClaimService/getAll"){
            val pList = ClaimDao().getAll()
            val respJsonStr = Gson().toJson(pList)
            call.respondText(respJsonStr, status= HttpStatusCode.OK, contentType= ContentType.Application.Json)
        }

        post("/ClaimService/add"){
            val contType = call.request.contentType()
            val data = call.request.receiveChannel()
            val dataLength = data.availableForRead
            var output = ByteArray(dataLength)
            data.readAvailable(output)
            val str = String(output)
            val lObj : Partof
            lObj = Gson().fromJson(str, Partof::class.java)

            val databaseObj = ClaimDao().addPart(lObj)

            println("HTTP message is using POST method with /post ${contType} ${str}")
            call.respondText("${lObj.title}",
                    status= HttpStatusCode.OK, contentType = ContentType.Text.Plain)
        }

    }

}

