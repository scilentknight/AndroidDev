package np.edu.kathford.studentlistdb;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import np.edu.kathford.studentlistdb.models.Student;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Student> students;
    ArrayList<String> studentNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewStudents);

        students = new ArrayList<>();
        students.add(new Student(1, "Prakash", "Kathmandu"));
        students.add(new Student(2, "Amrit", "Tokyo"));
        students.add(new Student(3, "Bikas", "Delhi"));

        studentNames = new ArrayList<>();
        for (Student s : students) {
            studentNames.add(s.name);
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Student selectedStudent = students.get(position);

            Bundle bundle = new Bundle();
            bundle.putInt("roll", selectedStudent.roll);
            bundle.putString("name", selectedStudent.name);
            bundle.putString("address", selectedStudent.address);

            StudentDetailsFragment fragment = new StudentDetailsFragment();
            fragment.setArguments(bundle);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit();
        });
    }
}

