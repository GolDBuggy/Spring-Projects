package com.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class MsSqlCustomerDal implements ICustomerDal{
	@Value("${database.connectionString}")
	String connectionString;
	
	

	public String getConnectionString() {
		return connectionString;
	}



	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}


	@Override
	public void add() {
		System.out.println("MsSql veri tabanýna eklendi");
		System.out.println("Connection string: "+this.connectionString);
		
	}

}
