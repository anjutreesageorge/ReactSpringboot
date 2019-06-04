package com.atp.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atp.demo.Util.ExcelUtil;
import com.atp.demo.model.Station;

@RestController

public class StationController {
	private static List<Station> stations;
	   static {
		   stations = new ArrayList<Station>();
		   Object[][] data = null;
			try {
				data = ExcelUtil.readExcel("/Users/anjutreesageorge/Desktop/demo/swob-xml_station_list.xlsx", "swob-xml_station_list");
			} catch (InvalidFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   for(Object obj[]:data) {
				
				Station station = new Station();
				
				station.setiATA_IDA1(obj[0].toString());
				station.setName(obj[1].toString());
				//if(obj[2]!=null)
				//station.setwMO_ID((int)obj[2]);
				station.setwMO_ID(0);

				station.setmSC_ID(obj[3].toString());
				station.setLatitude(obj[4].toString());
				station.setLongitude(obj[5].toString());
				station.setElevation(obj[6].toString());
				station.setData_Provider(obj[7].toString());
				station.setDataset_N(obj[8].toString());
				station.setaUTO_MA(obj[9].toString());
				if(obj[10]!=null)
				station.setProvince_Territory(obj[10].toString());
				else
					station.setProvince_Territory("");	
				
				stations.add(station);
				//stations.add(new Station(obj[0].toString(),obj[1].toString(),obj[2].toString(),obj[3].toString(),obj[4].toString(),obj[5].toString(),obj[6].toString(),obj[7].toString(),obj[8].toString(),obj[9].toString(),obj[10].toString()));
			}

       
       	
		   }
	   
	   @RequestMapping("/weather/v1/agency")
	  
	   public ResponseEntity<Object> getAgencies(){

		   HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setAccessControlAllowOrigin("http://localhost:3000");

			return new ResponseEntity<>(stations, httpHeaders, HttpStatus.OK);
		}
	   @RequestMapping("/weather/v1/agency/{id}/region")
		  
	   public ResponseEntity<Object> getRegion(@PathVariable("id") String id){
		   List<String> agencies = new ArrayList<String>();
		   for(Station station : stations) {
			   if(station.getiATA_IDA1().equals(id)) {
				   agencies.add(station.getProvince_Territory());
			   }
		   }
		   HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setAccessControlAllowOrigin("http://localhost:3000");

			return new ResponseEntity<>( agencies,httpHeaders, HttpStatus.OK);
		}
	    
	
}
