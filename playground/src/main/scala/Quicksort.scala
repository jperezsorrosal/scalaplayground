object QuickSortFP extends App {

  // create an array of random 10m random ints
  val r = scala.util.Random
  val randomArray = (for (i <- 1 to 10000000) yield r.nextInt(1000000)).toArray

  // do the sorting
  val sortedArray = quickSort(randomArray)

  // print some
  sortedArray.take(20).foreach(println)

  // the fp/recursive algorithm
  def quickSort(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)

      Array.concat(
        quickSort(xs filter (pivot >)),
        xs filter (pivot ==),
        quickSort(xs filter (pivot <)))
    }
  }

}