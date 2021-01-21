
/**
 * Write a description of class GVDate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.text.DecimalFormat;
public class GVdate
{
    private int month;
    private int day;
    private int year;

    private final int MONTH = 1;
    private final int DAY = 9;

    /**
     * Constructor for objects of class GVDate
     */
    public GVdate()
    {
        month = 10;
        day = 12;
        year = 2020;

    }

    public GVdate( int month, int day, int year )
    {
        this.month = month;
        this.day = day;
        this.year = year;

        if(!(this.isValidDate(month, day, year))){
            this.month = 10;
            this.day = 12;
            this.year = 2020;
        }
    }

    public GVdate(String date) {
        int firstSlash = date.indexOf("/");
        int secondSlash = date.indexOf("/", firstSlash + 1);

        int m = Integer.parseInt(date.substring(0, firstSlash));
        int d = Integer.parseInt(date.substring(firstSlash + 1, secondSlash));
        int y = Integer.parseInt(date.substring(secondSlash + 1));

        if(this.isValidDate(m, d, y)){
            this.month = m;
            this.day = d;
            this.year = y;
        } else {
            this.month = 10;
            this.day = 12;
            this.year = 2020;
        }
    }

    public int getMonth()
    {
        return month;
    }

    public int getDay()
    {
        return day;
    }

    public int getYear()
    {
        return year;
    }

    public String toString()
    {
        return this.getMonth() + "/" + this.getDay() + "/" + this.getYear();
    }

    public String toString(int format) {
        DecimalFormat twoDigs = new DecimalFormat("00");
        DecimalFormat fourDigs = new DecimalFormat("0000");

        switch(format) {
            case 1:
            return this.toString();
            case 2:
            String month = twoDigs.format(this.month);
            String day = twoDigs.format(this.day);
            String year = fourDigs.format(this.year);

            return month + "/" + day + "/" + year;
            case 3:
            String monthsAsShortText = "JanFebMarAprMayJunJulAugSepOctNovDec";
            String monthOfDate = monthsAsShortText.substring(((this.month - 1) * 3), ((this.month - 1) * 3 + 3));
            return monthOfDate + " " + twoDigs.format(this.day) + ", " + fourDigs.format(this.year);
            case 4: 
            String monthFullText = "";
            switch(this.month){
                case 1:
                monthFullText = "January";
                break;
                case 2:
                monthFullText = "February";
                break;
                case 3:
                monthFullText = "March";
                break;
                case 4:
                monthFullText = "April";
                break;
                case 5:
                monthFullText = "May";
                break;
                case 6:
                monthFullText = "June";
                break;
                case 7:
                monthFullText = "July";
                break;
                case 8:
                monthFullText = "August";
                break;
                case 9:
                monthFullText = "September";
                break;
                case 10:
                monthFullText = "October";
                break;
                case 11:
                monthFullText = "November";
                break;
                case 12:
                monthFullText = "December";
                break;
            }

            return monthFullText + " " + this.day + ", " + this.year;
        }
        return "ERROR: programmer screwed up here";
    }

    public boolean isMyBirthday()
    {
        if(this.toString().equals("5/16/2002")){
            return true;
        } else {
            return false;
        }
    }

    public boolean isLeapYear(int y){
        if(y % 400 == 0){
            return true;
        } else if ((y % 4 == 0) && (y % 100 != 0)){
            return true;
        } else {
            return false;
        }
    }

    public void setMonth( int m )
    {
        if(this.isValidDate(m, this.day, this.year)){
            this.month = m;
        } else {
            System.out.println("InvalidDate: " + m + "/" + this.day + "/" + this.year);
        }
    }

    public void setDay( int d )
    {
        if(this.isValidDate(this.month, d, this.year)){
            this.day = d;
        } else {
            System.out.println("InvalidDate: " + this.month + "/" + d + "/" + this.year);
        }
    }

    public void setYear( int y)
    {
        if(this.isValidDate(this.month, this.day, y)){
            this.year = y;
        } else {
            System.out.println("InvalidDate: " + this.month + "/" + this.day + "/" + y);
        }
    }

    public void setDate (int m, int d, int y)  
    {

        if(this.isValidDate(m, d, y)){
            this.month = m;
            this.day = d;
            this.year = y;
        } else {
            System.out.println("InvalidDate: " + m + "/" + d + "/" + y);
        }
    }

    private int getLastDayOfMonth(int m, int y){
        switch(m){
            case 1:
            return 31;
            case 2:
            if(this.isLeapYear(y)){
                return 29;
            } else {
                return 28;
            }
            case 3:
            return 31;
            case 4:
            return 30;
            case 5:
            return 31;
            case 6:
            return 30;
            case 7:
            return 31;
            case 8:
            return 31;
            case 9:
            return 30;
            case 10:
            return 31;
            case 11:
            return 30;
            case 12:
            return 31;
        }

        return -1;   // should never happen
    }

    private boolean isValidDate(int m, int d, int y) {
        if(y > 0){
            if(m > 0 && m < 13){
                if(d > 0 && d <= this.getLastDayOfMonth(m, y)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean equals(GVdate otherDate){
        if(this.month == otherDate.getMonth()){
            if(this.day == otherDate.getDay()){
                if(this.year == otherDate.getYear()){
                    return true;
                }
            }
        }
        return false;
    }

    public void nextDay(){
        this.day = (this.day % this.getLastDayOfMonth(this.month, this.year)) + 1;
        if(this.day == 1){
            this.nextMonth();
        }
    }

    public void nextMonth(){
        this.month = (this.month % 12) + 1;
        if(this.month == 1){
            this.nextYear();
        }
    }

    public void nextYear(){
        this.year++;
    }

    public void skipAhead(int numDays){
        if(numDays > 0){
            for(int i = 0; i < numDays; i++){
                this.nextDay();
            }
        }
    }
}
