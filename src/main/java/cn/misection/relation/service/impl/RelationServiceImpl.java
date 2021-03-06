package cn.misection.relation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.core.util.StrUtil;
import cn.misection.relation.entity.PersonRelationPair;
import cn.misection.relation.dao.RelationDAO;
import cn.misection.relation.service.RelationService;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName RelationServiceImpl
 * @Description TODO
 * @CreateTime 2022年02月25日 13:21:00
 */
public class RelationServiceImpl implements RelationService {

  private final String path;

  private List<PersonRelationPair> relationList;

  private Map<String, String> relationMap;

  public RelationServiceImpl(String path) {
    this.path = path;
    init();
  }

  private void init() {
    relationList = RelationDAO.readExcel(path);
    relationMap = new HashMap<>(relationList.size());
    for (PersonRelationPair pair : relationList) {
      relationMap.put(StrUtil.trim(pair.getPerson()), StrUtil.trim(pair.getRelation()));
    }
  }

  @Override
  public List<PersonRelationPair> getRelation() {
    return relationList;
  }

  @Override
  public Map<String, String> getRelationMap() {
    return relationMap;
  }
}
