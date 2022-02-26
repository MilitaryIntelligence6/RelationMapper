package cn.misection.relation.dao

import cn.hutool.json.JSONUtil
import cn.hutool.log.Log
import cn.misection.relation.callback.RelationListener
import cn.misection.relation.entity.PersonRelationPair
import com.alibaba.excel.EasyExcel

/**
 * @ClassName RelationDAO
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @Description TODO
 * @CreateTime 2022年02月26日 12:07:00
 */
object RelationDAO {

    fun readExcel(path: String): List<PersonRelationPair> {
        var result: List<PersonRelationPair> = ArrayList()
        EasyExcel.read(path, PersonRelationPair::class.java, RelationListener { dataList: List<PersonRelationPair> ->
            run {
                for ((index: Int, data: PersonRelationPair) in dataList.withIndex()) {
                    Log.get().info("读取到第 {} 条数据 {}", index, JSONUtil.toJsonStr(data))
                }
            }
            result = dataList
        })
        return result
    }
}
