package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.ICourierService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/track")
@CrossOrigin(origins = "*")
@Validated
@Slf4j
public class TrackController {

	@Autowired
	private ICourierService courierService;
	
	

	
	
	@GetMapping("getACourierDetailsByCourierId/{cId}")
	public ResponseEntity<?> getCourierDetails(@PathVariable @Valid long cId)
	{
		return new ResponseEntity<>(courierService.getCourierDetailsByCourierId(cId), HttpStatus.OK);
	}
	
	


	
}
