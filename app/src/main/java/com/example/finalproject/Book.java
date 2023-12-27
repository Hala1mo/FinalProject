package com.example.finalproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Book extends AppCompatActivity {
    private static final String LOG = "FIREBASE";
    private EditText txtEmail, txtFname, txtLnamee, phonee, add, pass;
    private DocumentReference myDoc;
    SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);

        txtEmail = findViewById(R.id.emailEditText);
        txtFname = findViewById(R.id.firstNameEditText);
        txtLnamee = findViewById(R.id.lastNameEditText);
        phonee = findViewById(R.id.phoneEditText);
        add = findViewById(R.id.addressEditText);
        pass = findViewById(R.id.passwordEditText);
        submitBtn = findViewById(R.id.submitButton);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("dfasdfasfas","doneeeeee");
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                String name = txtFname.getText().toString();
                String email = txtEmail.getText().toString();
                String Lname = txtLnamee.getText().toString();
                String phone = phonee.getText().toString();
                String address = add.getText().toString();
                String password = pass.getText().toString();

                if (name.isEmpty() || email.isEmpty() || Lname.isEmpty() || phone.isEmpty() || address.isEmpty() || password.isEmpty()) {
                    return;
                }

                Map<String,String> dataToSave = new HashMap<>();
                dataToSave.put("name", name);
                dataToSave.put("email", email);
                dataToSave.put("Lname", Lname);
                dataToSave.put("phone", phone);
                dataToSave.put("address", address);
                dataToSave.put("password", password);

                Gson gson = new Gson();
                Map<String,String>users = new HashMap<>();
                users.put("email",email);
                users.put("pass",password);
                String usersjson = gson.toJson(users);
                sharedPreferences.edit().putString("user", usersjson).apply();

                db.collection("sampleData").document().set(dataToSave)
                        .addOnSuccessListener(new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {
                                String message = email;
                                Intent intent = new Intent(Book.this, ActivRe.class);
                                intent.putExtra("message", message);
                                startActivity(intent);
                                Toast.makeText(Book.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                                Log.d(LOG, "Successfully ");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Book.this, "Error", Toast.LENGTH_SHORT).show();
                                Log.d(LOG, "Document has not been updated:)");
                            }
                        });
            }
        });


    }

}
