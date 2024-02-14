import java.util.*;

class car_rental_system
{
    private  List <Car> cars;
    private List<Customer>customers;
    private List<Rental>rentals;

    car_rental_system()
    {
        cars=new ArrayList<>();
        customers = new ArrayList<>();
        rentals= new ArrayList<>();
    }
    public void addcar(Car car)
    {
        cars.add(car);
    }
    public void addcustomer(Customer customer)
    {
        customers.add(customer);
    }

    public void rentCar(Car car,Customer customer, int days)
    {
        if(car.getisAvailable())
        {
            car.rent();
            rentals.add(new Rental(car,customer,days));
        }
        else
        {
            System.out.println("car is not available for rent");
        }
    }
    public void returnCar(Car car)
    {
        //car.returnCar();
        Rental rentalToRemove=null;
        Customer customer = null;
        for(Rental rental:rentals)
        {
            if(rental.getcar()==car)
            {
                rentalToRemove=rental;
                customer = rental.getcustomer();
                break; // Break out of the loop once the correct rental is found
            }
        }
        if (rentalToRemove != null) {
           // car.returnCar(); // Call the returnCar method on the car
            rentals.remove(rentalToRemove);
            System.out.println("Car returned successfully by " + customer.getname());
        } else {
            System.out.println("Car was not rented.");
        }
    }
    public  void menu()
    {
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.println("=====car rent system====");
            System.out.println("1. Rent a car ");
            System.out.println("2. return a car ");
            System.out.println("3. Exit" );
            System.out.println("enter your choice ");
            int choice=scanner.nextInt();
             scanner.nextLine(); //consume newline

            if(choice==1)
            {
                System.out.println("\n==Rent a car ==\n");
                System.out.println("enter your name:");
                String customerName =scanner.nextLine();

                System.out.println("\n Available Cars:");
                for(Car car : cars)
                {
                    if(car.getisAvailable())
                    {
                        System.out.println(car.getcarId() +  " - " + car.getbrand() + " - " + car.getmodel());
                    }
                }

                System.out.println("\n Enter the car Id you want to rent");
                String carId = scanner.nextLine();

                System.out.print("enter the number of days for rental ");
                int rentalDays =scanner.nextInt();
                scanner.nextLine();//consume nextline
                Customer newcustomer = new Customer( "cus" + (customers.size() + 1),customerName);

                addcustomer(newcustomer );
                Car selectedCar = null;
                for(Car car : cars)
                {
                    if(car.getcarId().equalsIgnoreCase(carId) && car.getisAvailable())
                    {
                        selectedCar = car;
                        break;
                    }
                }

                if(selectedCar!=null)
                {
                    double totalPrice = selectedCar.calculateRentPrice(rentalDays);
                    System.out.println("\n == rental Information ==\n");
                    System.out.println("customer ID: " + newcustomer.getcustomerId());
                    System.out.println("Customer Name: " + newcustomer.getname());
                    System.out.println("Car: " + selectedCar.getbrand() + " " + selectedCar.getmodel());
                    System.out.println("Rental Days: " + rentalDays);
                    System.out.printf("Total Price: $%.2f%n ",totalPrice);

                    System.out.println("\n confirm rental (Y/N): ");
                    String confirm = scanner.nextLine();

                    if(confirm.equalsIgnoreCase("Y"))
                    {
                        rentCar(selectedCar,newcustomer,rentalDays);
                        System.out.println("\n Car rented Successfully. ");
                    }
                    else
                    {
                        System.out.println("\n Rental canceled.");
                    }
                }
                else{
                    System.out.println("\n Invalid car selection or car available for rent . ");
                }

            }
            else if(choice ==2)
            {
                System.out.println("\n== return a car ==\n");
                System.out.println("Enter the car id you want to return : ");
                String carId=scanner.nextLine();

                Car carToReturn=null;
                for(Car car : cars)
                {
                    if(car.getcarId().equals(carId)&& !car.getisAvailable())
                    {
                        carToReturn = car;
                        break;

                    }
                }
                if(carToReturn != null)
                {
                    Customer customer=null;
                    for(Rental rental : rentals)
                    {
                        customer = rental.getcustomer();
                        break;
                    }
                }
                if(customers!=null)
                {
                    returnCar(carToReturn);
                    System.out.println("Car return Succesfully by " + ((Customer) customers).getname());
                }
                else{ 
                    System.out.println("car was not rented or rental information is missing. ");
                }
            }
            else if(choice ==3)
            {
                break;
            }
            else{
                System.out.println("invalid choice. please enter a valid option .");
            }
        }
        System.out.println("\n Thank you for using the car rental Syatem! ");
    }
       

}

 class main1
{
    public static void main(String args[])
    {
         car_rental_system rentalSystem = new car_rental_system();
         Car car1=new Car("C001","toyota","Camry",60.8);
         Car car2=new Car("C002","mahindra","thar",78.5);
         Car car3=new Car("C003","suzuki","Brizza",150.0);
         Car car4=new Car("C004","Honda","Accord",55.7);
         rentalSystem.addcar(car1);
         rentalSystem.addcar(car2);
         rentalSystem.addcar(car3);
         rentalSystem.addcar(car4);

         rentalSystem.menu();

    }
}