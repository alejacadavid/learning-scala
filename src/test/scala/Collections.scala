import org.junit.{Assert, Test}

class Collections {

  /*
        Traversable
            |
        Iterable
            |
       -------------------
       Set    Map    Seq
                      |
                 ----------------------------
                  IndexedSeq       LinearSeq
                  Ex. Array        Ex. List
   */


  //Apply obtains element of array in position given
  @Test def arraysApply(): Unit = {
    val fruits = Array("Peach", "Apple", "Pineapple")
    Assert.assertEquals("Peach", fruits.apply(0))
    Assert.assertEquals("Apple", fruits.apply(1))
  }

  //Length obtains size of array
  @Test def arraysLength(): Unit = {
    val fruits = Array("Peach", "Apple", "Pineapple")
    Assert.assertEquals(3, fruits.length)
  }

  /* isEmpty indicates if a array is empty
     nonEmpty indicates if a array is not empty
   */
  @Test def arraysEmpty(): Unit = {
    val fruits = Array("Peach", "Apple", "Pineapple")
    Assert.assertEquals(true, fruits.nonEmpty)
    Assert.assertEquals(false, fruits.isEmpty)
  }

  @Test def map(): Unit = {
    val numbers = List(4, 8 , 15, 16)

    def doble(x: Int): Int = 2 * x

    val doubles = numbers.map({ x => doble(x)})

    Assert.assertEquals(doubles, List(8, 16, 30, 32))
  }

  @Test def map2(): Unit = {
    val cars = List("BMW", "Mercedes", "Beat")

    val carsUpper = cars.map({ x => x.toUpperCase()})

    Assert.assertEquals(carsUpper, List("BMW", "MERCEDES", "BEAT"))

    val carsUpper2 = cars.map({ _.toUpperCase()})

    Assert.assertEquals(carsUpper2, List("BMW", "MERCEDES", "BEAT"))
  }

  @Test def flatten(): Unit = {
    val numbers = List(List(1, 2, 3), List(4, 5, 6))

    val numbersFlatten = numbers.flatten

    Assert.assertEquals(numbersFlatten, List(1, 2, 3, 4, 5, 6))
  }

  @Test def flatten2(): Unit = {
    val numbers = List(List(1, 2, 3, 4), List(4, 5, 6))

    val numbersFlatten = numbers.flatten

    Assert.assertEquals(numbersFlatten, List(1, 2, 3, 4, 4, 5, 6))
  }

  @Test def flatmap(): Unit = {
    val numbers = List(List(1, 2, 3, 4), List(4, 5, 6))

    val numbersDoubles = numbers.map({x => x.map({y => y * 2})})

    Assert.assertEquals(numbersDoubles, List(List(2, 4, 6, 8), List(8, 10, 12)))

    val numbersDoublesWithFlatMap = numbers.flatMap({x => x.map({y => y * 2})})

    Assert.assertEquals(numbersDoublesWithFlatMap, List(2, 4, 6, 8, 8, 10, 12))


  }

}
