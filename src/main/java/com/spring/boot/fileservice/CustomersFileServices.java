package com.spring.boot.fileservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.boot.entity.Customer;
import com.spring.boot.repository.InventoryRepository;
import com.spring.boot.utils.CustomersCsvUtils;
import org.springframework.web.servlet.ModelAndView;

@Service
public class CustomersFileServices {

	@Autowired
	InventoryRepository customerRepository;

	// Store File to Database
	public void store(MultipartFile file) {
		try {
			List<Customer> listCustomersItems = CustomersCsvUtils.parseCsvFile(file.getInputStream());
			// Save to DataBase
			customerRepository.saveAll(listCustomersItems);
		} catch (IOException e) {
			throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		}
	}

	// Load Data to CSV File
	public void loadFile(PrintWriter writer) {
		List<Customer> CustomersItems = (List<Customer>) customerRepository.findAll();

		try {
			CustomersCsvUtils.customeritemsToCsv(writer, CustomersItems);
		} catch (IOException e) {
		}
	}


	public ModelAndView AVG(){
		Double resultMale = customerRepository.Avg("men");
		Double resultFemale = customerRepository.Avg("women");

		return new ModelAndView("resultAVG").addObject("avgg",String.format("%.4f",Math.abs(resultFemale - resultMale)))
				.addObject("avgmen", String.format("%.4f",Math.abs(resultMale))).addObject("avgwomen", String.format("%.4f",Math.abs(resultFemale)));
	}

}
