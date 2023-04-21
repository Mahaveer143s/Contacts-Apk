package com.project.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.net.URI;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> Contacts = new ArrayList<ContactModel>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar ContactBar = findViewById(R.id.ContactToolbar);
        setSupportActionBar(ContactBar);
        ContactBar.setTitle("Contacts App");
        ContactBar.setSubtitle("By Mahaveer");

        RecyclerView ReView=findViewById(R.id.recycler_view);
        FloatingActionButton Callbtn=findViewById(R.id.callbtn);

        Callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog AddContact = new Dialog(MainActivity.this);
                AddContact.setContentView(R.layout.activity_data_update);
                AddContact.show();
                EditText newName = AddContact.findViewById(R.id.newName);
                EditText newNumber=AddContact.findViewById(R.id.newNumber);
                Button Submit = AddContact.findViewById(R.id.Submit);
                Submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String AddName=" ";

                        String AddNumber=" ";

                        if( newName.getText().toString().equals("")||newNumber.getText().toString().equals("")){
                            Toast.makeText(MainActivity.this,"Please Enter Data",Toast.LENGTH_SHORT).show();

                        }
                        else{
                            AddName=newName.getText().toString();
                            AddNumber=newNumber.getText().toString();
                        Contacts.add(new ContactModel(R.drawable.rahul,AddNumber,AddName));
                        Toast.makeText(MainActivity.this,"Contact Addeed",Toast.LENGTH_SHORT).show();
                        AddContact.dismiss();}
                    }
                });

            }
        });


        Contacts.add(new ContactModel(R.drawable.rahul,"9923343434","Rahul"));
        Contacts.add(new ContactModel(R.drawable.rahul,"9923343434","Mahesh"));
        Contacts.add( new ContactModel(R.drawable.rahul,"992334343","Mukesh"));
        Contacts.add( new ContactModel(R.drawable.rahul,"992334343","ramesh"));
        Contacts.add(new ContactModel(R.drawable.rahul,"992334343","Raaj"));
        Contacts.add(new  ContactModel(R.drawable.rahul,"992334343","Mahi"));
        Contacts.add(new  ContactModel(R.drawable.rahul,"992334343","Mahi"));
        Contacts.add(new  ContactModel(R.drawable.rahul,"992334343","Mahi"));
        Contacts.add(new  ContactModel(R.drawable.rahul,"992334343","Mahi"));
        Contacts.add(new  ContactModel(R.drawable.rahul,"992334343","Mahi"));
        Contacts.add(new  ContactModel(R.drawable.rahul,"992334343","Mahi"));
        Contacts.add(new  ContactModel(R.drawable.rahul,"992334343","Mahi"));
        Contacts.add(new  ContactModel(R.drawable.rahul,"992334343","Mahi"));
        Contacts.add(new  ContactModel(R.drawable.rahul,"992334343","Mahi"));
        Contacts.add(new  ContactModel(R.drawable.rahul,"992334343","Mahi"));

//
//        Contacts.add(Rahul);
//        Contacts.add(Mahesh);
//        Contacts.add(Mukesh);
//        Contacts.add(Ramesh);
//        Contacts.add(Raaj);
//        Contacts.add(Mahi);
        ReView.setLayoutManager(new LinearLayoutManager(this));

   ContactAdabter adabter = new ContactAdabter(MainActivity.this,Contacts);
   ReView.setAdapter(adabter);



    }
}