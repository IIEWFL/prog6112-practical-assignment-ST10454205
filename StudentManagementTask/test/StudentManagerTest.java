
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


public class StudentManagerTest {

    @Test
    public void TestSaveStudent() {
        StudentManager manager = new StudentManager();
        Student student = new Student("001", "John Doe", 20, "john.doe@example.com", "Computer Science");
        manager.saveStudent(student);

        Student savedStudent = manager.searchStudent("001");
        assertNotNull("Student should be saved successfully", savedStudent);
        assertEquals("001", savedStudent.getId());
        assertEquals("John Doe", savedStudent.getName());
        assertEquals(20, savedStudent.getAge());
        assertEquals("john.doe@example.com", savedStudent.getEmail());
        assertEquals("Computer Science", savedStudent.getCourse());
    }
}

