package com.atp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.atp.demo.Util.ExcelUtil;


@SpringBootApplication
public class DemoApplication {
//@Autowired
	//StationService stationService;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	//@Bean
    //CommandLineRunner runner(StationService stationService) {
      //  return args -> {
        	
        //	Object[][] data = ExcelUtil.readExcel("/Users/anjutreesageorge/Desktop/demo/swob-xml_station_list.xlsx", "swob-xml_station_list");
        //	stationService.saveAll(data);
        	
        //};
	//}

}
