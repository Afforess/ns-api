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

import java.util.HashMap;
import java.util.Map;

import com.limewoodMedia.nsapi.enums.IArguments;
import com.limewoodMedia.nsapi.enums.IShards;

/**
 * Data object for holding world data
 */
public class WorldData {
	private static final TagArgument TAGS = new TagArgument();
	public int numNations;
	public int numRegions;
	public String census;
	public int censusId;
	public int censusSize;
	public String censusScale;
	public int censusMedian;
	public String featuredRegion;
	public String[] newNations;
	public String[] regionsByTag;

	/**
	 * Shard enum for world data
	 */
	public static enum Shards implements IShards {
		NUM_NATIONS("numnations"),
		NUM_REGIONS("numregions"),
		CENSUS("census"),
		CENSUS_ID("censusid"),
		CENSUS_SIZE("censussize"),
		CENSUS_SCALE("censusscale"),
		CENSUS_MEDIAN("censusmedian"),
		FEATURED_REGION("featuredregion"),
		NEW_NATIONS("newnations"),
		REGIONS_BY_TAG("regionsbytag", "regions"),
		;
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

		public void addTag(String tag) {
			if (this != REGIONS_BY_TAG) {
				throw new IllegalArgumentException("Tags can only be added to REGIONS_BY_TAG");
			}
			if (arguments == null) {
				arguments = new HashMap<IArguments, String>();
				arguments.put(TAGS, "");
			}
			String value = arguments.get(TAGS);
			if (value != null && value.length() > 0) {
				arguments.put(TAGS, value + "," + tag);
			} else {
				arguments.put(TAGS, tag);
			}
		}

		public void clearTags() {
			if (this != REGIONS_BY_TAG) {
				throw new IllegalArgumentException("Tags can only be added to REGIONS_BY_TAG");
			}
			if (arguments != null) {
				arguments.remove(TAGS);
			}
		}
	}

	private static class TagArgument implements IArguments {
		@Override
		public String getName() {
			return "tags";
		}
		
	}
}
