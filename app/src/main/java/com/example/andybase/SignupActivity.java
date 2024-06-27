package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.andybase.databinding.ActivitySignupBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {
    ActivitySignupBinding binding;
    DBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        helper = new DBHelper(this);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        binding.signupPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (isValidPassword(binding.signupPassword.getText().toString().trim())) {
                    binding.password1.setHelperTextEnabled(false);
                } else {
                    binding.password1.setHelperTextEnabled(true);
                    binding.password1.setHelperText("*Enter password atleast 8 Character have like this 1,$,S,s*");
                    binding.password1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        String email = binding.signupEmail.getText().toString();

        String emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$";
        binding.signupEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = s.toString(); // Get the email string from the input field
                if (email.matches(emailPattern)) {
                    binding.email1.setHelperTextEnabled(false);
                } else {
                    binding.email1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                    binding.email1.setHelperTextEnabled(true);
                    binding.email1.setHelperText("*Enter A Valid Email*");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                String email = binding.signupEmail.getText().toString();
                String pass = binding.signupPassword.getText().toString();
                String cpass = binding.signupCpassword.getText().toString();

                if(email.equals("") && pass.equals("") && cpass.equals("")){
                    binding.email1.setHelperTextEnabled(true);
                    binding.password1.setHelperTextEnabled(true);
                    binding.password2.setHelperTextEnabled(true);
                    binding.email1.setHelperText("*Enter A Valid Email*");
                    binding.password1.setHelperText("*Enter password atleast 8 Character have like this 1,$,S,s*");
                    binding.password2.setHelperText("*Enter password as before entered!!*");
                    binding.email1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                    binding.password1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                    binding.password2.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                }else if(email.equals("") && pass.equals("")) {
                    binding.email1.setHelperTextEnabled(true);
                    binding.password1.setHelperTextEnabled(true);
                    binding.email1.setHelperText("*Enter A Valid Email*");
                    binding.password1.setHelperText("*Enter password atleast 8 Character have like this 1,$,S,s*");
                    binding.email1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                    binding.password1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                } else if (pass.equals("") && cpass.equals("")) {
                    binding.password1.setHelperTextEnabled(true);
                    binding.password2.setHelperTextEnabled(true);
                    binding.password1.setHelperText("*Enter password atleast 8 Character have like this 1,$,S,s*");
                    binding.password2.setHelperText("*Enter password as before entered!!*");
                    binding.password1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                    binding.password2.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                }else if (email.equals("") && cpass.equals("")) {
                    binding.email1.setHelperTextEnabled(true);
                    binding.password2.setHelperTextEnabled(true);
                    binding.email1.setHelperText("*Enter A Valid Email*");
                    binding.password2.setHelperText("*Enter password as before entered!!*");
                    binding.email1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                    binding.password2.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                }else{
                    Log.e("email",email);
                    if (email.matches(emailPattern)) {
                        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                        binding.email1.setHelperTextEnabled(false);
                        binding.email1.setHelperTextColor(ColorStateList.valueOf(Color.BLACK));
                        if (pass.equals(cpass)) {
                            Log.e("123",pass);
                            imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                            binding.password1.setHelperTextEnabled(false);
                            binding.password2.setHelperTextEnabled(false);
                            binding.password1.setHelperTextColor(ColorStateList.valueOf(Color.BLACK));
                            binding.password2.setHelperTextColor(ColorStateList.valueOf(Color.BLACK));
                            Boolean checkUserEmail = helper.checkEmail(email);
                            if (checkUserEmail) {
                                Toast.makeText(SignupActivity.this, "User Already Exists, Please Login!!", Toast.LENGTH_SHORT).show();
                            } else {
                                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                                Boolean insertData = helper.insertData(email, pass);
                                Toast.makeText(SignupActivity.this, "SignUp Successfully!!", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                                startActivity(i);
                            }
                        } else {
                            binding.password2.setHelperTextEnabled(true);
                            binding.password2.setHelperText("*Enter password as before entered!!*");
                            binding.password2.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                            Toast.makeText(SignupActivity.this, "Invalid Password!!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        binding.email1.setHelperTextEnabled(true);
                        binding.email1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                    }
                }
            }
        });
        binding.LoginRedirecttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(i);
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