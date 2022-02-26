package cn.misection.relation.service.impl

import cn.misection.relation.dao.RelationDAO
import cn.misection.relation.entity.PersonRelationPair
import cn.misection.relation.service.RelationService

/**
 * @ClassName RelationServiceImpl
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @Description TODO
 * @CreateTime 2022年02月26日 15:55:00
 */
class RelationServiceImpl constructor(
    private val path: String,
) : RelationService {

  private val relationList: List<PersonRelationPair> = RelationDAO.readExcel(path)

  private val relationMap: MutableMap<String, String> =
      mutableMapOf<String, String>().apply {
        relationList.forEach { pair: PersonRelationPair ->
          put(pair.person.trim(), pair.relation.trim())
        }
      }

  override fun getRelation(): List<PersonRelationPair> {
    return relationList
  }

  override fun getRelationMap(): Map<String, String> {
    return relationMap
  }
}
