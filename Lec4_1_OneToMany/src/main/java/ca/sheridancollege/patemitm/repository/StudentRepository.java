package ca.sheridancollege.patemitm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.patemitm.beans.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	public Student findByName(String name);
	public List<Student> findByAccount_IdIsNotNull();
	
}
