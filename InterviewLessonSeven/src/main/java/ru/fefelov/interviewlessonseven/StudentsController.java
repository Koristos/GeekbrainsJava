package ru.fefelov.interviewlessonseven;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentsController {

	private final StudentRepo repo;

	@GetMapping
	public List<Student> getAllStudents (){
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public Student getStudentById (@PathVariable Integer id){
		return repo.findById(id).orElse(null);
	}

	@PostMapping
	public Student addStudent (@RequestBody Student student){
		return repo.save(student);
	}

	@RequestMapping
	@DeleteMapping()
	public boolean deleteStudentById (@RequestParam int id) {
		repo.deleteById(id);
		return true;
	}

	@PutMapping
	public boolean updateStudent (@RequestBody Student student){
		if (repo.existsById(student.getId())){
			repo.save(student);
			return true;
		}
		return false;
	}

}
