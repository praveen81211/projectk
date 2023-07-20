package com.fin.ExpenTrack.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fin.ExpenTrack.entities.PaymentMode;

public interface PaymentModeRepo extends JpaRepository<PaymentMode, String> {

	@Query(value = "select pay_name from Paymentmode WHERE user_name=:username", nativeQuery = true)
	List<String> listPayModesOfUser(@Param("username") String username);


   @Query(value="select user_name from Paymentmode WHERE remarks=:remarks",nativeQuery=true)
   List<String> listusername(@Param("remarks") String remarks);
}   
   