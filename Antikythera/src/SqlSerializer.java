import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class SqlSerializer {
    /*public static String StudentToSql(Student student, String tableName) {
        String sp = ", ";
        return "INSERT INTO STUDENTS VALUES (" +
                student.GetID() + sp +
                student.GetFirstName() + sp +
                student.GetLastName() + sp +
                student.GetGraduationYear() + sp +
                student.GetMajor() + sp +
                student.GetEmail() + ");";
    }

    public static Student StudentFromSql(ResultSet rs)
    {
        try {
            String name = rs.getString("NAME"),
                    surname = rs.getString("SURNAME"),
                    id = rs.getString("ID"),
                    major = rs.getString("MAJOR"),
                    email = rs.getString("EMAIL");

            int gradYear = rs.getInt("GRADYEAR");

            return new Student(name, surname, id, gradYear, major, email);
        } catch (SQLException e) {
            System.out.println("Error parsing Student object. " + e);
            return null;
        }
    }*/
}