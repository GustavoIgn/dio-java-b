package br.com.gustavoign.todo_list.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavoign.todo_list.model.Todo;

public interface ITodoRepo extends JpaRepository<Todo, Long> {
	
}
