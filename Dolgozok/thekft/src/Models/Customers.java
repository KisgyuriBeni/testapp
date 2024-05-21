package Models;

public class Customers {
    String customer_name;
    String phone_number;

    public Customers(String customer_name, String phone_number) {
        this.customer_name = customer_name;
        this.phone_number = phone_number;
    }

    public String getName() {
        return customer_name;
    }

    public void setName(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    
}
