package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andybase.databinding.ActivityLoginBinding;
import com.example.andybase.databinding.ActivitySignupBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    DBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        helper = new DBHelper(this);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        binding.LoginPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String passss = s.toString(); // Get the email string from the input field
                if (isValidPassword(passss)) {
                    binding.password1.setHelperTextEnabled(false);
                } else {
                    binding.password1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                    binding.password1.setHelperTextEnabled(true);
                    binding.password1.setHelperText("*Password is incorrect!!!*");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        String email = Objects.requireNonNull(binding.LoginEmail.getText()).toString();
        String emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$";
        binding.LoginEmail.addTextChangedListener(new TextWatcher() {
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
        binding.forgetRedirecttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ForgrtActivity.class);
                i.putExtra("loginemail",email);
                startActivity(i);
            }
        });
        binding.LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                String email = binding.LoginEmail.getText().toString().trim();
                String pass11 = binding.LoginPassword.getText().toString().trim();

                // Check if both fields are empty
                if (email.isEmpty() && pass11.isEmpty()) {
                    binding.email1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                    binding.password1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                    binding.email1.setHelperTextEnabled(true);
                    binding.email1.setHelperText("*Enter A Valid Email*");
                    binding.password1.setHelperTextEnabled(true);
                    binding.password1.setHelperText("*Password is incorrect!!!*");
                } else {
                    // Check if password field is empty
                    if (pass11.isEmpty()) {
                        binding.password1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                        binding.password1.setHelperTextEnabled(true);
                        binding.password1.setHelperText("*Password is incorrect!!!*");
                    } else {
                        binding.password1.setHelperTextColor(ColorStateList.valueOf(Color.BLACK));
                        binding.password1.setHelperTextEnabled(false);
                    }
                    // Check if email field is empty
                    if (email.isEmpty()) {
                        binding.email1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                        binding.email1.setHelperTextEnabled(true);
                        binding.email1.setHelperText("*Enter A Valid Email*");
                    } else {
                        binding.email1.setHelperTextEnabled(false);
                        // Validate email format (assuming helper.checkEmail validates the email format)
                        Boolean checkEmail = helper.checkEmail(email);
                        if (checkEmail) {
                            binding.email1.setHelperTextColor(ColorStateList.valueOf(Color.BLACK));
                            // Validate email and password credentials
                            Boolean checkCredentials = helper.checkemailpass(email, pass11);
                            if (checkCredentials) {
                                Toast.makeText(LoginActivity.this, "Login Successfully!!", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                                i.putExtra("homeem", email);
                                startActivity(i);
                                binding.LoginEmail.setText("");
                                binding.LoginPassword.setText("");
                                binding.email1.setHelperTextEnabled(false);
                                binding.password1.setHelperTextEnabled(false);

                                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                            } else {
                                Toast.makeText(LoginActivity.this, "Login Not Successfully!!", Toast.LENGTH_SHORT).show();
                                binding.password1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                                binding.password1.setHelperTextEnabled(true);
                                binding.password1.setHelperText("*Password is incorrect!!!*");
                            }
                        } else {
                            binding.email1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                            binding.email1.setHelperTextEnabled(true);
                            binding.email1.setHelperText("*Enter A Valid Email*");
                            Toast.makeText(LoginActivity.this, "User Not Found!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        binding.signupRedirecttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
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