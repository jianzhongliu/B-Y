package com.by.test;

import java.util.ArrayList;

import net.sf.json.JSONArray;

import com.by.dao.TouristDAO;
import com.by.model.Tourist;
import com.by.resource.ClienteResource;
import com.by.response.ScenaryResponseObject;

public class TestUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestUtil testUtil = new TestUtil();
		testUtil.getAllTourist();
	}
public void getAllTourist() {
	System.out.println("===result===");
	
	
	
	
	TouristDAO touristDao = new TouristDAO();
	ArrayList<Tourist> touristList = touristDao.getAllTourist();
	ScenaryResponseObject  response = new ScenaryResponseObject();
//	response.setDataArray(touristList.toString());
	System.out.println("===result==="+touristList);
}
//	Tourist 
}
