package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class Car {
	private String address;
	private String make;
	private String model;
	private String year;
	private String fuel;
	private String seats;
	private String carClass;
	private String carRegNumber;
	private String price;

	//===========================================================================================
	@Override
	public String toString () {
		return "Car {" +
				" address:'" + address + '\'' +
				"; make:'" + make + '\'' +
				"; model:'" + model + '\'' +
				"; year:'" + year + '\'' +
				"; fuel:'" + fuel + '\'' +
				"; seats:'" + seats + '\'' +
				"; carClass:'" + carClass + '\'' +
				"; carRegNumber:'" + carRegNumber + '\'' +
				"; price:'" + price + '\'' +
				'}';
	}
}
