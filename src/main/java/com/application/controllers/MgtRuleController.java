package com.application.controllers;

import com.application.domain.MgtRule;
import com.application.services.MgtRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by macbookpatric on 12/22/16.
 */

@Controller
public class MgtRuleController {

    private MgtRuleService mgtRuleService;

    @Autowired
    public void setMgtRuleService(MgtRuleService mgtRuleService) {
        this.mgtRuleService = mgtRuleService;
    }

    @RequestMapping("/mgtrules")
    public String listMgtRules(Model model){
        model.addAttribute("mgtRules", mgtRuleService.listAllMgtrules());
        return "mgtRules";
    }

    @RequestMapping("/mgtrule/{id}")
    public String getMgtRule(@PathVariable Integer id, Model model){
        model.addAttribute("mgtRule", mgtRuleService.getMgtRulesById(id));
        return "mgtRule";
    }

    @RequestMapping("/mgtrule/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("mgtRule", mgtRuleService.getMgtRulesById(id));
        return "mgtRuleForm";
    }

    @RequestMapping("/mgtrule/new")
    public String newMgtRule (Model model){

        model.addAttribute("mgtRule", new MgtRule());
        return "mgtRuleForm";
    }

    @RequestMapping(value="/mgtrule", method = RequestMethod.POST)
    public String saveOrUpdateMgtRule(MgtRule mgtRule){
        MgtRule savedMgtRule = mgtRuleService.saveOrUpdateMgtRule(mgtRule);
        System.out.println("The rule has been created with the id: " + savedMgtRule.getId());
        return "redirect:/mgtrule/" + savedMgtRule.getId();
    }

    @RequestMapping("/mgtrule/delete/{id}")
    public String delete(@PathVariable Integer id){
        mgtRuleService.deleteMgtRule(id);
        return "redirect:/mgtrules";
    }
}
