import java.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private double balance;


    public Customer(int id, String firstName, String lastName, double balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "Customer [ID=" + id + ", First Name=" + firstName + ", Last Name=" + lastName + ", Balance=" + balance + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Double.compare(customer.balance, balance) == 0 &&
                Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, balance);
    }
}



public class application
{
    public static void main(String[] args) {
        // Create a List of Customers
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(3, "Aditya", "Kumar", 2500.50));
        customers.add(new Customer(1, "Ajay", "M", 1800.75));
        customers.add(new Customer(2, "Ayush", "Singh", 3000.00));
        customers.add(new Customer(4, "Alex", " ", 1500.25));

        System.out.println("Before Sorting:");
        customers.forEach(System.out::println);


        customers.sort(Comparator
                .comparing(Customer::getFirstName)
                .thenComparing(Customer::getLastName)
                .thenComparingInt(Customer::getId)
                .thenComparingDouble(Customer::getBalance));

        System.out.println("\nAfter Sorting:");
        customers.forEach(System.out::println);
    }
}
