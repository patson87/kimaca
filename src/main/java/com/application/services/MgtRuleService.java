package com.application.services;

import com.application.domain.MgtRule;

import java.util.List;

/**
 * Created by macbookpatric on 12/22/16.
 */
public interface MgtRuleService {

    List<MgtRule> listAllMgtrules();
    MgtRule getMgtRulesById(Integer id);
    MgtRule saveOrUpdateMgtRule(MgtRule mgtRule);
    void deleteMgtRule(Integer id);

}
