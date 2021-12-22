package com.postgres_connection.student;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return  studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken......");
        }
        else
        {
            studentRepository.save(student);
        }
    }

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);

        if(!exists){
            throw new IllegalStateException("student with id "+id+" does not exists");
        }
        else{
            studentRepository.deleteById(id);
        }
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student s=studentRepository.findById(id).orElseThrow(()->new IllegalStateException(
                "student with "+id+" doesnt exist"
        ));

        System.out.println("id is "+id+" name is "+name+ " email is "+email);
        if(name!=null && !Objects.equals(s.getName(),name) && name.length()>0 ){
            s.setName(name);
        }
        if(email!=null && email.length()>0 &&  !Objects.equals( s.getEmail(),email) )
        {
            Optional<Student> studentOptoinal = studentRepository.findStudentByEmail(email);
            if (studentOptoinal.isPresent()){
                throw  new IllegalStateException("email you want to change is already taken");
            }
            s.setEmail(email);
        }

    }
}
