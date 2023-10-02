package com.example.models

import com.mongodb.client.MongoDatabase
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import org.litote.kmongo.getCollection
import com.example.routes.*
import database

val collection = database.getCollection<Customer>(collectionName = "Customer")

//data class Customer(val id: String, val firstName: String, val lastName: String, val email: String)

@Serializable
data class Customer(
//    @BsonId
//    @Contextual
//    val _id: ObjectId,
    val firstName: String,
    val lastName: String,
    val email: String
    )

@Serializable
val customerStorage = mutableListOf(collection.find<Customer>())


data class CreateCustomerDto(
    val firstName: String,
    val lastName: String,
    val email: String
)


