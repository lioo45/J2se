package com.myRsCrawler;

public class LinkOfferImpl implements LinkOffer{

	@Override
	public String getLink(String link) {
		String s=link.substring(link.lastIndexOf("forum.php?"));
		s=s.substring(0,s.lastIndexOf("onclick")-2);
		s=s.replaceAll("&amp;", "&");
		return s;
	}

}
