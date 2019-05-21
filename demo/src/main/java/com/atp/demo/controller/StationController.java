package com.atp.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.atp.demo.Util.ExcelUtil;
import com.atp.demo.model.Agency;
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
				//station.setwMO_ID((int)obj[2]);
				station.setmSC_ID(obj[3].toString());
				station.setLatitude(obj[4].toString());
				station.setLongitude(obj[5].toString());
				station.setElevation(obj[6].toString());
				station.setData_Provider(obj[7].toString());
				station.setaUTO_MA(obj[8].toString());
				station.setProvince_Territory(obj[9].toString());
				
				stations.add(station);
				//stations.add(new Station(obj[0].toString(),obj[1].toString(),obj[2].toString(),obj[3].toString(),obj[4].toString(),obj[5].toString(),obj[6].toString(),obj[7].toString(),obj[8].toString(),obj[9].toString(),obj[10].toString()));
			}

       
       	
		   }
	   @RequestMapping("/demo")
	  
	   public ResponseEntity<Object> getProduct(){

		   HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setAccessControlAllowOrigin("http://localhost:3000");

			return new ResponseEntity<>(stations, httpHeaders, HttpStatus.OK);
		}
	    
	
}
