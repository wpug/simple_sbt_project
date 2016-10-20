object Hello {

  def main(args: Array[String]): Unit = {
    val hi = if (args.isEmpty) "World" else joiner(args.toList, "--")
    println(s"Hello ${hi + "!!"}!")
  }

  private def joiner(strings: List[String], separator: String = " "): String = {
    strings.mkString(separator)
  }

}
