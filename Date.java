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

    public Date splitDate(String date){
        String[] splitDate = date.split("/");

        String month = splitDate[0];
        int day = Integer.parseInt(splitDate[1]);
        int year = Integer.parseInt(splitDate[2]);

        Date newDate = new Date(month,day,year);
        return newDate;
    }
}
