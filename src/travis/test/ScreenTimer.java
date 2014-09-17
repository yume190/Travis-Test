package travis.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ScreenTimer {

	private final int ONE_DAY_MINUTES = 60 * 24;
	
	private GregorianCalendar timeToOpenScreen;
	private GregorianCalendar timeToCloseScreen;
	
	private int timeFlagToOpenScreen;
	private int timeFlagToCloseScreen;
	private int timeFlagOffset;
	
	private int getTimeFlag(GregorianCalendar date){
		return date.get(Calendar.HOUR_OF_DAY) * 60 + date.get(Calendar.MINUTE);
	}
	
	private int getOffsetTimeFlag(int timeFlag){
		return (timeFlag - this.timeFlagOffset + ONE_DAY_MINUTES) % ONE_DAY_MINUTES; 
	}
	
	public boolean isTimeToOpenScreen(GregorianCalendar date){
		return isTimeToOpenScreen(getOffsetTimeFlag(getTimeFlag(date)));
	}
	
	public boolean isTimeToOpenScreen(int offsetTimeFlag){
//		if (timeFlagToOpenScreen == timeFlagToCloseScreen){
//			return true;
//		}
		
		if (offsetTimeFlag < timeFlagToCloseScreen && 0 <= offsetTimeFlag){
			return true;
		}
		return false;
	}
	
	public boolean isTimeToCloseScreen(GregorianCalendar date){
		return isTimeToCloseScreen(getOffsetTimeFlag(getTimeFlag(date)));
	}
	
	public boolean isTimeToCloseScreen(int offsetTimeFlag){
//		if (timeFlagToOpenScreen == timeFlagToCloseScreen){
//			return false;
//		}
		
		if (offsetTimeFlag < ONE_DAY_MINUTES && timeFlagToCloseScreen <= offsetTimeFlag){
			return true;
		}
		return false;
	}
	
	public ScreenTimer(GregorianCalendar timeToOpenScreen, GregorianCalendar timeToCloseScreen){
		this.timeToOpenScreen = timeToOpenScreen;
		this.timeToCloseScreen = timeToCloseScreen;	
		
		initTimeFlags();
	}
	
	private void initTimeFlags(){
		this.timeFlagToOpenScreen = getTimeFlag(timeToOpenScreen);
		this.timeFlagToCloseScreen = getTimeFlag(timeToCloseScreen);
		
		this.timeFlagOffset = this.timeFlagToOpenScreen;
		
		this.timeFlagToOpenScreen = getOffsetTimeFlag(timeFlagToOpenScreen);
		this.timeFlagToCloseScreen = getOffsetTimeFlag(timeFlagToCloseScreen);
		
		if (timeFlagToOpenScreen == timeFlagToCloseScreen){
			timeFlagToCloseScreen = ONE_DAY_MINUTES;
		}
	}
	
}
