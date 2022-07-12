import storage.Storage
import zio.test.Assertion.*
import zio.test.*
import zio.*

object StorageSuites extends ZIOSpecDefault {
  def spec: Spec[TestEnvironment with Scope, Throwable] =
    suite("in memory storage") {
      test("saving") {
        assertZIO {
          for {
            storage <- ZIO.service[Storage[String, String]]
            _       <- storage.save("key", "value")
            result  <- storage.get("key")
          } yield result
        }(isSome(equalTo("value")))
      }
    }.provide(Storage.inMemoryLayer[String, String])
}
