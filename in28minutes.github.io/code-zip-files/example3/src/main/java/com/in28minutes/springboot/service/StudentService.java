package com.in28minutes.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private static final List<Student> students = new ArrayList<>();

    static {
        // Initialize Data
        Course course1 = new Course("Course1", "Spring", "10 Steps",
                Arrays.asList("Learn Maven", "Import Project", "First Example",
                        "Second Example"));
        Course course2 = new Course("Course2", "Spring MVC", "10 Examples",
                Arrays.asList("Learn Maven", "Import Project", "First Example",
                        "Second Example"));

        Student ranga = new Student("Student1", "Ranga Karanam",
                "Hiker, Programmer and Architect", new ArrayList<>(
                Arrays.asList(course1, course2)));

        students.add(ranga);
    }

	public List<Course> retrieveCourses(String studentId) {
		Student student = retrieveStudent(studentId);

		return student == null ? null : student.getCourses();
	}

	public Student retrieveStudent(String studentId) {
		for (Student student : students) {
			if (student.getId().equals(studentId)) {
				return student;
			}
		}
		return null;
	}
}