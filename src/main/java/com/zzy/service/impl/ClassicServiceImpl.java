package com.zzy.service.impl;

import com.zzy.domain.Classic;
import com.zzy.repository.ClassicRepository;
import com.zzy.service.ClassicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClassicServiceImpl implements ClassicService{

    @Autowired
    private ClassicRepository classicRepository;

    @Override
    public List<Classic> findAll() {
        return classicRepository.findAll();
    }

    @Override
    public Classic findClassicByID(Integer id) {
        return classicRepository.findOne(id);
    }

    @Override
    public Classic findModelByParam(Classic classic) {
        if(classic==null){
            classic = new Classic();//保证不报错
        }
        Classic c = null;
        List<Classic> result = new ArrayList();
        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                //组合查询条件开始 contains  startsWith  endsWith
                .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("uid", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("content", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("createtime", ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnoreCase()  //忽略大小写查询
                .withIgnoreNullValues() //忽略 null 值 对 int 类型 无效 因此 int 使用 Integer
                .withIgnorePaths("state");  //忽略属性
        Example<Classic> e = Example.of(classic, matcher);
        result = classicRepository.findAll(e);
        if(result!=null && result.size()>0){
            c = result.get(0);
        }
        return c;
    }

    @Override
    public List<Classic> findListByParam(Classic classic) {
        if(classic==null){
            classic = new Classic();//保证不报错
        }
        List<Classic> result = new ArrayList();
        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                //组合查询条件开始 contains  startsWith  endsWith
                .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("uid", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("content", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("createtime", ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnoreCase()  //忽略大小写查询
                .withIgnoreNullValues(); //忽略 null 值 对 int 类型 无效 因此 int 使用 Integer
        //.withIgnorePaths("state");  //忽略属性
        Example<Classic> e = Example.of(classic, matcher);
        result = classicRepository.findAll(e);
        return  result;
    }

    @Override
    public List<Classic> findListByPage(Classic classic, Integer pageNO, Integer pageSize) {
        List<Classic> result = new ArrayList();
        if(classic==null){
            classic = new Classic();//保证不报错
        }
        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                //组合查询条件开始 contains  startsWith  endsWith
                .withMatcher("uid", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("content", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("createtime", ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnoreCase()  //忽略大小写查询
                .withIgnoreNullValues(); //忽略 null 值 对 int 类型 无效 因此 int 使用 Integer
        //.withIgnorePaths("state");  //忽略属性

        //注意调用时
        // 如果 获取不到数据    pageNO从 0 调用即可   好像有缓存一样 暂时不知道为什么
        Sort sort = new Sort(Sort.Direction.DESC, "id");// 排序
        Pageable pageable = new PageRequest(pageNO-1, pageSize, sort);//分页组件
        // 带查询条件
        Example<Classic> example = Example.of(classic, matcher);//加载查询条件
        Page<Classic> page2 = classicRepository.findAll(example,pageable);//分页带条件获取值
        result =  page2.getContent();
        return result;
    }

    @Override
    @CacheEvict(cacheNames="secondlevels",allEntries = true)
    public void saveClassic(Classic classic) {
        if(classic==null){
            classic = new Classic();//保证不报错
        }
        classicRepository.saveAndFlush(classic);
    }

    @Override
    @Modifying //定义为 修改
    @CacheEvict(cacheNames="secondlevels",allEntries = true)
    public void updateClassic(Classic classic) {
        if(classic==null){
            classic = new Classic();//保证不报错
        }
        Classic classicUpt = classicRepository.findOne(classic.getId());//先根据ID 获取到该 实体
        //这样就 实现 修改了
        if(classic.getUid()!=null){
            classicUpt.setUid(classic.getUid());
        }
        if(classic.getCreatetime()!=null){
            classicUpt.setCreatetime(classic.getCreatetime());
        }
        if(classic.getTitle()!=null){
            classicUpt.setTitle(classic.getTitle());
        }
        if(classic.getContent()!=null){
            classicUpt.setContent(classic.getContent());
        }
    }

    @Override
    public void deleteClassic(Integer id) {
        classicRepository.delete(id);
    }
}