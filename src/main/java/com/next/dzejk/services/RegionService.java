package com.next.dzejk.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next.dzejk.dao.IRegionRepository;
import com.next.dzejk.model.Region;

@Service
public class RegionService implements IRegionService{
	
	@Autowired
	IRegionRepository regionName;
	

	
	
	@Override
	public Region saveRegion(Region district) {
		return regionName.save(district);
		
	}
	
	@PostConstruct
	void init() {
		  System.out.println("Init method after properties are set : ");
		 
		 saveRegion(new Region("Warminsko-Mazurskie"));
		 saveRegion(new Region("Wielkopolskie"));
	     saveRegion(new Region("Zachodnopomorskie"));
		 saveRegion(new Region("£ódzkie")); 
		 saveRegion(new Region("Dolnoœl¹skie"));
		 saveRegion(new Region("Kujawsko-Pomorskie"));
		 saveRegion(new Region("Lubelskie"));
		 saveRegion(new Region("Lubuskie"));
		 saveRegion(new Region("Ma³opolskie"));
		 saveRegion(new Region("Mazowieckie"));
		 saveRegion(new Region("Opolskie"));
		 saveRegion(new Region("Podlaskie"));
		 saveRegion(new Region("Podkarpackie"));
		 saveRegion(new Region("Pomorskie"));
		 saveRegion(new Region("Œl¹skie"));
		 saveRegion(new Region("Œwiêtokrzyskie"));
			//saveInitUser(new User("Imie1", "Nazwisko1","12","12","wp.pl","Lodz",4,4));

	}

	@Override
	public Region findByid(int id) {
		return regionName.findOne(id);
		
	}

	@Override
	public List<Region> findAll() {
		
		return regionName.findAll();
	}


}
