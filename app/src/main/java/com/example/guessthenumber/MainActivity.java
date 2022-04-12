package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    TextView t2,t3;
    EditText e1;
    Button button,button2;

    int num;
    int count=0,input=0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        work();
    }

    public void restart(View v)
    {
        t2.setText("*****");
        work();
    }

    public void work()
    {
        num = (int)((Math.random())*(101) + 1);
        count=0;
        input=0;

        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        e1 = findViewById(R.id.e1);
        button  = findViewById(R.id.button);
        button2 =findViewById(R.id.button2);

        t3.setText("ENTER ANY NUMBER BETWEEN 1 TO 100");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                input = Integer.parseInt(e1.getText().toString());
                count++;
                if(input<num)
                {
                    t3.setText("Enter larger value");
                }
                else if(input>num)
                {
                    t3.setText("Enter smaller value");
                }
                else
                {
                    t2.setText(String.valueOf(num));
                    t3.setText("YAAY!!  you guessed it right");
                    Toast.makeText(view.getContext(), "you took " + count + " guesses" , Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}