package database;

import domain.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private DatabaseConnection databaseConnection;

    public StudentDAO(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public List<Student> getAllStudents() {
        try {
            Statement stmt = null;
            ResultSet rs = null;

            stmt = this.databaseConnection.getCon().createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery("SELECT * FROM STUDENTS");

            List<Student> students = new ArrayList<Student>();

            while(rs.next()) {
                Student s = createStudentFromResultsetEntry(rs);
                students.add(s);
            }

            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Student createStudentFromResultsetEntry(ResultSet r) {
        try {
            return new Student(r.getInt("Id"),r.getString("Name"),r.getString("StudentNr"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student getStudentByStudentnr(String studentnr) {
        try {
            PreparedStatement stm = databaseConnection.getCon().prepareStatement("SELECT TOP(1) * FROM STUDENTS WHERE STUDENTNR=?");
            stm.setString(1, studentnr);
            ResultSet rs = stm.executeQuery();
            rs.next();
            Student s = createStudentFromResultsetEntry(rs);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


}
