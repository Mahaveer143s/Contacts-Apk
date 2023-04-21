package com.project.contacts;



import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public  class ContactAdabter extends RecyclerView.Adapter<ContactAdabter.ViewHolder>{
    Context  context;
        ArrayList<ContactModel> Contacts;

        ContactAdabter(Context context, ArrayList<ContactModel> Contacts){//this constructor  is used to take the layout reference
        this.context=context;
        this.Contacts=Contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//this method to create a view holder to hold and it will change holder im
       View contactView =  LayoutInflater.from(context).inflate(R.layout.contact_design,parent,false);
       ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder ;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
   holder.imgContact.setImageResource(Contacts.get(position).img);
   holder.txtName.setText(Contacts.get(position).name);
   holder.txtNumber.setText(Contacts.get(position).number);

   holder.ContactRow.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {

           Dialog UpdateDialog=new Dialog(context);
           UpdateDialog.setContentView(R.layout.activity_call);
           EditText UpdateName = UpdateDialog.findViewById(R.id.DisName);
           EditText UpdateContact = UpdateDialog.findViewById(R.id.DisContact);
           ImageView UpImage =UpdateDialog.findViewById(R.id.UpImage);
           Button  Update = UpdateDialog.findViewById(R.id.Update);

           UpdateName.setText((Contacts.get(position)).name);
           UpdateContact.setText((Contacts.get(position)).number);
           UpImage.setImageResource((Contacts.get(position)).img);

           Update.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if( UpdateName.getText().toString().equals("")||UpdateContact.getText().toString().equals("")){
                       Toast.makeText(context,"Please Enter Data",Toast.LENGTH_SHORT).show();

                   }
                   else{
                       String AddName=UpdateName.getText().toString();
                      String AddNumber=UpdateContact.getText().toString();
                       Toast.makeText(context,"Contact Addeed",Toast.LENGTH_SHORT).show();
                      Contacts.set(position,new ContactModel(R.drawable.rahul,AddNumber,AddName));
                       UpdateDialog.dismiss();}

               }
           });
           UpdateDialog.show();


           holder.ContactRow.setOnLongClickListener(view1 -> {

               AlertDialog.Builder builder = new AlertDialog.Builder(context)
               .setTitle("Delete Contact")
                       .setMessage("Delete Contact")
                       .setIcon(R.drawable.ic_baseline_delete_24)
                       .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               Toast.makeText(context,"Deleting Element",Toast.LENGTH_SHORT).show();
                               Contacts.remove(position);
                               notifyItemRemoved(position);
                           }
                       })
                       .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               Toast.makeText(context,"Exit",Toast.LENGTH_SHORT).show();
                           }
                       });
               builder.show();


               return true;
           });








       }
   });
    }

    @Override
    public int getItemCount() {
        return Contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName,txtNumber;
        ImageView imgContact;
        LinearLayout ContactRow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName=itemView.findViewById(R.id.contact_name);
            txtNumber=itemView.findViewById(R.id.contact_Phno);
            imgContact=itemView.findViewById(R.id.contact_img);
            ContactRow=itemView.findViewById(R.id.ContactRow);
        }
    }
}
