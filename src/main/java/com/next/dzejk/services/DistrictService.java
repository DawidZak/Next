package com.next.dzejk.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next.dzejk.dao.IDistrictRepository;
import com.next.dzejk.model.District;

@Service
public class DistrictService implements IDistrictService {
	
	@Autowired
	IDistrictRepository districtRepository;
	
	@Override
	public District saveDistrict(District district) {
		districtRepository.save(district);
		return null;
	}
	
	@PostConstruct
	void init() {
		  System.out.println("Init method after properties are set : ");

		 saveDistrict(new District("AA"));
		
	}
}
