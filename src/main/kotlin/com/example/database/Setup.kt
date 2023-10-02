import com.mongodb.*

import com.mongodb.kotlin.client.MongoClient
import com.mongodb.kotlin.client.MongoDatabase
import org.bson.BsonInt64
import org.bson.Document

// Replace the placeholder with your MongoDB deployment's connection string
val uri = "mongodb://localhost:27017"

// Set the Stable API version on the client
val serverApi = ServerApi.builder()
    .version(ServerApiVersion.V1)
    .build()
val settings = MongoClientSettings.builder()
    .applyConnectionString(ConnectionString(uri))
    .serverApi(serverApi)
    .build()

// Create a new client and connect to the server
val mongoClient = MongoClient.create(settings)
val database = mongoClient.getDatabase("test")


//ping test to db
/*fun main() {
    try {
        // Send a ping to confirm a successful connection
        val command = Document("ping", BsonInt64(1))
        database.runCommand(command)
        println("Pinged your deployment. You successfully connected to MongoDB!")
        database
    } catch (me: MongoException) {
        System.err.println(me)
        null
    }
    suspend fun listAllCollection(database: MongoDatabase) {
        print("Collection in this database are -----------> ")
        println(database.listCollectionNames())
    }
    listAllCollection(database)
}
*/