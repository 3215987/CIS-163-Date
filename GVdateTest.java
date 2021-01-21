
/**
 * Write a description of class GVdateTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GVdateTest
{
    public static void main (String []  args) {
        System.out.println ("Testing begings");

        //********** phase 1 testing ************

        // testing the default constructor 
        GVdate today = new GVdate();
        assert today.getMonth() == 10 : "month should be 10";   
        assert today.getDay() == 12 : "day should be 12";  
        assert today.getYear() == 2020 : "year should be 2020";  

        // testing constructor 2
        GVdate theDay = new GVdate(1, 10, 1995);
        assert theDay.getMonth() == 1 : "month should be 1";   
        assert theDay.getDay() == 10 : "day should be 10";  
        assert theDay.getYear() == 1995 : "year should be 1995"; 
        
        // testing setter methods 
        //testing setMonth
        today.setMonth(8);
        today.setDay(29);
        today.setYear(1917);
        //final tests:
        assert today.getMonth() == 8 : "month should be 8";
        assert today.getDay() == 29 : "day should be 29";
        assert today.getYear() == 1917 : "year should be 1917";
        
        assert today.toString().equals("8/29/1917") : "toString is messed up, man";
        //testing toString
        
        //testing third constructor
        GVdate constructor3 = new GVdate("10/01/1");
        assert constructor3.getMonth() == 10 : "month should be 10" + constructor3.getMonth();   
        assert constructor3.getDay() == 1 : "day should be 1";  
        assert constructor3.getYear() == 1 : "year should be 1";
        
        //testing isLeapYear
        assert constructor3.isLeapYear(constructor3.getYear()) == false : "not a leap year";
        constructor3.setYear(2000);
        assert constructor3.isLeapYear(constructor3.getYear()) == true : "is a leap year";
        constructor3.setYear(1900);
        assert constructor3.isLeapYear(constructor3.getYear()) == false : "not a leap year";
        
        //testing invalid dates
        GVdate invalid = new GVdate(-1, 1, 1);
        
        assert invalid.getMonth() == 10 : "month should be 10";
        assert invalid.getDay() == 12 : "day should be 12";
        assert invalid.getYear() == 2020 : "year should be 2020";
        
        invalid.setMonth(13);
        invalid.setMonth(0);
        invalid.setDay(0);
        invalid.setDay(32);
        invalid.setYear(0);
        
        assert invalid.getMonth() == 10 : "month should be 10";
        assert invalid.getDay() == 12 : "day should be 12";
        assert invalid.getYear() == 2020 : "year should be 2020";
        
        GVdate skipMethods = new GVdate(1, 1, 2010);
        
        skipMethods.nextDay();
        assert skipMethods.getDay() == 2 : "next day method is wrong";
        skipMethods.skipAhead(366);
        assert skipMethods.toString().equals("1/3/2011") : "skip ahead is wrong";
        assert skipMethods.isLeapYear(skipMethods.getYear()) == false : "not a leap year";
        skipMethods.setYear(2016);
        assert skipMethods.isLeapYear(skipMethods.getYear()) == true : "is a leap year";
        assert skipMethods.isMyBirthday() == false : "not my b day";
        skipMethods.setDate(5, 16, 2002);
        assert skipMethods.isMyBirthday() == true : "my birthday!";
        
        GVdate equalsTest = new GVdate(5, 16, 2002);
        
        assert skipMethods.equals(equalsTest) == true : "dates should be equal";
        equalsTest.nextDay();
        assert skipMethods.equals(equalsTest) == false : "dates should NOT be equal";
        
        skipMethods.setDate(1, 1, 2000);
        
        assert skipMethods.toString(1).equals("1/1/2000") : "format 1 broke";
        assert skipMethods.toString(2).equals("01/01/2000") : "format 2 broke";
        assert skipMethods.toString(3).equals("Jan 01, 2000") : "format 3 broke";
        assert skipMethods.toString(4).equals("January 1, 2000") : "format 4 broke";
        
        System.out.println ("Testing ends");
    }  

    /*public static void main (String []  args) {
        int errors = 0;
        System.out.println ("Testing begings");

        //********** phase 1 testing ************

        // testing the default constructor 
        GVdate today = new GVdate();
        assert today.getMonth() == 10 : "month should be 10";
        assert today.getDay() == 12 : "day should be 12";  
        assert today.getYear() == 2020 : "year should be 2020";  

        

    

        // testing constructor 2
        GVdate theDay = new GVdate(1, 10, 1995);
        // TO DO: complete the checks for month, day and year

        // testing setter methods 
        //testing setMonth
        theDay.setMonth(8);
        // TO DO: complete the code to check for month
        // TO DO: finish testing setDay and setYear
        // TO DO: test the toString method

        System.out.println("Errors: " + errors);
        System.out.println ("Testing ends");
    }  */

}
