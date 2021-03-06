/*
 * Copyright (c) 2013 Joakim Lindskog
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.limewoodMedia.nsapi.holders;

public class Embassy {
	/**
	 * Embassy status
	 */
	public enum EmbassyStatus {
		/** An established embassy */
		ESTABLISHED("established"),
		/** An embassy being created */
		PENDING("pending"),
		/** An embassy invitation from another region */
		INVITED("invited"),
		/** An embassy this region requested with another region */
		REQUESTED("requested"),
		/** An requested embassy that was denied recently */
		DENIED("denied"),
		/** An embassy that was recently closed */
		CLOSING("closing");
		
		public static EmbassyStatus parse(String description) {
			for(EmbassyStatus es : values()) {
				if(description == null) {
					return ESTABLISHED;
				}
				else if(description.equalsIgnoreCase(es.description)) {
					return es;
				}
			}
			return null;
		}
		
		private String description;
		
		private EmbassyStatus(String description) {
			this.description = description;
		}
		
		public String getDescription() {
			return description;
		}
	};
	
	public String region;
	public EmbassyStatus status;
	
	public Embassy() {}
	
	public Embassy(String region, EmbassyStatus status) {
		this.region = region;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "\t\t" + region + " (" + status.description + ")";
	}
}