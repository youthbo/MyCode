package se.plushogskolan.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import se.plushogskolan.model.Customer;
import se.plushogskolan.repository.CustomerRepository;

@Component
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public void createCustomer(Customer customer) {
		repository.add(customer);
	}

	public void updateCustomer(Long id, Customer customer) {
		if (repository.get(id) != null)
			repository.update(id, customer);
	}

	public void deleteCustomer(Long id) {
		repository.delete(id);
	}

	public Customer get(Long id) {
		return repository.get(id);
	}

	public List<Customer> getCustomers(int page, int size,String sort) {
		List<Customer> customers = repository.getAll();
		List<Customer> result = new ArrayList<>();
		if (customers.size() > page * size){
			
		   if (customers.size() < page * size + size) {
			 for (int i = page * size; i < customers.size(); i++) {
				result.add(customers.get(i));
			 }
		  } else {
			 for (int i = page * size; i < page * size + size; i++) {
				result.add(customers.get(i));
			 }
		}
		}
		result.sort(Comparator.comparing(Customer::getId));
		if (sort.equals("desc")){
			Collections.reverse(result);
			return result;
		}else {
		    return result;
		}
	}
}
