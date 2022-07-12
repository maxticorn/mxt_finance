import zio.*

import java.io.IOException

object Main extends ZIOAppDefault {
  def run: IO[IOException, Unit] =
    Console.printLine("hello world")
}
