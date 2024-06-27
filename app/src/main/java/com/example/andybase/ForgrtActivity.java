package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ForgrtActivity extends AppCompatActivity {

    TextInputEditText email;
    TextInputLayout layout;
    Button reset_btn;
    DBHelper helper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgrt);
        email = findViewById(R.id.forget_Email);
        reset_btn = findViewById(R.id.Reset_btn);
        layout = findViewById(R.id.email1);
        helper = new DBHelper(this);
        Intent ii = getIntent();
        email.setText(ii.getStringExtra("LoginEmail"));
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        String emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$";
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = s.toString(); // Get the email string from the input field
                if (email.matches(emailPattern)) {
                    layout.setHelperTextEnabled(false);
                } else {
                    layout.setHelperTextEnabled(true);
                    layout.setHelperText("*Enter A Valid Email*");
                    layout.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                String email1 = email.getText().toString();
                if (!email1.equals("")) {
                        layout.setHelperTextEnabled(false);
                        String useremail = email.getText().toString();
                        Boolean finduser = helper.checkEmail(useremail);
                        if (finduser) {
                            imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                            Intent i = new Intent(ForgrtActivity.this, ResetActivity.class);
                            i.putExtra("useremail", useremail);
                            startActivity(i);
                        } else {
                            Toast.makeText(ForgrtActivity.this, "User Not Found!!!", Toast.LENGTH_SHORT).show();

                        }
                } else {
                    layout.setHelperTextEnabled(true);
                    layout.setHelperText("*Enter A Valid Email*");
                    layout.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                }
            }
        });
    }
}