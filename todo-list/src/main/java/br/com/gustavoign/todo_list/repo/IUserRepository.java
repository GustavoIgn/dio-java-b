package br.com.gustavoign.todo_list.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavoign.todo_list.model.Users;

public interface IUserRepository extends JpaRepository<Users, Long>{
	
}
