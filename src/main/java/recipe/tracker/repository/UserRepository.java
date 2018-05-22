package recipe.tracker.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import recipe.tracker.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, String> {
	public List<User> findAllByOrderByUserName();
	public User findByUserName(String userName);
	public User findByUserEmail(String email);
}