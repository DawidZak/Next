package com.next.dzejk.services;

import com.next.dzejk.model.Region;

public interface IRegionService {

	 Region saveRegion(Region district);
	 Region findByid(int id );
}
