package com.example.gpstimeconverter;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import android.util.Log;


public class GpsConverter {

    private final int secondsInDay;
    private final int secondsInWeek;
    //https://developer.android.com/reference/java/util/Calendar#public-methods
    // Using Calendar for Android API level 23
    // TODO in future to java.time (LocalDateTime)
    // https://developer.android.com/reference/java/time/package-summary
    // TODO make this an array or LL
    private Calendar gpsEpoch1980;
    private Calendar gpsEpoch1999;
    private Calendar gpsEpoch2019;
    private int epochYear;


    public GpsConverter(){
        secondsInDay = 86400;
        secondsInWeek = 604800;

        // Set default epoch year to 1980
        epochYear = 1980;

        // Set the Epochs
        // https://www.gps.gov/support/user/rollover/
        //  GPS Week Rollover occurs in systems using 10 bits to store the week
        // Thus, every 19.7 years a rollover occurs and a new "epoch" begins.
        // Note the java.util.calendar counts months beginning at 0, representing January
        // Timezones
        // https://www.tutorialspoint.com/get-all-the-ids-of-the-time-zone-in-java
        TimeZone utcTz =  TimeZone.getTimeZone("UTC");
        // 1980: January 6 (Sunday)
        gpsEpoch1980 = Calendar.getInstance();
        gpsEpoch1980.setTimeZone(utcTz);
        gpsEpoch1980.set(1980, 0, 6, 0,0,0);
        // 1999: August 22 (Sunday)
        gpsEpoch1999 = Calendar.getInstance();
        gpsEpoch1999.setTimeZone(utcTz);
        gpsEpoch1999.set(1999, 7, 22, 0,0,0);
        // 2019: April 7 (Sunday)
        gpsEpoch2019 = Calendar.getInstance();
        gpsEpoch2019.setTimeZone(utcTz);
        gpsEpoch2019.set(2019, 3, 7, 0,0,0);

        Log.d("CONSTRUCTOR", "Created GPS Converter");
    }

    // Assumes intended, valid epoch is set
    protected Calendar calculate_utc_from_gps (double gpsWeek, double gpsSecondsOfWeek){
        final Calendar o = null;
        return o;
    }

    protected Calendar calculate_utc_from_gps(int epoch, double gpsWeek, double gpsSecondsOfWeek) {
        setEpochYear(epoch);
        // assumes epoch is valid
        final Calendar calendar = calculate_utc_from_gps(gpsWeek, gpsSecondsOfWeek);
        return calendar;
    }

    protected int getSecondsInDay() {
        return secondsInDay;
    }
    protected int getSecondsInWeek() {
        return secondsInWeek;
    }

    protected Calendar getGpsEpoch(){
        final Calendar gpsEpoch = getGpsEpoch(epochYear);
        return gpsEpoch;
    }

    protected Calendar getGpsEpoch(int eYear){
        switch (eYear) {
            case 1980:
                return gpsEpoch1980;
            case 1999:
                return gpsEpoch1999;
            case 2019:
                return gpsEpoch2019;
            default:
                final Calendar o = null;
                return o;
        }
    }

    public int getEpochYear() {
        return epochYear;
    }

    protected Calendar getGpsEpoch1980() { return gpsEpoch1980; }
    protected Calendar getGpsEpoch1999() { return gpsEpoch1999; }
    protected Calendar getGpsEpoch2019() { return gpsEpoch2019; }

    // TODO Verify valid epoch set
    public void setEpochYear(int epochYear) {
        this.epochYear = epochYear;
    }
}
