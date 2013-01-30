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

/**
 * An enum listing the nation categories with descriptions
 * @author Joakim Lindskog
 *
 */
public enum Categories {
	LEFT_WING_UTOPIA("Left-wing Utopia", "are free to do what they want with their own bodies, and vote for whoever they like in elections; if they go into business, however, they are regulated to within an inch of their lives"),
	CIVIL_RIGHTS_LOVEFEST("Civil Rights Lovefest", "hold their civil and political rights very dear, although the wealthy and those in business tend to be viewed with suspicion"),
	ANARCHY("Anarchy", "live in a state of perpetual fear, as a complete breakdown of social order has led to the rise of order through biker gangs"),
	SCANDINAVIAN_LIBERAL_PARADISE("Scandinavian Liberal Paradise", "enjoy extensive civil rights and enjoy a level of social equality free from the usual accompanying government corruption"),
	LEFT_LEANING_COLLEGE_STATE("Left-Leaning College State", "enjoy extensive civil freedoms, particularly in social issues, while business tends to be more regulated"),
	CAPITALIZT("Capitalizt", "enjoy some of the most opulent lifestyles in the region, unless they are unemployed or working-class, in which case they are variously starving to death or crippled by easily preventable diseases"),
	IRON_FIST_SOCIALISTS("Iron Fist Socialists", "are ruled with an iron fist by the socialist government, which grants its people the freedom to do whatever they like so long as it doesn't involve getting richer than anybody else or challenging the government"),
	LIBERTARIAN_POLICE_STATE("Libertarian Police State", "are proud of their wide-ranging civil freedoms, and those who aren't tend to be dragged off the streets by men in dark suits and hustled into cars with tinted windows"),
	BENEVOLENT_DICTATORSHIP("Benevolent Dictatorship", "enjoy great individual freedoms in everything except elections, which, where they exist at all, are populist shams for a dictatorship government that has no intention of ever giving up power"),
	LIBERAL_DEMOCRATIC_SOCIALISTS("Liberal Democratic Socialists", "love a good election, and the government gives them plenty of them. Universities tend to be full of students debating the merits of various civil and political rights, while businesses are tightly regulated and the wealthy viewed with suspicion"),
	NEW_YORK_TIMES_DEMOCRACY("New York Times Democracy", "enjoy a sensible mix of personal and economic freedoms, while the political process is open and the people's right to vote held sacrosanct"),
	CORPORATE_BORDELLO("Corporate Bordello", "are effectively ruled by a group of massive corporations, who run for political office and provide their well-off citizens with world-class goods and services. Their poorer citizens, however, are mostly starving to death while being urged to go out and get real jobs. The populace has reasonably extensive civil rights, although these are mostly aimed at allowing them to buy whatever they like"),
	DEMOCRATIC_SOCIALISTS("Democratic Socialists", "are fiercely patriotic and enjoy great social equality; they tend to view other, more capitalist countries as somewhat immoral and corrupt"),
	INOFFENSIVE_CENTRIST_DEMOCRACY("Inoffensive Centrist Democracy", "have some civil rights, but not too many, enjoy the freedom to spend their money however they like, to a point, and take part in free and open elections, although not too often"),
	CAPITALIST_PARADISE("Capitalist Paradise", "are either ruled by a sleek, efficient government or a conglomerate of multinational corporations; it's difficult to tell which"),
	CORRUPT_DICTATORSHIP("Corrupt Dictatorship", "are ruled with an iron fist by the dictatorship government, which ensures that no-one outside the party gets too rich. In their personal lives, however, citizens are relatively unoppressed; it remains to be seen whether this is because the government genuinely cares about its people, or if it hasn't gotten around to stamping out civil rights yet"),
	FATHER_KNOWS_BEST_STATE("Father Knows Best State", "are ruled by a mostly-benevolent dictator, who grants the populace the freedom to live their own lives but watches carefully for anyone to slip up"),
	MOTHER_KNOWS_BEST_STATE("Mother Knows Best State", "are ruled by a mostly-benevolent dictator, who grants the populace the freedom to live their own lives but watches carefully for anyone to slip up"),
	COMPULSORY_CONSUMERIST_STATE("Compulsory Consumerist State", "are rabid consumers, partly through choice and partly because the government tells them to and dissenters tend to vanish from their homes at night"),
	TYRANNY_BY_MAJORITY("Tyranny By Majority", "enjoy great social freedoms and frequent elections, where the majority of the populace regularly votes to increase its benefits at the expense of various hapless minorities"),
	CONSERVATIVE_DEMOCRACY("Conservative Democracy", "are known throughout the region for their efficiency and work ethic, as well as their general suspicion of leisure"),
	FREE_MARKET_PARADISE("Free-Market Paradise", "enjoy frequent elections, which are uniformly corrupted by big-spending corporations buying politicians who best suit their interests"),
	AUTHORITARIAN_DEMOCRACY("Authoritarian Democracy", "are prohibited from doing almost everything except voting, which they do timidly and conservatively"),
	MORALISTIC_DEMOCRACY("Moralistic Democracy", "are highly moralistic and fiercely conservative, in the sense that they tend to believe most things should be outlawed. People who have good jobs and work quietly at them are lauded; others are viewed with suspicion"),
	RIGHT_WING_UTOPIA("Right-wing Utopia", "are free to succeed or fail in life on their own merits; the successful tend to enjoy an opulent (but moralistic) lifestyle, while the failures can be seen crowding out most jails"),
	PSYCHOTIC_DICTATORSHIP("Psychotic Dictatorship", "are ruled without fear or favor by a psychotic dictator, who outlaws just about everything and refers to the populace as \"my little playthings\""),
	IRON_FIST_CONSUMERISTS("Iron Fist Consumerists", "are kept under strict control by the oppressive government, which measures its success by the nation's GDP and refers to individual citizens as \"human resources\""),
	CORPORATE_POLICE_STATE("Corporate Police State", "are ruled with an iron fist by the corrupt, dictatorship government, which oppresses anyone who isn't on the board of a Fortune 500 company. Large corporations tend to be above the law, and use their financial clout to gain ever-increasing government benefits at the expense of the poor and unemployed"),
	UNKNOWN("Unknown", "do something that breaks this app (please notify the app maker about this and what category your nation is in)");

	private String name;
	private String description;

	public static Categories parse(String name) {
		for (Categories c : values()) {
			if (c.name.equalsIgnoreCase(name)) {
				return c;
			}
		}
		return UNKNOWN;
	}

	private Categories(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}
}