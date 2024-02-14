//-----------------------------------------------------------------------------------
class Rental 
{
  private Car car;  // here Car is warking as a data type because we have created one class name Car 
  private Customer customer; // here also we have created one class name Customer
  private int days;

  Rental(Car car,Customer customer,int days)
  {
    this.car= car;
    this.customer=customer;
    this.days=days;
  }
  public Car getcar()
  {
    return car;
  }

  public Customer getcustomer()
  {
    return customer;
  }

  public int getdays()
  {
    return days;
  }
}
//-------------------------------------------------------------------------------
