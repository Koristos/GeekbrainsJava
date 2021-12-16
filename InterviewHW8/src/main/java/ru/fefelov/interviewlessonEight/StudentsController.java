package ru.fefelov.interviewlessonEight;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentsController {

	private final StudentRepo repo;

	@GetMapping("/all")
	public List<Student> getAllStudents (){
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public Student getStudentById (@PathVariable Integer id){
		Student student = repo.findById(id).orElse(null);
		if (student == null){
			throw new NotFoundException("Студент не найден");
		}
		return student;
	}

	@PostMapping("/add")
	public Student addStudent (@RequestBody Student student){
		student.setId(null);
		return repo.save(student);
	}

	@DeleteMapping("/delete")
	public boolean deleteStudentById (@RequestParam int id) {
		if (repo.existsById(id)){
			repo.deleteById(id);
			return true;
		}
		throw new NotFoundException("Студент не найден");
	}

	@PutMapping("/update")
	public boolean updateStudent (@RequestBody Student student){
		if (repo.existsById(student.getId())){
			repo.save(student);
			return true;
		}
		throw new NotFoundException("Студент не найден");
	}

	@ExceptionHandler
	public ResponseEntity<Void> handleNotFoundException(NotFoundException ex) {
		return ResponseEntity.notFound().build();
	}

}
