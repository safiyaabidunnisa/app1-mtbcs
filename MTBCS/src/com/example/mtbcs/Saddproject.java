package com.example.mtbcs;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Saddproject extends Activity {
	SQLiteDatabase db;
	EditText a,b,c,d;
	Button sub;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_saddproject);
		a=(EditText)findViewById(R.id.editText1);
		b=(EditText)findViewById(R.id.editText2);
		c=(EditText)findViewById(R.id.editText3);
		d=(EditText)findViewById(R.id.editText4);
		sub=(Button)findViewById(R.id.button1);
		db=openOrCreateDatabase("HAWK", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists pro(id varchar, name varchar,compname varchar,desc varchar);");
		sub.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(a.getText().toString().trim().length()==0||
			    		   b.getText().toString().trim().length()==0||
			    		   c.getText().toString().trim().length()==0||d.getText().toString().trim().length()==0)
			    		{
			    			Toast.makeText(getApplicationContext(),"Please Enter All Values", Toast.LENGTH_SHORT).show();
			    			return;
			    		}
				Cursor c1=db.rawQuery("select * from pro where id='"+a.getText()+"'",null);
				if(c1.moveToFirst())
				{
					Toast.makeText(Saddproject.this,"Project ID already exists",Toast.LENGTH_SHORT).show();
					return;
				}
				else
				{
				db.execSQL("INSERT INTO pro VALUES('"+a.getText()+"','"+b.getText()+"','"+c.getText()+"','"+d.getText()+"');");
	    		Toast.makeText(getApplicationContext(),"Project Added Successfully", Toast.LENGTH_SHORT).show();
	    		clearText();
	    		return;
			}
			}	
		});
	}
public void clearText()
{
	a.setText("");
	b.setText("");
	c.setText("");
	d.setText("");
}
	

}
