package com.fin.ExpenTrack.repos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fin.ExpenTrack.entities.Expenditure;

public interface ExpenditureRepo extends JpaRepository<Expenditure, Integer> {

	@Query("from Expenditure e where e.expuser.user_name =:username and e.category.category_code =:catcode")
	List<Expenditure> listAllExpByCatAndUsr(@Param("username") String username, @Param("catcode") String catcode,
			PageRequest pageable);

	@Query("from Expenditure  e where e.expuser.user_name =:username and e.paymentMode.pay_code =:paymentType")
	List<Expenditure> listAllExpByPayModeAndUsr(@Param("username") String username,
			@Param("paymentType") String paymentType, PageRequest page);

	@Query("from Expenditure e where e.expuser.user_name =:username and e.date between :startDate and :endDate")
	List<Expenditure> listAllExpBtwDates(@Param("username") String username, @Param("startDate") Date startDate,
			@Param("endDate") Date endDate, PageRequest page);

	@Query(" from Expenditure where tag LIKE %:tag%")
	List<Expenditure> listAllExpByTags(@Param("tag") String tag);

	@Query("select e.category.category_code, sum(e.amount) as total_amount from Expenditure e where month(e.date)=:month group by e.category.category_code ")
	List<String> listAllExpCatAndTamount(@Param("month") int month);

	@Query("select e from Expenditure e where e.expuser.user_name=:username")
	List<Expenditure> listTopFiveExp(@Param("username") String username, PageRequest pageable);
}
