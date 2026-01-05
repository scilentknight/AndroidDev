package np.edu.kathford.studentlistdb;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class StudentDetailsFragment extends Fragment {

    public StudentDetailsFragment() { }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_student_details, container, false);

        TextView txtRoll = view.findViewById(R.id.txtRoll);
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtAddress = view.findViewById(R.id.txtAddress);

        Bundle bundle = getArguments();
        if (bundle != null) {
            txtRoll.setText("Roll: " + bundle.getInt("roll"));
            txtName.setText("Name: " + bundle.getString("name"));
            txtAddress.setText("Address: " + bundle.getString("address"));
        }

        return view;
    }
}

