package com.example.finalproject;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;



    public class Book extends AppCompatActivity {
        private static final String EMAIL_KEY = "Email";
        private static final String PASSWORD_KEY = "Password";
        private EditText emailEditText;
        private EditText passwordEditText;
        private FirebaseFirestore database;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.connect);

            emailEditText = findViewById(R.id.edtEmail);
            passwordEditText = findViewById(R.id.edtPass);

            database = FirebaseFirestore.getInstance();
        }

        public void btnOnclick(View view) {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                return;
            }

            Map<String, String> userMap = new HashMap<>();
            userMap.put(EMAIL_KEY, email);
            userMap.put(PASSWORD_KEY, password);

            database.collection("Register").document("users")
                    .set(userMap)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(Book.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Book.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            Log.e("Book", "Error registering user", e);
                        }
                    });
        }
    }
