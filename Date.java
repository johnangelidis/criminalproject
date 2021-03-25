public class Date {
    private String month;
    private int day;
    private int year;

    public Date(String m, int d, int y){
        this.month = m;
        this.day = d;
        this.year = y;
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString(){
        String newDay = Integer.toString(day);
        String newYear = Integer.toString(year);

        return month + " " + newDay + ", " + newYear;
        
    }
}
