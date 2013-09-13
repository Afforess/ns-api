package com.limewoodMedia.nsapi.enums;

public enum Filter {
	ENDORSEMENT("endo"),
	VOTE("vote"),
	WA_MEMBERSHIP("member"),
	WA_PROPOSAL("proposal"),
	MOVEMENT("move"),
	FOUNDING("founding"),
	CEASE_TO_EXIST("cte"),
	LEGISLATION("law"),
	SETTINGS_CHANGE("change"),
	FACTBOOK_DISPATCH("dispatch"),
	REGIONAL_MESSAGE_BOARD("rmb"),
	EMBASSY("embassy"),
	EJECTIONS("ejections"),
	ADMINISTRATION("admin");
	
	private final String filter;
	Filter(String filter) {
		this.filter = filter;
	}

	public String getFilter() {
		return filter;
	}
}
