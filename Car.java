class Car
{
    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;

    public Car(String carId,String brand,String model, double basePriceperDay)
    {
        this.carId=carId;
        this.brand=brand;
        this.model=model;
        this.basePricePerDay=basePriceperDay;
        this.isAvailable=true;
    }
    public String getcarId()
    {
        return carId;
    }
    
    public String getbrand()
    {
        return brand;
    }

    public String getmodel()
    {
        return model;
    }

    public double getbasePricePerDay()
    {
        return basePricePerDay;
    }
    
    public double calculateRentPrice(int rentalDays)
    {
        return basePricePerDay*rentalDays;
    }

    public boolean getisAvailable()
    {
        return isAvailable;
    }
    
    public void rent()
    {
        isAvailable=false;
    }
}
