package np.edu.kathford.loginsignupexample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView signupTextView;
    private TextView forgetPasswordTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        forgetPasswordTextView = findViewById(R.id.forgetPasswordTextView);
        signupTextView = findViewById(R.id.signupTextView);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

//                Log.d("username", username);
//                Log.d("password", password);
//                boolean isSuccess = validateLogin(username, password);

                if (validateLogin(username, password)) {
                    Toast toast = Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0); // Show toast at the center of the screen
                    toast.show(); // show toast message

                    usernameEditText.setText(null);
                    passwordEditText.setText(null);
                }
            }
        });

        // Navigate to ForgetPasswordActivity when clicked
        forgetPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });

        // Navigate to SignUpActivity when clicked
        signupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateLogin(String username, String password) {
        if (username.isEmpty()) {
            usernameEditText.setError("Username is required");
            return false;
        }
        if (password.isEmpty()) {
            passwordEditText.setError("Password is required");
            return false;
        }
        return true;
    }

}
