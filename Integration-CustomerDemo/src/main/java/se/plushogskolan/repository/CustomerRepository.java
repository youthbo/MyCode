package se.plushogskolan.repository;

import java.util.List;

import se.plushogskolan.model.Customer;

public interface CustomerRepository {
         public void add(Customer customer);
         public void update(Long id,Customer customer);
         public void delete(Long id);
         public Customer get(Long id);
         public List<Customer> getAll();
}
