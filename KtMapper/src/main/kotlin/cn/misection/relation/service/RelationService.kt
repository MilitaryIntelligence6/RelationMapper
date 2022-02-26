package cn.misection.relation.service

import cn.misection.relation.entity.PersonRelationPair

/**
 * @ClassName RelationService
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @Description TODO
 * @CreateTime 2022年02月26日 15:49:00
 */
interface RelationService {

  fun getRelation(): List<PersonRelationPair>

  fun getRelationMap(): Map<String, String>
}
