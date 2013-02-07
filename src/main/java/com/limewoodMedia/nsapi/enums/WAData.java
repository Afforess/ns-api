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
package com.limewoodMedia.nsapi.enums;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.limewoodMedia.nsapi.enums.IArguments;
import com.limewoodMedia.nsapi.enums.IShards;
import com.limewoodMedia.nsapi.holders.WAHappening;
import com.limewoodMedia.nsapi.holders.WAMemberLogHappening;

/**
 * Data object for holding World Assembly data
 * @author joakim
 */
public class WAData {
	/**
	 * Shards for World Assembly data
	 */
	public static enum Shards implements IShards {
		NUM_NATIONS("numnations"),
		NUM_DELEGATES("numdelegates"),
		DELEGATES("delegates"),
		MEMBERS("members"),
		HAPPENINGS("happenings"),
		MEMBER_LOG("memberlog"),
		LAST_RESOLUTION("lastresolution");
		// Missing resolution, votetrack, dellog, delvotes
		
		private String name;
		private String tag;
		private Map<IArguments, String> arguments;

		private Shards(String name, String tag) {
			this.name = name;
			this.tag = tag;
		}

		private Shards(String nameTag) {
			this(nameTag, nameTag);
		}

		public String getName() {
			return this.name;
		}

		public String getTag() {
			return this.tag;
		}

		public Map<IArguments, String> getArguments() {
			if(arguments != null) {
				return new HashMap<IArguments, String>(arguments);
			}
			return arguments;
		}

		public Shards setArgument(IArguments name, String value) {
			if(arguments == null) {
				arguments = new HashMap<IArguments, String>();
			}
			arguments.put(name, value);
			return this;
		}
		
		public static enum Arguments implements IArguments {
			;
			
			private String name;

			private Arguments(String name) {
				this.name = name;
			}

			public String getName() {
				return this.name;
			}
		}
		
		public static enum SubTags {
			HAPPENINGS_EVENT("event"),
			MEMBER_LOG_EVENT("event");

			private String tag;

			private SubTags(String tag) {
				this.tag = tag;
			}

			public String getTag() {
				return this.tag;
			}
		}
	}

	public int numNations;
	public int numDelegates;
	public String[] delegates;
	public String[] members;
	public List<WAHappening> happenings;
	public List<WAMemberLogHappening> memberLog;
	public String lastResolution;
}