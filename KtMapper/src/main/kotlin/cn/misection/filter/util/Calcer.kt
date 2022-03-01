package cn.misection.filter.util

/**
 * @ClassName Calcer
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @Description TODO
 * @CreateTime 2022年02月28日 22:51:00
 */
object Calcer {

  private const val GROUP_COUNT: Int = 75

  private const val INTERVAL: Int = 15

  private const val STEP: Int = INTERVAL / (GROUP_COUNT / INTERVAL)

  /**
   * ### TODO
   * * 做缓存, 避免重复计算
   */
  @JvmStatic
  fun shouldRetain(index: Int): Boolean {
//    val groupIndex: Int = index % GROUP_COUNT
//    val groupCount: Int = groupIndex / 15
//    val startIndex: Int = ((groupIndex / INTERVAL) as Int) * STEP
//    return (groupIndex <= (groupIndex + startIndex) && groupIndex <= startIndex + 2)
    val groupIndex: Int = index % 75
    val groupStart: Int = (groupIndex / 15) * 15
    val startIndex: Int = ((groupIndex / INTERVAL) as Int) * STEP
    val retainStart: Int = groupStart + startIndex
    val retainEnd: Int = retainStart + 2
    return (groupIndex in retainStart..retainEnd)
  }
}
