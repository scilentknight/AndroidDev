package np.edu.kathford.passingdataexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etFullName;
    private EditText etAge;
    private EditText etMobileNumber;
    private Button btnSubmit;
    private TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFullName = findViewById(R.id.etFullName);
        etAge = findViewById(R.id.etAge);
        etMobileNumber = findViewById(R.id.etMobileNumber);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);

        // Event Registration / Handler  here handler performed by onClick()
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = etFullName.getText().toString().trim();
                int age = Integer.parseInt(etAge.getText().toString().trim());
                String mobileNumber = etMobileNumber.getText().toString().trim();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("full_name", fullName);
                intent.putExtra("age", age);
                intent.putExtra("mobile", mobileNumber);
                startActivity(intent);

            }
        });

    }
}
