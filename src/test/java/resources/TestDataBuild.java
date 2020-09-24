package resources;

import java.util.ArrayList;
import java.util.List;

import stepDefinitions.AddPlacePojo;
import stepDefinitions.Location;

public class TestDataBuild {
	public AddPlacePojo addPlacePayLoad(String name, String language, String address) {
		AddPlacePojo p =new AddPlacePojo();
    	p.setAccuracy(50);
    	p.setAddress(address);
    	p.setLanguage(language);
    	p.setPhoneNumber("(+91) 983 893 3937");
    	p.setWebsite("https://rahulshettyacademy.com");
    	p.setName(name);
    	List<String> myList =new ArrayList<String>();
    	myList.add("shoe park");
    	myList.add("shop");

    	p.setTypes(myList);
    	Location l =new Location();
    	l.setLat(-38.383494);
    	l.setLng(33.427362);
    	p.setLocation(l);
    	return p;
		
	}

}
