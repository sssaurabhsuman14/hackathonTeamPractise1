package com.hcl.flight.enums;

public enum UserRole {
	
	SUPERUSER("SUPERUSER"),
	ADMIN("ADMIN"),
	USER("USER");
					
	private String value;
	
	public String getValue() {
		return value;
	}

	private UserRole(String value) {
		this.value = value;
	}
	
}
