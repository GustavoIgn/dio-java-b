package br.com.gustavoign.todo_list.controller;

import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavoign.todo_list.model.Todo;
import br.com.gustavoign.todo_list.model.Users;
import br.com.gustavoign.todo_list.repo.ITodoRepo;
import br.com.gustavoign.todo_list.repo.IUserRepository;
import br.com.gustavoign.todo_list.request.AddTodoRequest;
import br.com.gustavoign.todo_list.request.AddUserRequest;

@RestController
@RequestMapping("/users")
public class UserController {

	private IUserRepository userRepo;
	private ITodoRepo todoRepo;

	public UserController(IUserRepository userRepository, ITodoRepo todoRepository) {
		this.userRepo = userRepository;
		this.todoRepo = todoRepository;
	}

	@GetMapping("/{userId}")
	public Users getUserById(@PathVariable Long userId) {
		return userRepo.findById(userId).orElseThrow(() -> new NoSuchElementException());
	}

	@PostMapping
	public Users addUser(@RequestBody AddUserRequest userRequest) {
		Users users = new Users();
		users.setUserName(userRequest.getUsername());
		users.setPassword(userRequest.getPassword());
		return userRepo.save(users);
	}

	@PostMapping("/{userId}/todos")
	public void addTodo(@PathVariable Long userId, @RequestBody AddTodoRequest todoRequest) {
		Users users = userRepo.findById(userId).orElseThrow(() -> new NoSuchElementException());
		Todo todo = new Todo();
		todo.setContent(todoRequest.getContent());
		users.getTodoList().add(todo);
		userRepo.save(users);
	}

	@PostMapping("/todos/{todoId}")
	public void toggleTodoCompleted(@PathVariable Long todoId) {
		Todo todo = todoRepo.findById(todoId).orElseThrow(() -> new NoSuchElementException());
		todo.setCompleted(!todo.getCompleted());
		todoRepo.save(todo);
	}

	@DeleteMapping("{userId}/todos/{todoId}")
	public void deleteTodo(@PathVariable Long userId, @PathVariable Long todoId) {
		Users users = userRepo.findById(userId).orElseThrow(() -> new NoSuchElementException());
		Todo todo = todoRepo.findById(todoId).orElseThrow(() -> new NoSuchElementException());
		users.getTodoList().remove(todo);
		todoRepo.delete(todo);
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		Users users = userRepo.findById(userId).orElseThrow(() -> new NoSuchElementException());
		userRepo.delete(users);
	}

}