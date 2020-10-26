package com.example.registerform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText edit_text_first_name = findViewById(R.id.first_name);
    EditText edit_text_last_name = findViewById(R.id.last_name);
    EditText edit_text_birthday = findViewById(R.id.birthday);
    EditText edit_text_address= findViewById(R.id.address);
    EditText edit_text_email = findViewById(R.id.email);

    Button button_birthday_select = findViewById(R.id.birthday_select);
    Button button_register = findViewById(R.id.register);

    RadioGroup radio_group_gender = findViewById(R.id.radio_group_gender);

    CheckBox checkBox = findViewById(R.id.checkbox);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.
        }
    }
}