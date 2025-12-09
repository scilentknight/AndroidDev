package np.edu.kathford.dialogexample;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button logoutButton;
    private Button dialogFragmentButton;
    private Button customDialogButton;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logoutButton = findViewById(R.id.logoutButton);
        dialogFragmentButton = findViewById(R.id.dialogFragmentButton);
        customDialogButton = findViewById(R.id.customDialogButton);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutDialog();
            }
        });

        dialogFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogoutDialogFragment logoutDialogFragment =
                        new LogoutDialogFragment();
                logoutDialogFragment.show(getSupportFragmentManager(),
                        "LogoutDialogFragment");
            }
        });

        // custom dialog
        customDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog();
            }
        });
    }
    private void customDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.dialog_simple_interest, null);

        EditText etPrincipal = view.findViewById(R.id.etPrincipal);
        EditText etTime = view.findViewById(R.id.etTime);
        EditText etRate = view.findViewById(R.id.etRate);
        TextView tvResult = view.findViewById(R.id.tvResult);
        Button btnCalculate = view.findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double principal = Double.parseDouble(etPrincipal.getText().toString().trim());
                int time = Integer.parseInt(etTime.getText().toString().trim());
                double rate = Double.parseDouble(etRate.getText().toString().trim());

                double simpleInterest = (principal*time*rate)/100;

                tvResult.setText("The Result is: "+simpleInterest);
            }
        });
        //set custom dialog
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void logoutDialog() {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout?");
        builder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(MainActivity.this,
                                "OK button clicked", Toast.LENGTH_SHORT).show();

                    }
                });

        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}