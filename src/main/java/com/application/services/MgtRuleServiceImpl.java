package com.application.services;

import com.application.domain.MgtRule;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by macbookpatric on 12/22/16.
 */

@Service
public class MgtRuleServiceImpl implements MgtRuleService {
    Date date = Calendar.getInstance().getTime();

    private Map<Integer, MgtRule> mgtRules;

    public MgtRuleServiceImpl(){
        loadMgtRules();
    }

    @Override
    public List<MgtRule> listAllMgtrules() {

        return new ArrayList<>(mgtRules.values());
    }

    @Override
    public MgtRule getMgtRulesById(Integer id) {
        return mgtRules.get(id);
    }

    @Override
    public MgtRule saveOrUpdateMgtRule(MgtRule mgtRule) {
        if (mgtRule != null){
            if (mgtRule.getId() == null){
                mgtRule.setId(getNextKey());
            }
            mgtRules.put(mgtRule.getId(), mgtRule);
            return mgtRule;
        } else {
            throw new RuntimeException("Management Rule Can't be nill");
        }
    }

    @Override
    public void deleteMgtRule(Integer id) {
        mgtRules.remove(id);
    }

    private Integer getNextKey(){
        return Collections.max(mgtRules.keySet()) + 1;
    }

    private void loadMgtRules(){

        mgtRules = new HashMap<>();

        MgtRule mgtRule1 = new MgtRule();
        mgtRule1.setId(1);
        mgtRule1.setName("rule 1");
        mgtRule1.setType("christmas");
        mgtRule1.setStartDate(date);
        mgtRule1.setEndDate(date);
        mgtRule1.setCreationDate(date);
        mgtRule1.setStatus("active");

        mgtRules.put(1, mgtRule1);

        MgtRule mgtRule2 = new MgtRule();
        mgtRule2.setId(2);
        mgtRule2.setName("rule 2");
        mgtRule2.setType("Sales");
        mgtRule2.setStartDate(date);
        mgtRule2.setEndDate(date);
        mgtRule2.setCreationDate(date);
        mgtRule2.setStatus("active");

        mgtRules.put(2, mgtRule2);

        MgtRule mgtRule3 = new MgtRule();
        mgtRule3.setId(3);
        mgtRule3.setName("rule 3");
        mgtRule3.setType("Black Friday");
        mgtRule3.setStartDate(date);
        mgtRule3.setEndDate(date);
        mgtRule3.setCreationDate(date);
        mgtRule3.setStatus("active");

        mgtRules.put(3, mgtRule3);

        MgtRule mgtRule4 = new MgtRule();
        mgtRule4.setId(4);
        mgtRule4.setName("rule 4");
        mgtRule4.setType("Summer Sales");
        mgtRule4.setStartDate(date);
        mgtRule4.setEndDate(date);
        mgtRule4.setCreationDate(date);
        mgtRule4.setStatus("active");

        mgtRules.put(4, mgtRule4);

        MgtRule mgtRule5 = new MgtRule();
        mgtRule5.setId(5);
        mgtRule5.setName("rule 5");
        mgtRule5.setType("Winter Sales");
        mgtRule5.setStartDate(date);
        mgtRule5.setEndDate(date);
        mgtRule5.setCreationDate(date);
        mgtRule5.setStatus("active");

        mgtRules.put(5, mgtRule5);

    }
}
