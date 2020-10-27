package com.example.registerform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText eText_first_name, eText_last_name, eText_birthday, eText_address, eText_email;

    Button bBirthday_select, bRegister;

    RadioGroup radio_group_gender;

    CheckBox checkBox;

    TextView tView_register_status;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eText_first_name = findViewById(R.id.first_name);
        eText_last_name = findViewById(R.id.last_name);
        eText_birthday = findViewById(R.id.birthday);
        eText_address = findViewById(R.id.address);
        eText_email = findViewById(R.id.email);

        bBirthday_select = findViewById(R.id.birthday_select);
        bBirthday_select.setOnClickListener(this);

        bRegister = findViewById(R.id.register);
        bRegister.setOnClickListener(this);

        radio_group_gender = findViewById(R.id.radio_group_gender);

        checkBox = findViewById(R.id.checkbox);

        tView_register_status= findViewById(R.id.register_status);
    }

    @Override
    public void onClick(View view)
    {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        System.out.println(view.getId());
        switch (view.getId())
        {
            case R.id.register:
                ArrayList<String> unfilled_EditText_list = new ArrayList<>();

//                Get all EditText in current layout
                ViewGroup container = (ViewGroup) findViewById(R.id.container);

                for (int i = 0; i < container.getChildCount(); i++)
                {
                    View child_view = container.getChildAt(i);

//                    Filter out all EditText type
                    if (child_view instanceof EditText)
                    {
                        unfilled_EditText_list.add((String) ((EditText) child_view).getHint());
                    }
                }
//                Check if there is any unfilled EditText
                if (!unfilled_EditText_list.isEmpty())
                {
                    String missing_fields = Arrays.toString(unfilled_EditText_list.toArray());
                    tView_register_status.setText(
                            String.format("Missing fields: %s", missing_fields)
                    );
                }
                break;

            case R.id.birthday_select:
                // date picker dialog
                DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText_birthday.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePicker.show();
                break;
        }
        }
    }
