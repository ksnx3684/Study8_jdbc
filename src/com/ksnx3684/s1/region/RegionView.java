package com.ksnx3684.s1.region;

import java.util.List;

public class RegionView {
	
	public void view(RegionDTO regionDTO) {
		System.out.print(regionDTO.getRegion_id()+"\t");
		System.out.println(regionDTO.getRegion_name()+"\t");
		System.out.println("------------------------------");
	}
	
	public void view(List<RegionDTO> ar) {
		for(int i = 0; i < ar.size(); i++) {
			this.view(ar.get(i));
		}
	}
	
	public void view(String message) {
		System.out.println("====================");
		System.out.println("Result : " + message);
		System.out.println("====================");
	}
}
