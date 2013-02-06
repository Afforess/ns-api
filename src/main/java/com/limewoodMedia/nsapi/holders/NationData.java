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

import com.limewoodMedia.nsapi.enums.Categories;
import com.limewoodMedia.nsapi.enums.CauseOfDeath;
import com.limewoodMedia.nsapi.enums.IArguments;
import com.limewoodMedia.nsapi.enums.IShards;
import com.limewoodMedia.nsapi.enums.WAStatus;
import com.limewoodMedia.nsapi.enums.WAVote;
import com.limewoodMedia.nsapi.holders.RegionData.Shards.Arguments;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data object for nation data
 * @author Joakim Lindskog
 *
 */
public class NationData {
	/**
	 * Shards enum for nation data
	 * @author Joakim Lindskog
	 *
	 */
	public static enum Shards implements IShards {
		NAME("name"),
		FULL_NAME("fullname"),
		MOTTO("motto"),
		FLAG("flag"),
		REGION("region"),
		CATEGORY("category"),
		POPULATION("population"),
		FREEDOMS("freedom"),
		ADMIRABLE("admirable"),
		NOTABLE("notable"),
		SENSIBILITIES("sensibilities"),
		GOVERNMENT_DESCRIPTION("govtdesc"),
		TAX_RATE("tax"),
		INDUSTRY_DESCRIPTION("industrydesc"),
		ANIMAL("animal"),
		ANIMAL_TRAIT("animaltrait"),
		CRIME("crime"),
		CURRENCY("currency"),
		CUSTOM_LEADER("customleader", "leader"),
		CUSTOM_RELIGION("customreligion", "religion"),
		LEGISLATION("legislation"),
		HAPPENINGS("happenings"),
		TYPE("type"),
		WA_STATUS("wa", "unstatus"),
		ENDORSEMENTS("endorsements"),
		GA_VOTE("gavote"),
		SC_VOTE("scvote"),
		MAJOR_INDUSTRY("majorindustry"),
		GOVERNMENT_PRIORITY("govtpriority"),
		LEADER("leader"),
		RELIGION("religion"),
		GOVERNMENT_BUDGET("govt"),
		FOUNDED("founded"),
		FIRST_LOGIN("firstlogin"),
		LAST_ACTIVITY("lastactivity"),
		LAST_LOGIN("lastlogin"),
		INFLUENCE("influence"),
		FREEDOM_SCORES("freedomscores"),
		PUBLIC_SECTOR("publicsector"),
		DEATHS("deaths"),
		CAPITAL("capital"),
		CUSTOM_CAPITAL("customreligion", "religion");

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

		public static enum Attributes {
			DEATHS_CAUSE_TYPE("type");

			private String name;

			private Attributes(String name) {
				this.name = name;
			}

			public String getName() {
				return this.name;
			}
		}

		public static enum SubTags {
			HAPPENINGS_EVENT("event"),
			FREEDOMS_CIVIL_RIGHTS("civilrights"),
			FREEDOMS_ECONOMY("economy"),
			FREEDOMS_POLITICAL_FREEDOM("politicalfreedom"),
			LEGISLATION_LAW("law"),
			BUDGET_ENVIRONMENT("environment"),
			BUDGET_SOCIAL_EQUALITY("socialequality"),
			BUDGET_EDUCATION("education"),
			BUDGET_LAW_AND_ORDER("lawandorder"),
			BUDGET_ADMINISTRATION("administration"),
			BUDGET_WELFARE("welfare"),
			BUDGET_SPIRITUALITY("spirituality"),
			BUDGET_DEFENCE("defence"),
			BUDGET_PUBLIC_TRANSPORT("publictransport"),
			BUDGET_HEALTHCARE("healthcare"),
			BUDGET_COMMERCE("commerce"),
			DEATHS_CAUSE("cause");

			private String tag;

			private SubTags(String tag) {
				this.tag = tag;
			}

			public String getTag() {
				return this.tag;
			}
		}
	}
	
	public String name;
	public String fullName;
	public String motto;
	public String flagURL;
	public String region;
	public String category;
	public int population;
	public NationFreedoms freedoms;
	public String admirable;
	public String notable;
	public String sensibilities;
	public String governmentDescription;
	public int taxRate;
	public String industryDescription;
	public String animal;
	public String animalTrait;
	public String crime;
	public String currency;
	public String leader;
	public String religion;
	public String legislation;
	public List<NationHappening> happenings;
	public String type;
	public WAStatus worldAssemblyStatus;
	public String[] endorsements;
	public WAVote generalAssemblyVote;
	public WAVote securityCouncilVote;
	public String majorIndustry;
	public String governmentPriority;
	public Budget governmentBudget;
	public String founded;
	public long firstLogin;
	public String lastActivity;
	public long lastLogin;
	public String influence;
	public int publicSector;
	public Map<CauseOfDeath, Integer> deaths;
	public String capital;

	public String getDescription() {
		String size;
		if (this.population > 9999) {
			size = "gargantuan";
		}
		else if (this.population > 4999) {
			size = "colossal";
		}
		else if (this.population > 999) {
			size = "massive";
		}
		else if (this.population > 199) {
			size = "huge";
		}
		else if (this.population > 99) {
			size = "very large";
		}
		else if (this.population > 49) {
			size = "large";
		}
		else if (this.population > 19) {
			size = "small";
		}
		else if (this.population > 6) {
			size = "tiny";
		}
		else {
			size = "fledgling";
		}
		String milbil = null;
		if (this.population > 999) {
			milbil = (this.population / 1000f) + " billion";
		}
		else {
			milbil = this.population + " million";
		}
		String notable;
		switch ((int)Math.round(Math.random() * 3.0D)) {
		case 0:
			notable = "notable";
			break;
		case 1:
			notable = "remarkable";
			break;
		case 2:
			notable = "renowned";
			break;
		default:
			notable = "notable";
		}
		String categoryDescription = Categories.parse(this.category).getDescription();
		String legi = this.legislation.replaceAll("@@NAME@@", this.name)
				.replaceAll("@@ANIMAL@@", this.animal);
		return this.fullName + " is a " + size + ", " + this.admirable + " nation, " +
				(this.leader != null ? "ruled by " + this.leader + " with a fair hand and " : "") +
				notable + " for its " + this.notable + ". " + "Its " + this.sensibilities +
				" population of " + milbil + " " + categoryDescription + ".\n\n" +
				this.governmentDescription + " The average income tax rate is " + this.taxRate + "%. "
				+ this.industryDescription + "\n\n" + legi + this.crime + " " + this.name +
				"'s national animal is the " + this.animal + ", which " + this.animalTrait +
				(this.religion != null ? ", its national religion is " + this.religion : "") +
				" and its currency is the " + this.currency + ".";
	}
}