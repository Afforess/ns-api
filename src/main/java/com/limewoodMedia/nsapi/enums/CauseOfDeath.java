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
 * An enum of the causes of death in a nation
 * @author Joakim Lindskog
 *
 */
public enum CauseOfDeath {
	OLD_AGE("Old Age"),
	HEART_DISEASE("Heart Disease"),
	MURDER("Murder"),
	CAPITAL_PUNISHMENT("Capital Punishment"),
	EXPOSURE("Exposure"),
	LOST_IN_WILDERNESS("Lost in Wilderness"),
	ANIMAL_ATTACK("Animal Attack"),
	ACTS_OF_GOD("Acts of God"),
	CANCER("Cancer"),
	WAR("War"),
	SUICIDE_WHILE_IN_POLICE_CUSTODY("Suicide While in Police Custody"),
	VAT_LEAKAGE("Vat Leakage"),
	DISAPPEARANCE("Disappearance"),
	WORK("Work"),
	RITUAL_SACRIFICE("Ritual Sacrifice"),
	ACCIDENT("Accident"),
	INVOLUNTARY_EUTHANASIA("Involuntary Euthanasia"),
	MALNOURISHMENT("Malnourishment"),
	SCURVY("Scurvy"),
	NUCLEAR_SPILL("Nuclear Spill");

	private String description;

	public static CauseOfDeath parse(String name) {
		for (CauseOfDeath c : values()) {
			if (c.description.equalsIgnoreCase(name)) {
				return c;
			}
		}
		return null;
	}

	private CauseOfDeath(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}
}