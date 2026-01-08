package np.edu.kathford.hospitalsqliteapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = findViewById(R.id.txtResult);
        dbHelper = new DBHelper(this);

        // Insert Sample Records
        dbHelper.insertDoctor(1, "Dr. Arun", 3.2);
        dbHelper.insertDoctor(2, "Dr. Meera", 6.0);
        dbHelper.insertDoctor(3, "Dr. Ravi", 4.8);

        // Display Doctors with Experience < 5.5
        displayDoctors();
    }

    private void displayDoctors() {
        Cursor cursor = dbHelper.getJuniorDoctors();
        StringBuilder sb = new StringBuilder();

        while (cursor.moveToNext()) {
            sb.append("ID: ").append(cursor.getInt(0)).append("\n");
            sb.append("Name: ").append(cursor.getString(1)).append("\n");
            sb.append("Experience: ").append(cursor.getDouble(2)).append("\n\n");
        }

        txtResult.setText(sb.toString());
        cursor.close();
    }
}

