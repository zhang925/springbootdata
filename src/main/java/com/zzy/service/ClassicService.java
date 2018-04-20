package com.zzy.service;

import com.zzy.domain.Classic;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ClassicService {
    /**获取全部 list */
    public List<Classic> findAll();

    /**根据Integer ID 获取单个*/
    public Classic findClassicByID(Integer id);

    /**根据多查询条件获取 单个 */
    public Classic findModelByParam(Classic classic);

    /**根据多查询条件获取 list */
    public List<Classic> findListByParam(Classic classic);

    /**根据多查询条件  分页 获取 list */
    public List<Classic> findListByPage(Classic classic,Integer pageNo,Integer pageSize);

    /**添加*/
    public void saveClassic(Classic book);

    /**修改*/
    public void updateClassic(Classic book);

    /**删除*/
    public void deleteClassic(Integer id);

}
