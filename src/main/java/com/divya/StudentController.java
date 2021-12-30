package com.divya;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/stud")
public class StudentController {
	@Autowired
    private StudentRepository studentRepository;
	@GetMapping("/student")
    public List < Student > getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }
	@PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }
	
	@GetMapping("/student/{sid}")
    public ResponseEntity < Student > getStudentById(@PathVariable Long sid) {
        Student s = studentRepository.findById(sid)
            .orElseThrow(()-> new ResourceNotFoundException("Student not exist with id :" + sid));
        return ResponseEntity.ok(s);
    }
	@PutMapping("/student/{sid}")
    public ResponseEntity < Student > updateStudent(@PathVariable Long sid, @RequestBody Student studentDetails) {
        Student s = studentRepository.findById(sid)
            .orElseThrow(()-> new ResourceNotFoundException("Student not exist with id :" + sid));
        s.setSname(studentDetails.getSname());
        s.setCid(studentDetails.getCid());
        s.setCname(studentDetails.getCname());
        s.setElect(studentDetails.getElect());
        s.setSem(studentDetails.getSem());
        s.setBook_issued(studentDetails.getBook_issued());
        s.setDoi(studentDetails.getDoi());
 
        Student updatedStudent = studentRepository.save(s);
        return ResponseEntity.ok(updatedStudent);
	}
	
	@DeleteMapping("/student/{sid}")
    public ResponseEntity < Map < String, Boolean >> deleteStudent(@PathVariable Long sid) {
        Student s = studentRepository.findById(sid)
            .orElseThrow(()-> new ResourceNotFoundException("Customer not exist with id :" + sid));
 
        studentRepository.delete(s);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
 

}
