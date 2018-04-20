package com.zzy.repository;


import com.zzy.domain.Classic;
import com.zzy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;

public interface ClassicRepository extends
        Serializable,
        PagingAndSortingRepository<Classic,Integer>,
        JpaRepository<Classic,Integer>,
        Repository<Classic, Integer>{

   /* @Query(value = "select * from #{#entityName} c where c.title=?1", nativeQuery = true)
    List<Classic> findByTitle(@Param("title") String title);*/


   /*
List<User> findByNameAndAddress(String name, String address);
    @Query(value = "from Classic u where u.name=:name")
    List<User> findByName1(@Param("name") String name);

    @Query(value = "select * from #{#entityName} u where u.name=?1", nativeQuery = true)
    List<User> findByName2(String name);

    List<User> findByName(String name);*/
}
