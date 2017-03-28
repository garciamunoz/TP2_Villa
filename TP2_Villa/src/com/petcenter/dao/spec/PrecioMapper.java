package com.petcenter.dao.spec;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.petcenter.dto.PrecioDTO;

public interface PrecioMapper {
	
	List<PrecioDTO> listarPrecios(@Param("mon") String mon,@Param("startDate") String startDate,@Param("endDate") String endDate);

}
