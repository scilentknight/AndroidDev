package np.edu.kathford.todosapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etTask;
    private Button btnAdd;
    private RecyclerView rvTasks;
    private TaskAdapter adapter;
    private DBHelper dbHelper;
    private ArrayList<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTask = findViewById(R.id.etTask);
        btnAdd = findViewById(R.id.btnAdd);
        rvTasks = findViewById(R.id.rvTasks);

        dbHelper = new DBHelper(this);
        tasks = dbHelper.getAllTasks();

        adapter = new TaskAdapter(this, tasks);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));
        rvTasks.setAdapter(adapter);

        btnAdd.setOnClickListener(v -> {
            String taskText = etTask.getText().toString().trim();
            if (!taskText.isEmpty()) {
                dbHelper.addTask(taskText);
                tasks.clear();
                tasks.addAll(dbHelper.getAllTasks());
                adapter.notifyDataSetChanged();
                etTask.setText("");
                Toast.makeText(MainActivity.this, "Task added", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Please enter a task", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
