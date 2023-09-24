public class Date {
    int day;
    int month;
    int year;

    Date() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    Date(Date otherDate) {
        this.day = otherDate.day;
        this.month = otherDate.month;
        this.year = otherDate.year;
    }

    void printDate() {
        System.out.printf("%02d-%02d-%04d", month, day, year);
    }
}