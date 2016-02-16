package org.reactors



import scala.collection._
import org.scalatest._



class IVarSpec extends FunSuite with Matchers {

  test("be assigned") {
    val iv = new IVar[Int]
    iv := 5
    assert(iv() == 5)
    assert(iv.isAssigned)
  }

  test("be unreacted") {
    val iv = new IVar[Int]
    iv.unreact()
    assert(iv.isCompleted)
    assert(iv.isFailed)
  }

  test("throw") {
    val iv = new IVar[Int]
    iv.unreact()
    intercept[NoSuchElementException] {
      iv()
    }
  }

  test("be created empty") {
    val a = IVar.empty
    assert(a.isCompleted)
    assert(a.isFailed)
  }

}

