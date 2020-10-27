package com.example.registerform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText eText_first_name, eText_last_name, eText_birthday, eText_address, eText_email;

    Button bBirthday_select, bRegister;

    RadioGroup radGroup_gender;

    CheckBox checkBox;

    TextView tView_register_status;

    RadioButton radButton_male, radButton_female;
    EditText[] eText_list;

    String respondStr;

    final Calendar cldr = Calendar.getInstance();

    int day = cldr.get(Calendar.DAY_OF_MONTH);
    int month = cldr.get(Calendar.MONTH);
    int year = cldr.get(Calendar.YEAR);

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

        eText_list = new EditText[]{
                eText_first_name,
                eText_last_name,
                eText_birthday,
                eText_address,
                eText_email
        };


        bBirthday_select = findViewById(R.id.birthday_select);
        bBirthday_select.setOnClickListener(this);

        bRegister = findViewById(R.id.register);
        bRegister.setOnClickListener(this);

        radGroup_gender = findViewById(R.id.radio_group_gender);
        radButton_female = findViewById(R.id.radio_btn_female);
        radButton_male = findViewById(R.id.radio_btn_male);

        checkBox = findViewById(R.id.checkbox);

        tView_register_status= findViewById(R.id.register_status);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.register:
                String respond = "Missing: ";
                String field_value;

                if (!checkBox.isChecked())
                {
                    respond = "Please agree to our Terms of Use.";
                }
                else if (radGroup_gender.getCheckedRadioButtonId() == -1)
                {
                    respond = "Please select your gender.";
                }
                else
                {
                    for (EditText current_EditText : eText_list)
                    {
                        field_value = current_EditText.getText().toString();
                        if (field_value.isEmpty())
                        {
                            respond += String.format("%s, ", current_EditText.getHint());
                        }
                    }
//                    Remove the last comma + space
                    if ((respond != null) && (respond.length() > 0))
                    {
                        respond = respond.substring(0, respond.length() - 2);
                    }
                }

                if (respond.equals("Missing"))
                {
                    tView_register_status.setTextColor(Color.parseColor("#0abab5"));
                    tView_register_status.setTextSize(20);
                    respond = "Successfully register!";
                }

                tView_register_status.setText(respond);
                break;

            case R.id.birthday_select:
                // date picker dialog
                DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                            {
                                eText_birthday.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePicker.show();
                break;
        }
        }
    }
