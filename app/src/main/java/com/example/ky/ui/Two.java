package com.example.ky.ui;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Two extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.two);
        Button button=findViewById(R.id.sig);
        LayoutInflater inflater=Two.this.getLayoutInflater();
        View v= inflater.inflate(R.layout.two_2,null,false);
        Context context=Two.this;
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setView(v);
        builder.setCancelable(false);
        final AlertDialog alertDialog=builder.create();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
            }
        });
        v.findViewById(R.id.no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Two.this,"NO",Toast.LENGTH_LONG).show();
                alertDialog.dismiss();
            }
        });
        v.findViewById(R.id.yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Two.this,"YES",Toast.LENGTH_LONG).show();
                alertDialog.dismiss();
            }
        });
    }
}
