package homework;



import java.util.AbstractMap;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Comparator.comparing;
public class CustomerService {

    private final TreeMap<Customer, String> customerToMap = new TreeMap<>(comparing(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {

        return copyOf(customerToMap.firstEntry());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return copyOf(customerToMap.higherEntry(customer));
    }

    public void add(Customer customer, String data) {
        customerToMap.put(customer, data);
    }

    private Map.Entry<Customer, String> copyOf(Map.Entry<Customer, String> customerStringEntry) {
        if (customerStringEntry == null) {
            return null;
        }
        var validCustomer = customerStringEntry.getKey();
        var copyOfCustomer = new Customer(validCustomer.getId(), validCustomer.getName(), validCustomer.getScores());
        return new AbstractMap.SimpleImmutableEntry<>(copyOfCustomer, customerStringEntry.getValue());
    }
}
