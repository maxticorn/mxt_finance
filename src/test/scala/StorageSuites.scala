import storage.Storage
import zio.test.Assertion._
import zio.test._
import zio.test.environment._

object StorageSuites extends DefaultRunnableSpec {
  def spec: Spec[TestEnvironment, TestFailure[Throwable], TestSuccess] =
    suite("in memory storage") {
      testM("saving") {
        assertM {
          for {
            storage <- Storage.mkInMemory[String, String]
            _       <- storage.save("key", "value")
            result  <- storage.get("key")
          } yield result
        }(isSome(equalTo("value")))
      }
    }
}
