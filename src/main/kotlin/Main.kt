import com.apollographql.apollo.ApolloClient
import com.yt8492.apolloplayground.ExampleQuery
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
  val apollo = ApolloClient.Builder().build()
  apollo.query(ExampleQuery())
    .execute()
    .dataOrThrow()
    .foo
    .bar
    ?.id // bar is semanticNonNullField but this bar is nullable
}
