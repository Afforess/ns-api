package com.limewoodMedia.nsapi.holders;

import com.limewoodMedia.nsapi.enums.WACouncil;

public class WAResolution {
	public static enum SubTags {
		CATEGORY("category"),
		CREATED("created"),
		DESCRIPTION("desc"),
		NAME("name"),
		PROPOSED_BY("proposed_by"),
		VOTES_AGAINST("total_votes_against"),
		VOTES_FOR("total_votes_for");

		private final String tag;
		SubTags(String tag) {
			this.tag = tag;
		}

		public String getTag() {
			return tag;
		}
	}
	public WACouncil council;
	public String category;
	public int created;
	public String description;
	public String name;
	public String proposedBy;
	public int votesAgainst;
	public int votesFor;
}
