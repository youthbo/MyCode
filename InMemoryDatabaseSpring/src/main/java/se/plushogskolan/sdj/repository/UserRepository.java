package se.plushogskolan.sdj.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import se.plushogskolan.sdj.model.User;

public interface UserRepository extends PagingAndSortingRepository<User,Long> {
}
