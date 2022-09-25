package com.infoway.daos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.infoway.models.entities.User;

public interface UserDao  extends JpaRepository<User , Integer>{
	User findByEmail(String email);
	List<User> findByRole(String role);

    User findByAuthToken(String apiToken);
}
