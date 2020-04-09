import org.junit.Test

class Basic {

  @Test def helloWorld(): Unit = {
    println("Hello world!")
  }

  @Test def conditionalsUsingIf(): Unit = {
    val n = 7
    if (n == 5) {
      println("n is 5")
    } else {
      println("n is not 5")
    }
  }

  @Test def conditionalsUsingMatch(): Unit = {
    val month = 7

    println(month match {
      case 1 => "January"
      case 2 => "February"
      case 4 => "April"
      case 6 => "June"
      case _ => "None"
    })
  }

}
