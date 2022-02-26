package cn.misection.ktrelation.service;

import java.util.List;
import java.util.Map;

import cn.misection.relation.entity.PersonRelationPair;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName RelationDAO
 * @Description TODO
 * @CreateTime 2022年02月25日 13:20:00
 */
public interface RelationService {

  List<PersonRelationPair> getRelation();

  Map<String, String> getRelationMap();
}
