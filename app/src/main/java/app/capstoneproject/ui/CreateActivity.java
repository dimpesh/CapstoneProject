package app.capstoneproject.ui;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;

import app.capstoneproject.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateActivity extends AppCompatActivity {
    public static final String TAG="CreateActivity";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @BindView(R.id.create_dob)
    EditText dob;
    @BindView(R.id.create_name)
    EditText name;
    @BindView(R.id.create_fname)
    EditText fname;
    @BindView(R.id.create_mname)
    EditText mname;
    @BindView(R.id.create_address)
    EditText address;
    @BindView(R.id.create_phone)
    EditText phone;
    @BindView(R.id.create_email)
    EditText email;
    @BindView(R.id.create_password)
    EditText password;

    @BindView(R.id.create_submit_button)
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        setTitle(getString(R.string.create_activity_title));
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

    }

    @OnClick(R.id.create_dob_button)
    public void dateChooser(View v) {
        DateDialog();
    }


    public void DateDialog() {
        Calendar mcurrentDate = Calendar.getInstance();
        int mYear = mcurrentDate.get(Calendar.YEAR);
        int mMonth = mcurrentDate.get(Calendar.MONTH);
        int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog mDatePicker;
        mDatePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                selectedmonth = selectedmonth + 1;
                dob.setText("" + selectedday + "/" + selectedmonth + "/" + selectedyear);
            }
        }, mYear, mMonth, mDay);
        mDatePicker.setTitle("Select Date");
        mDatePicker.show();
    }

    @OnClick(R.id.create_submit_button)
    public void onSubmit(View v)
    {
        Toast.makeText(getApplicationContext(),"Working...",Toast.LENGTH_SHORT).show();
/*
        Firebase ref=new Firebase(Constants.FIREBASE_URL);
        ref.createUser(email.getText().toString(),password.getText().toString(),
                new Firebase.ValueResultHandler<Map<String,Object>>()
                {

                    @Override
                    public void onSuccess(Map<String, Object> stringObjectMap) {
                        submit.setBackgroundColor(Color.GREEN);
                        submit.setText(getString(R.string.success));
                        Toast.makeText(getApplicationContext(),getString(R.string.success_toast),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(FirebaseError firebaseError) {
                        Toast.makeText(getApplicationContext(),getString(R.string.fail_toast),Toast.LENGTH_SHORT).show();

                    }
                });
*/
        mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                        if(task.isSuccessful())
                        Toast.makeText(getApplicationContext(), R.string.successful,
                                Toast.LENGTH_SHORT).show();


                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), R.string.unsuccessful,
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });



    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}
