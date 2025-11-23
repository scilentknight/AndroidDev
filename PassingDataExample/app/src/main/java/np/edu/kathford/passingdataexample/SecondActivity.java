package np.edu.kathford.passingdataexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView tvFullName;
    private TextView tvAge;
    private TextView tvMobileNumber;
    private Button btnOK;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvFullName = findViewById(R.id.tvFullName);
        tvAge = findViewById(R.id.tvAge);
        tvMobileNumber = findViewById(R.id.tvMobileNumber);
        btnOK = findViewById(R.id.btnOk);

            Intent intent = getIntent();
            String fullName = intent.getStringExtra("full_name");
            int age = intent.getIntExtra("age", 0);
            boolean is_active = intent.getBooleanExtra("is_active", false);
            String mobileNumber = intent.getStringExtra("mobile");

            tvFullName.setText(fullName);
//            tvAge.setText("" + age); OR
            tvAge.setText(String.valueOf(age));
            tvMobileNumber.setText(mobileNumber);


        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("ack",18);
                setResult(201, intent);
                //finish is used to close activity
                finish();
            }
        });

    }
}
