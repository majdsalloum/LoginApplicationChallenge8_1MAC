package com.example.android.loginapplicationchallenge8_1mac;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private int day, month, year;
    private Calendar mCalendar;
    private EditText nameEt, emailEt, dateEt, phoneEt;
    private TextView nameTv, emailTv, dateTv, phoneTv;
    private Spinner countrySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEt = findViewById(R.id.name_field);
        emailEt = findViewById(R.id.email_field);
        dateEt = findViewById(R.id.birthday_field);
        phoneEt = findViewById(R.id.phone_field);

        countrySpinner = findViewById(R.id.country);

        nameTv = findViewById(R.id.name_label);
        emailTv = findViewById(R.id.email_label);
        dateTv = findViewById(R.id.birthday_label);
        phoneTv = findViewById(R.id.phone_label);

        nameEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() != 0) {
                    nameTv.setVisibility(View.VISIBLE);
                } else nameTv.setVisibility(View.GONE);
            }
        });
        emailEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() != 0) {
                    emailTv.setVisibility(View.VISIBLE);
                } else emailTv.setVisibility(View.GONE);
            }
        });
        dateEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() != 0) {
                    dateTv.setVisibility(View.VISIBLE);
                } else dateTv.setVisibility(View.GONE);
            }
        });
        phoneEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() != 0) {
                    phoneTv.setVisibility(View.VISIBLE);
                } else phoneTv.setVisibility(View.GONE);
            }
        });

        mCalendar = Calendar.getInstance();
        day = mCalendar.get(Calendar.DAY_OF_MONTH);
        year = mCalendar.get(Calendar.YEAR);
        month = mCalendar.get(Calendar.MONTH);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.title);
    }

    public void setDate(View v) {
        final EditText mdob_et = (EditText) v;
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mdob_et.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
            }
        };
        DatePickerDialog dpDialog = new DatePickerDialog(this, listener, year, month, day);
        dpDialog.show();
    }

    public void verifyData(View v) {
        String name = nameEt.getText().toString();
        String country = countrySpinner.getSelectedItem().toString();
        String phone = phoneEt.getText().toString();
        String email = emailEt.getText().toString();
        String birthday = dateEt.getText().toString();

        String state = "";

        Pattern namePattern = Pattern.compile("^\\D{3,}$");
        Pattern numbersPattern = Pattern.compile("^[0-9]+$");
        Pattern emailPattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        Pattern datePattern = Pattern.compile("^\\d{1,2}/\\d{1,2}/\\d{4}$");

        boolean nameError = !namePattern.matcher(name).find();
        boolean phoneError = !numbersPattern.matcher(phone).find();
        boolean emailError = !emailPattern.matcher(email).find();
        boolean birthdayError = !datePattern.matcher(birthday).find();

        if (nameError) state += "يرجى التأكد من الاسم" + "\n";
        if (phoneError) state += "يرجى التأكد من رقم الهاتف" + "\n";
        if (emailError) state += "يرجى التأكد من الايميل" + "\n";
        if (birthdayError) state += "يرجى التأكد من تاريخ الميلاد" + "\n";
        if (state.length() == 0) {
            state = "اهلا وسهلا يا " + name + "\n"+
                    "من" + country + "\n"+
                    "رقمك : " + phone + "\n"+
                    "ايميلك : " + email + "\n" +
                    " ميلادك : " + birthday;
            Toast.makeText(this, state, Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this, state, Toast.LENGTH_SHORT).show();

    }
}
