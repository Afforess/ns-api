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

import com.limewoodMedia.nsapi.enums.IArguments;
import com.limewoodMedia.nsapi.enums.IShards;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A data object for region data
 * @author Joakim Lindskog
 *
 */
public class RegionData {
	/**
	 * Shards for region data
	 * @author Joakim Lindskog
	 *
	 */
	public static enum Shards implements IShards {
		NAME("name"),
		FLAG("flag"),
		DELEGATE("delegate"),
		FOUNDER("founder"),
		FACTBOOK("factbook"),
		HAPPENINGS("happenings"),
		MESSAGES("messages"),
		NUM_NATIONS("numnations"),
		NATIONS("nations"),
		DELEGATE_VOTES("delegatevotes"),
		GA_VOTES("gavote"),
		SC_VOTES("scvote"),
		POWER("power"),
		EMBASSIES("embassies"),
		TAGS("tags");

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
		
		public Shards setArgument(Arguments name, String value) {
			if(arguments == null) {
				arguments = new HashMap<IArguments, String>();
			}
			arguments.put(name, value);
			return this;
		}

		public static enum SubTags {
			HAPPENINGS_EVENT("event"),
			MESSAGES_POST("post"),
			WA_VOTES_FOR("for"),
			WA_VOTES_AGAINST("against"),
			EMBASSIES_EMBASSY("embassy"),
			TAGS_TAG("tag");

			private String tag;

			private SubTags(String tag) {
				this.tag = tag;
			}

			public String getTag() {
				return this.tag;
			}
		}
		
		public static enum Arguments implements IArguments {
			MESSAGES_OFFSET("offset");
			
			private String name;

			private Arguments(String name) {
				this.name = name;
			}

			public String getName() {
				return this.name;
			}
		}
	}
	
	public String name;
	public String flagURL;
	public String delegate;
	public String founder;
	public String factbook;
	public List<RegionHappening> happenings;
	public List<RMBMessage> messages;
	public int numNations;
	public String[] nations;
	public int delegateVotes;
	public WAVotes generalAssemblyVotes;
	public WAVotes securityCouncilVotes;
	public String power;
	public List<Embassy> embassies;
	public List<String> tags;
	
	@Override
	public String toString() {
		String str = "Region"
				+"\n\tname:\t"+name
				+"\n\tflagURL:\t"+flagURL
				+"\n\tdelegate:\t"+delegate
				+"\n\tfounder:\t"+founder
				+"\n\tfactbook:\t"+factbook
				+"\n\thappenings:";
		if(happenings != null) {
			for(Happening h : happenings) {
				str += "\n" + h;
			}
		}
		str += "\n\tmessages:";
		if(messages != null) {
			for(RMBMessage msg : messages) {
				str += "\n" + msg;
			}
		}
		str += "\n\tnumNations:\t"+numNations
				+"\n\tnations:";
		if(nations != null) {
			for(String n : nations) {
				str += "\n\t\t" + n;
			}
		}
		str += "\n\tdelegateVotes:\t"+delegateVotes
				+"\n\tgeneralAssemblyVotes:\t"+generalAssemblyVotes
				+"\n\tsecurityCouncilVotes:\t"+securityCouncilVotes
				+"\n\tpower:\t"+power
				+"\n\tembassies:";
		if(embassies != null) {
			for(Embassy e : embassies) {
				str += "\n" + e;
			}
		}
		str += "\n\ttags:";
		if(tags != null) {
			for(String tag : tags) {
				str += "\n\t\t" + tag;
			}
		}
		return str;
	}
}