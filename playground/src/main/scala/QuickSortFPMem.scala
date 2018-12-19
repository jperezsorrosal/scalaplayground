object QuickSortFPMem extends App {

  val r = scala.util.Random
  val arr = (for (i <- 1 to 10000000) yield r.nextInt(10000)).toArray

  println("=== BEFORE SORT ===")
  printRam
  Thread.sleep(500)
  val sortedArray = quickSort(arr)

  println("=== AFTER SORT ===")
  Thread.sleep(500)
  printRam

  println("=== AFTER GC ===")
  System.gc
  Thread.sleep(500)
  printRam

  def quickSort(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs
    else {
      printRam
      val pivot = xs(xs.length / 2)
      Array.concat(
        quickSort(xs filter (pivot >)),
        xs filter (pivot ==),
        quickSort(xs filter (pivot <)))
    }
  }

  /**
    * freeMemory  - the amount of free memory in the JVM (an approximation to the total amount of memory currently available for future allocated objects, measured in bytes)
    * totalMemory - the total amount of memory in the JVM
    * maxMemory   - the maximum amount of memory the JVM will attempt to use
    */
  def printRam {
    println("")
    val mb = 1024*1024
    val runtime = Runtime.getRuntime
    println("** Used Memory:  " + (runtime.totalMemory - runtime.freeMemory) / mb + " MB")
    println("** Free Memory:  " + runtime.freeMemory / mb + " MB")
    println("** Total Memory: " + runtime.totalMemory / mb + " MB")
    println("** Max Memory:   " + runtime.maxMemory / mb + " MB")
  }

}

object QuickSortFPScalaImplemented extends App {

  val r = scala.util.Random
  val arr = (for (i <- 1 to 10000000) yield r.nextInt(10000)).toArray

  println("=== BEFORE SORT ===")
  printRam
  Thread.sleep(500)
  val sortedArray = scala.util.Sorting.quickSort(arr)

  println("=== AFTER SORT ===")
  Thread.sleep(500)
  printRam

  println("=== AFTER GC ===")
  System.gc
  Thread.sleep(500)
  printRam


  /**
    * freeMemory  - the amount of free memory in the JVM (an approximation to the total amount of memory currently available for future allocated objects, measured in bytes)
    * totalMemory - the total amount of memory in the JVM
    * maxMemory   - the maximum amount of memory the JVM will attempt to use
    */
  def printRam {
    println("")
    val mb = 1024*1024
    val runtime = Runtime.getRuntime
    println("** Used Memory:  " + (runtime.totalMemory - runtime.freeMemory) / mb + " MB")
    println("** Free Memory:  " + runtime.freeMemory / mb + " MB")
    println("** Total Memory: " + runtime.totalMemory / mb + " MB")
    println("** Max Memory:   " + runtime.maxMemory / mb + " MB")
  }
}