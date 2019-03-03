package com.xulei.jpa.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xulei.jpa.domain.MyModel;
import com.xulei.jpa.domain.UserEntity;


public interface UserJPA extends JpaRepository<UserEntity,Long>{
	
	@Query(value = "select * from t_user where t_age > ?1",nativeQuery = true)
    public List<UserEntity> nativeQuery(int age);
	
//	@Query(value="select t_address ,t_name from t_user where t_id=?1",nativeQuery = true)
	@Query(value="select new com.xulei.jpa.domain.MyModel (t.t_address ,t.t_name ) from t_user  t where t_id=?1",nativeQuery = true)
	public List<MyModel> findUser(int id);

}
