/*
 * Copyright (c) 2013 Afforess
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

import java.util.Collections;
import java.util.Map;

import com.limewoodMedia.nsapi.enums.IArguments;
import com.limewoodMedia.nsapi.enums.IShards;

public class HappeningData {
	public EventHappening[] happenings;

	public static enum View {
		REGION,
		NATION
	}

	public static final class ViewType {
		public final View view;
		public final String name;
		public ViewType(View view, String name) {
			this.view = view;
			this.name = name;
		}

		@Override
		public String toString() {
			return "view=" + view.name().toLowerCase() + "." + name.toLowerCase().replaceAll(" ", "_");
		}
	}

	public static enum Filter implements IShards {
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

		@Override
		public String getName() {
			return filter;
		}

		@Override
		public Map<IArguments, String> getArguments() {
			return Collections.emptyMap();
		}

		@Override
		public String getTag() {
			return null;
		}
	}

	public static class EventHappening extends Happening {
		public int eventId;

		public EventHappening(long timestamp, String text, int eventId) {
			super(timestamp, text);
			this.eventId = eventId;
		}
	}
}
