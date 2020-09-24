package resources;

import io.cucumber.core.resource.Resource;

public enum Resources {
	
	 AddPlaceAPI("/maps/api/place/add/json"),
	 DeletePlaceAPI("/maps/api/place/delete/json"),
	 getPlaceAPI("/maps/api/place/get/json");
	
	private String resource;
	
	Resources(String resource) {
		// TODO Auto-generated constructor stub
		this.resource =resource;
	}
	
	public String getResource() {
		
		return resource;
	}
	

}
