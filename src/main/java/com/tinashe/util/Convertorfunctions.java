package com.tinashe.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Convertorfunctions {
	
	public long turndatestoday(Date checkin , Date checkout)
	{
		long dif = checkout.getTime() - checkin.getTime();
		long name = TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS); 
		return name; 
	}

}
