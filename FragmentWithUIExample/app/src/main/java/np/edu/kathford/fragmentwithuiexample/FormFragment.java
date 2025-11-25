package np.edu.kathford.fragmentwithuiexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FormFragment extends Fragment {
    private EditText etFullName, etAddress, etMobileNumber;
    private Button btnSubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_form, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etFullName = view.findViewById(R.id.etFullName);
        etAddress = view.findViewById(R.id.etAddress);
        etMobileNumber = view.findViewById(R.id.etMobileNumber);
        btnSubmit = view.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String fullName = etFullName.getText().toString().trim();
                String address = etAddress.getText().toString().trim();
                String mobile = etMobileNumber.getText().toString().trim();

                Toast.makeText(getContext(), " " + fullName + " " + address + " " + mobile, Toast.LENGTH_LONG).show();
            }
        });
    }
}
