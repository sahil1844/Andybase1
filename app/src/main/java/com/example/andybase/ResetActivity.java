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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResetActivity extends AppCompatActivity {
    TextView useremail;
    TextInputEditText pass,retype;
    TextInputLayout layout,layout1;
    Button changepass;
    DBHelper helper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        helper = new DBHelper(this);
        useremail = findViewById(R.id.useremail);
        pass = findViewById(R.id.passtype_Email);
        retype = findViewById(R.id.Retype_password);
        changepass = findViewById(R.id.changepass_btn);
        layout = findViewById(R.id.password1);
        layout1 = findViewById(R.id.password2);
        Intent i = getIntent();
        useremail.setText(i.getStringExtra("useremail"));
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (isValidPassword(pass.getText().toString().trim())) {
                    layout.setHelperTextEnabled(false);
                } else {
                    layout.setHelperTextEnabled(true);
                    layout.setHelperText("*Enter password atleast 8 Character have like this 1,$,S,s*");
                    layout.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                    layout1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                String pass11 = pass.getText().toString().trim();
                String pass12 = retype.getText().toString().trim();
                if (pass11.isEmpty() && pass12.isEmpty()){
                    layout.setHelperTextEnabled(true);
                    layout1.setHelperTextEnabled(true);
                    layout.setHelperText("Enter A Valid Password !!!");
                    layout1.setHelperText("Enter A Valid Password !!!");
                    layout.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                    layout1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                }else{
                    imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                    layout.setHelperTextEnabled(false);
                    layout1.setHelperTextEnabled(false);
                        String username = useremail.getText().toString();
                        String pass1 = pass.getText().toString();
                        String retype1 = retype.getText().toString();
                        if (pass1.equals(retype1)) {
                            layout1.setHelperTextEnabled(true);
                            layout1.setHelperText("Password Not Match !!!");
                            layout1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                            Boolean Check_pass_update = helper.updatepassword(username, retype1);
                            if (Check_pass_update) {
                                Intent i1 = new Intent(ResetActivity.this, LoginActivity.class);
                                startActivity(i1);
                                Toast.makeText(ResetActivity.this, "Password Updated SuccessFully..", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(ResetActivity.this, "Password Not Updated...", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            layout1.setHelperTextEnabled(true);
                            layout1.setHelperText("*Enter password as before entered!!*");
                            layout1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                            Toast.makeText(ResetActivity.this, "Passoword Not Match...", Toast.LENGTH_SHORT).show();
                        }
                }
            }
        });
    }
    public boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
}