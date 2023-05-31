package com.capg.dto;


import com.capg.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

	private Integer houseNumber;
	private String streetName;
	private String colonyName;
	private String city;
	private String state;
	private int pincode;
	
	public AddressDTO(Address address) {
		this.houseNumber = address.getHouseNumber();
		this.streetName = address.getStreetName();
		this.colonyName = address.getColonyName();
		this.city = address.getCity();
		this.state = address.getState();
		this.pincode = address.getPincode();
		
	}

}
