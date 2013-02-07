package com.limewoodMedia.nsapi.enums;

/**
 * Enum representing World Assembly status
 * @author Joakim Lindskog
 *
 */
public enum WAStatus {
	NON_MEMBER("Non-member"),
	WA_MEMBER("WA Member"),
	WA_DELEGATE("WA Delegate");
	
	public static WAStatus parse(String description) {
		for(WAStatus status : values()) {
			if(status.description.equalsIgnoreCase(description)) {
				return status;
			}
		}
		return null;
	}
	
	private String description;
	
	private WAStatus(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return description;
	}
}