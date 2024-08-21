package br.com.gustavoign.todo_list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gustavoign.todo_list.model.Todo;
import br.com.gustavoign.todo_list.model.Users;
import br.com.gustavoign.todo_list.repo.ITodoRepo;
import br.com.gustavoign.todo_list.repo.IUserRepository;

@SpringBootApplication
public class TodoListApplication implements CommandLineRunner{
	
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private ITodoRepo todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Users users = new Users();
		users.setPassword("should be hashed");
		users.setUserName("Gustavo");
		
		Todo todoItem = new Todo();
		todoItem.setContent("Concluir o BootCamp");
		
		users.getTodoList().add(todoItem);
		
		todoRepository.save(todoItem);
		userRepository.save(users);
	}

}
