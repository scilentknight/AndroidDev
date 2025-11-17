package np.edu.kathford.loginsignupexample;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private EditText fullNameEditText, mobileNumberEditText, passwordEditText;
    private RadioGroup genderRadioGroup;
    private Spinner nationalitySpinner;
    private CheckBox termsAndConditionCheckBox;
    private Button signupButton;
    private TextView loginTextView;

//    // making global variable
//    private String fullName;
//    private String mobileNumber, password, nationality;
//    private boolean termsChecked;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fullNameEditText = findViewById(R.id.fullNameEditText);
        mobileNumberEditText = findViewById(R.id.mobileNumberEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        nationalitySpinner = findViewById(R.id.nationalitySpinner);
        termsAndConditionCheckBox = findViewById(R.id.termsAndConditionCheckBox);
        signupButton = findViewById(R.id.signupButton);
        loginTextView = findViewById(R.id.loginTextView);


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // local variable
                String fullName = fullNameEditText.getText().toString().trim();
                String mobileNumber = mobileNumberEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
                String gender = "";
                if (selectedGenderId != -1) {
                    RadioButton selectedGenderButton = findViewById(selectedGenderId);
                    gender = selectedGenderButton.getText().toString();
                }

                String nationality = nationalitySpinner.getSelectedItem().toString();
                boolean termsChecked = termsAndConditionCheckBox.isChecked();

                if (validateSignUp(fullName, mobileNumber, password, gender, nationality, termsChecked)) {
                    Toast.makeText(SignUpActivity.this,
                            "Registration Successful",
                            Toast.LENGTH_LONG).show();

                    fullNameEditText.setText(null);
                    mobileNumberEditText.setText(null);
                    passwordEditText.setText(null);
                    genderRadioGroup.clearCheck();
                    nationalitySpinner.setSelection(0); // reset spinner to first item
                    termsAndConditionCheckBox.setChecked(false);
                    finish();
                }
            }
        });

        // Navigate to LoginActivity when clicked
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private boolean validateSignUp(String fullName, String mobileNumber, String password, String gender, String nationality, boolean termsChecked) {
        if (fullName.isEmpty()) {
            fullNameEditText.setError("Full Name is required");
            return false;
        }
        if (mobileNumber.isEmpty()) {
            mobileNumberEditText.setError("Mobile Number is required");
            return false;
        }
        if (password.isEmpty()) {
            passwordEditText.setError("Password is required");
            return false;
        }
        if (gender.isEmpty()) {
            Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (nationality.equals("Select your nationality")) {
            Toast.makeText(this, "Please select your nationality", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!termsChecked) {
            Toast.makeText(this, "You must accept the Terms & Conditions", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}

