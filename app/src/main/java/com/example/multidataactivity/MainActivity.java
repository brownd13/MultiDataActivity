/* Daniel Brown
 * Passing data between activities
 * 2023-02-08
 */

package com.example.multidataactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity
        extends AppCompatActivity
        implements View.OnClickListener
{
    private Button button01;
    private Button button02;
    public static final String EXTRA_MESSAGE = "com.example.multidataactivity.extra.MESSAGE";
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button01 = findViewById(R.id.dataSum);
        button01.setOnClickListener(this);
        button02 = findViewById(R.id.buttonSend);
        button02.setOnClickListener(this);
        mMessageEditText = findViewById(R.id.textInput);
    }
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.dataSum:
                String msg = "test";
                Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.buttonSend:
                launchSecondAct(view);
                break;
        }
    }
    public void launchSecondAct(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}

