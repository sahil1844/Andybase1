package com.example.andybase;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.makeramen.roundedimageview.RoundedImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ProfileActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_PICK = 2;
    private static final int REQUEST_STORAGE_PERMISSION = 1;
    TextView usere,uname;
    RoundedImageView imageView;
    TextInputLayout email1,fname,lname;
    TextInputEditText emailfeild,fnamefeild,lnamefeild;
    DBHelper helper;
    InputMethodManager imm;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        email1 = findViewById(R.id.pemail);
        emailfeild = findViewById(R.id.profile_Email);
        fname = findViewById(R.id.pfname);
        lname = findViewById(R.id.plname);
        fnamefeild = findViewById(R.id.profile_Fname);
        lnamefeild = findViewById(R.id.profile_Lname);
        usere = findViewById(R.id.useremail);
        uname = findViewById(R.id.username);
        imageView = findViewById(R.id.imageView3);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        String emailuser = emailfeild.getText().toString();

        String emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$";
        emailfeild.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = s.toString(); // Get the email string from the input field
                if (email.matches(emailPattern)) {
                    email1.setHelperTextEnabled(false);
                } else {
                    email1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                    email1.setHelperTextEnabled(true);
                    email1.setHelperText("*Enter A Valid Email*");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        helper = new DBHelper(this);
        Intent i = getIntent();
        String username = i.getStringExtra("nm");
        String s = "";
        String f = "";
        String l = "";
        String p = "";
        Cursor cr = helper.showdata(username);
        if (cr.getCount() == 0) {
            emailfeild.setText("Record not found!!!");
        } else {
            while (cr.moveToNext()) {
                s = cr.getString(1) + cr.getString(2);
                f = cr.getString(1);
                l = cr.getString(2);
                p += cr.getString(3);
            }
                fnamefeild.setText(f);
                lnamefeild.setText(l);
                usere.setText(p);
                uname.setText(s);
                emailfeild.setText(p);
        }
//        if(username != null){
//            String s = "";
//            String f = "";
//            String l = "";
//            String p = "";
//            Cursor cr = helper.showdata(username);
//            if (cr.getCount() == 0) {
//                emailfeild.setText("Record not found!!!");
//            } else {
//                while (cr.moveToNext()) {
//                    s = cr.getString(1) + cr.getString(2);
//                    f = cr.getString(1);
//                    l = cr.getString(2);
//                    p += cr.getString(3);
//                }
//                fnamefeild.setText(f);
//                lnamefeild.setText(l);
//                usere.setText(p);
//                uname.setText(s);
//                emailfeild.setText(p);
//            }
//        } else {
//            fnamefeild.setText("");
//            lnamefeild.setText("");
//            usere.setText("");
//            uname.setText("");
//            emailfeild.setText("");
//        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
                pickImage.launch(intent);
            }
        });
    }

    private final ActivityResultLauncher<Intent> pickImage=registerForActivityResult
            (new ActivityResultContracts.StartActivityForResult(), result->{
                        if (result.getResultCode()==RESULT_OK){

                            if (result.getData()!=null){
                                Uri imageUri=result.getData().getData();
                                try {
                                    InputStream inputStream=getContentResolver().openInputStream(imageUri);
                                    Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                                    imageView.setImageBitmap(bitmap);
                                } catch (FileNotFoundException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }

                    }
            );

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_IMAGE_PICK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_PICK && resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            imageView.setImageURI(selectedImage);
        }
    }
    public void Updatesettings(View view) {
        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        String fname1 = fnamefeild.getText().toString().trim();
        String lname1 = lnamefeild.getText().toString().trim();
        String email11 = emailfeild.getText().toString().trim();
        if (fname1.isEmpty() && lname1.isEmpty() && email11.isEmpty()) {
            fname.setHelperTextEnabled(true);
            lname.setHelperTextEnabled(true);
            fname.setHelperText("*Enter First Name*");
            lname.setHelperText("*Enter Last Name*");
            fname.setHelperTextColor(ColorStateList.valueOf(Color.RED));
            lname.setHelperTextColor(ColorStateList.valueOf(Color.RED));
            email1.setHelperTextEnabled(true);
            email1.setHelperText("*Enter A Valid Email*");
            email1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
        } else if (fname1.isEmpty()) {
            fname.setHelperTextEnabled(true);
            fname.setHelperText("*Enter First Name*");
            fname.setHelperTextColor(ColorStateList.valueOf(Color.RED));
        } else if (lname1.isEmpty()) {
            lname.setHelperTextEnabled(true);
            lname.setHelperText("*Enter Last Name*");
            lname.setHelperTextColor(ColorStateList.valueOf(Color.RED));
        } else if (email11.isEmpty()) {
            email1.setHelperTextEnabled(true);
            email1.setHelperText("*Enter A Valid Email*");
            email1.setHelperTextColor(ColorStateList.valueOf(Color.RED));
        } else {
                if(helper.checkEmail(email11)) {
                    Boolean Check_email_update = helper.updateemail(email11, usere.getText().toString());
                    if (Check_email_update) {
                        Log.d("email", email11);
                        Toast.makeText(ProfileActivity.this, "Updated SuccessFully..", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ProfileActivity.this, "Not Updated...", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(ProfileActivity.this, "Email Not Found..", Toast.LENGTH_SHORT).show();
                }

        }
    }
//    public boolean isValidPassword(final String password) {
//        Pattern pattern;
//        Matcher matcher;
//        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
//        pattern = Pattern.compile(PASSWORD_PATTERN);
//        matcher = pattern.matcher(password);
//        return matcher.matches();
//    }
}