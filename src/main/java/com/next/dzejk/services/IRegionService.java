package com.next.dzejk.services;

import java.util.List;

import com.next.dzejk.model.Region;

public interface IRegionService {

	 Region saveRegion(Region district);
	 Region findByid(int id );
	 List<Region> findAll();
}
