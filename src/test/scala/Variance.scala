import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Variance extends AnyFlatSpec with Matchers {



  "A covariant Zoo" should "allow assigning a Zoo[Dog] to a Zoo[Animal]" in {
    class Animal {
      def sound: String = "Some sound"
    }

    class Dog extends Animal {
      override def sound: String = "Woof"
    }

    class Zoo[+A](val animals: List[Animal]) {
      def makeAllSounds(): String = {
        animals.map(_.sound).mkString(", ")
      }
    }

    val dogs: List[Dog] = List(new Dog(), new Dog(), new Dog())
    val zooOfDogs: Zoo[Dog] = new Zoo(dogs)

    val zooOfAnimals: Zoo[Animal] = zooOfDogs
    val actualSounds = zooOfAnimals.makeAllSounds()
    val expectedSounds = "Woof, Woof, Woof"
    actualSounds shouldBe expectedSounds

  }

  "A covariant List" should "allow assigning a List[Int] to a List[Any]" in {
    val intList: List[Int] = List(1, 2, 3)
    val anyList: List[Any] = intList // This is allowed because List is covariant (List[+A]): Int is a subtype of Any
    anyList should contain theSameElementsAs List(1, 2, 3)
  }

  "A contravariant Logger" should "allow assigning a Logger[Any] to a Logger[String]" in {
    trait Logger[-A] {
      def log(value: A): Unit
    }

    class AnyLogger extends Logger[Any] {
      def log(value: Any): Unit = println(s"Logging: $value")
    }

    val anyLogger: Logger[Any] = new AnyLogger
    val stringLogger: Logger[String] = anyLogger

    // We can use stringLogger to log a String
    stringLogger.log("This is a string message")

    noException should be thrownBy stringLogger.log("This is a string message")
  }

  class Box[A](var content: A)

  "An invariant Container" should "not allow assigning a Container[Int] to a Container[Any]" in {
    val intBox: Box[Int] = new Box(42)
    "val intBox: Container[Any] = intBox" shouldNot compile
  }

  "An invariant Container" should "allow assigning only to the same type" in {
    val stringBox: Box[String] = new Box("Hi")
    stringBox.content should be ("Hi")
  }


}
