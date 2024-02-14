class Customer
{
    private String customerId;
    private String name;

    Customer(String name,String customerId)
    {
        this.name=name;
        this.customerId=customerId;
    }

    public String getname()
    {
        return name;
    }
    public String getcustomerId()
    {
        return customerId;
    }
}