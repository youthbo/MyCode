package se.plushogskolan.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import se.plushogskolan.model.Customer;

@Component
public class InMemoryCustomerRepository implements CustomerRepository {

	public static HashMap<Long,Customer> customers = new HashMap<>();
	AtomicLong id = new AtomicLong(1000);
	
	@Override
	public void add(Customer customer) {
		customers.put(id.incrementAndGet(), customer);
		
	}

	@Override
	public void update(Long id,Customer customer) {	
			customers.put(id, customer);
		
		
	}

	@Override
	public void delete(Long id) {
		customers.remove(id);
		
	}

	@Override
	public Customer get(Long id) {
			return customers.get(id);

	}

	@Override
	public List<Customer> getAll() {
		List<Customer> list = new ArrayList<>();
		for (Customer customer : customers.values()) {
			list.add(customer);
		}
		return list;
	}

	

}
