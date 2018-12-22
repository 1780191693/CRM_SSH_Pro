package com.zwl.crm.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zwl.crm.domain.BaseDict;
import com.zwl.crm.service.BaseDictService;
import net.sf.json.JSONArray;

import java.util.List;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {
    private BaseDict baseDict = new BaseDict();
    @Override
    public BaseDict getModel() {
        return baseDict;
    }
    private BaseDictService baseDictService;

    public void setBaseDictService(BaseDictService baseDictService) {
        this.baseDictService = baseDictService;
    }

    public String findByTypeCode(){
        System.out.println("jquery方法执行了！！");
        List<BaseDict> typeCode = baseDictService.findByTypeCode(baseDict.getDict_type_code());
        /*将list转成json格式*/
        JSONArray jsonArray = JSONArray.fromObject(typeCode);
        System.out.println(jsonArray.toString());
        return NONE;
    }
}
