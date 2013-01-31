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
package com.limewoodMedia.nsapi;

import com.limewoodMedia.nsapi.exceptions.RateLimitReachedException;
import com.limewoodMedia.nsapi.exceptions.UnknownNationException;
import com.limewoodMedia.nsapi.exceptions.UnknownRegionException;
import com.limewoodMedia.nsapi.holders.NationData;
import com.limewoodMedia.nsapi.holders.RegionData;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/**
 * Interface for Java API for NationStates API
 * @author Joakim Lindskog
 *
 */
public interface INSAPI {
	/**
	 * Sets the User-Agent header
	 * Note: this needs to be set to be able to access the API
	 * @param userAgent the User-Agent string to use
	 */
	public void setUserAgent(String userAgent);
	
	/**
	 * @return the User-Agent
	 */
	public String getUserAgent();

	/**
	 * Sets version of the NationStates API to use
	 * @param version the version of the NS API to use
	 */
	public void setVersion(int version);
	
	/**
	 * @return the currently used version
	 */
	public int getVersion();
	
	/**
	 * Set whether to use Apache HttpClient or URLConnection
	 * @param true for HttpClient, false for URLConnection
	 */
	public void setUseHttpClient(boolean b);

	public NationData getNationInfo(String name, NationData.Shards...arguments)
			throws XmlPullParserException, IOException, RateLimitReachedException, UnknownNationException;

	public RegionData getRegionInfo(String name, RegionData.Shards...arguments)
			throws XmlPullParserException, IOException, RateLimitReachedException, UnknownRegionException;
}