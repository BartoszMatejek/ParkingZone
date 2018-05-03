package Implementation;

public class City {

    private String name;
    private double amount;
    private double minimalPrice;
    private double firstHourPrice;
    private double secondHourPrice;
    private double thirdHourPrice;

    public City(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public double countAmount(int hours, int minutes){
        if (hours == 0) {
            amount = amount + (firstHourPrice/60 * minutes);
        } else if (hours == 1) {
            amount = amount + firstHourPrice + (secondHourPrice/60 * minutes);
        } else if (hours == 2) {
            amount = amount + firstHourPrice + secondHourPrice + (thirdHourPrice/60 * minutes);
        } else if (hours == 3) {
            amount = amount + firstHourPrice + secondHourPrice + thirdHourPrice + (firstHourPrice/60 * minutes);
        } else {
            amount = amount + firstHourPrice + secondHourPrice + thirdHourPrice + firstHourPrice * (hours - 3) + (firstHourPrice/60 * minutes);
        }

        if(amount < minimalPrice){
            amount = minimalPrice;
        }

        return amount;
    }

    public void setMinimalPrice(double minimalPrice){
        this.minimalPrice = minimalPrice;
    }

    public void setFirstHourPrice(double firstHourPrice){
        this.firstHourPrice = firstHourPrice;
    }

    public void setSecondHourPrice(double secondHourPrice){
        this.secondHourPrice = secondHourPrice;
    }

    public void setThirdHourPrice(double thirdHourPrice){
        this.thirdHourPrice = thirdHourPrice;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Client should pay:" + amount + " pln");

        return stringBuilder.toString();
    }
}
