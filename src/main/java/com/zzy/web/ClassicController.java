package com.zzy.web;

import com.zzy.domain.Classic;
import com.zzy.service.ClassicService;
import com.zzy.util.Util_ParamReflex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/classic")
public class ClassicController {
    @Autowired
    private ClassicService classicService;


    /**
     * 查询全部
     */
    @RequestMapping(value = "/")
    public List<Classic> getAllClassic(){
        return classicService.findAll();
    }

    /**
     * 根据ID获取实体
     */
    @RequestMapping(value = "/getClassicByID/{id}")
    public Classic getClassicByID(@PathVariable int id){
        return classicService.findClassicByID(id);
    }


    /**根据参数获取List*/
    @RequestMapping(value = "/getClassicByParam")
    public List<Classic> getClassicByParam(
            @PathVariable(required = false) String title ,
            @RequestParam(required = false) String content ,
            @RequestBody(required = false) Classic classic ,
            HttpServletRequest request) {

        Util_ParamReflex up = new Util_ParamReflex(Classic.class);
        Classic c = (Classic)up.setAjaxParam(request);

        List<Classic> list = classicService.findListByParam(c);
        return list;
    }
    /**根据参数分页获取List*/
    @RequestMapping(value = "/getListByPage")
    public List<Classic> getListByPage( HttpServletRequest request) {

        Util_ParamReflex up = new Util_ParamReflex(Classic.class);
        Classic c = (Classic)up.setAjaxParam(request);
        String pageStr = request.getParameter("page");
        String rowsStr = request.getParameter("rows");
        int page=0, rows = 5;
        if(pageStr!=null && rowsStr!=null){
            page = Integer.valueOf(pageStr);
            rows = Integer.valueOf(rowsStr);
        }
        List<Classic> list = classicService.findListByPage(c,page,rows);
        return list;
    }

    /**保存*/
    @RequestMapping(value = "/save/{title}/{content}", method = { RequestMethod.POST })
    @ResponseBody
    public Classic save(@PathVariable(required = false) String title,@PathVariable(required = false) String content,HttpServletRequest request){
        String result = "保存成功！";
        Classic c = new  Classic();
        //无法 获取POST
       /*
        String title = request.getParameter("title");
        Util_ParamReflex up = new Util_ParamReflex(Classic.class);
        Classic c = (Classic)up.setAjaxParam(request);*/
        c.setContent(content);
        c.setTitle(title);
        classicService.saveClassic(c);
        return c;
    }

    /**保存*/
    @PostMapping(value = "/save2")
    public Classic save2(
            @RequestParam(value = "title", required = false) String title
           // @RequestBody(required = false) Map<String,Object> reqMap
        ){
        String result = "保存成功！";
        Classic c = new  Classic();
        //classicService.saveClassic(c);
        return c;
    }

    /**修改*/
    @RequestMapping(value = "/update/{id}/{title}")
    public Classic update(@PathVariable String id,@PathVariable String title){
        String result = "修改成功！";

        Classic c = new  Classic();
        c.setId(30);
        c.setTitle(title);

        classicService.updateClassic(c);
        return c;
    }
    /**删除*/
    @RequestMapping(value = "/delete/{id}")
    public Map delete(@PathVariable Integer id){
        Map map = new HashMap();
        map.put("msg","删除成功!");
        classicService.deleteClassic(id);
        return map;
    }




}