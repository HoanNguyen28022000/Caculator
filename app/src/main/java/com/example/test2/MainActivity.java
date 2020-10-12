package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaCas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity {
    long valua1,value2;
    double ans;

    TextView input, result, operator;

    Button num_0,num_1,num_2, num_3, num_4, num_5, num_6, num_7, num_8, num_9;
    Button btn_multiply, btn_divide, btn_add, btn_sub, btn_clear, btn_results;

    boolean add=false, sub=false, mult=false, divide=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num_0= findViewById(R.id.btn_0);
        num_1= findViewById(R.id.btn_1);
        num_2= findViewById(R.id.btn_2);
        num_3= findViewById(R.id.btn_3);
        num_4= findViewById(R.id.btn_4);
        num_5= findViewById(R.id.btn_5);
        num_6= findViewById(R.id.btn_6);
        num_7= findViewById(R.id.btn_7);
        num_8= findViewById(R.id.btn_8);
        num_9= findViewById(R.id.btn_9);

        btn_add= findViewById(R.id.btn_add);
        btn_sub= findViewById(R.id.btn_substract);
        btn_divide= findViewById(R.id.btn_divide);
        btn_multiply= findViewById(R.id.btn_multiply);

        btn_clear= findViewById(R.id.btn_C);
        btn_results= findViewById(R.id.btn_equal);

        input= findViewById(R.id.input);
        result=findViewById(R.id.result);
        operator= findViewById(R.id.operator);

        num_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"0");
            }
        });
        num_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"1");
            }
        });
        num_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"2");
            }
        });
        num_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"3");
            }
        });
        num_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"4");
            }
        });
        num_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"5");
            }
        });
        num_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"6");
            }
        });
        num_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"7");
            }
        });
        num_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"8");
            }
        });
        num_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"9");
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_setEnable(false);
                button_focus(btn_add);
                add=true;
                btn_results.setEnabled(true);
            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_setEnable(false);
                button_focus(btn_sub);
                sub=true;
                btn_results.setEnabled(true);
            }
        });

        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_setEnable(false);
                button_focus(btn_multiply);
                mult=true;
                btn_results.setEnabled(true);
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_setEnable(false);
                button_focus(btn_divide);
                divide=true;
                btn_results.setEnabled(true);
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        btn_results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().equals("")){
                    btn_results.setEnabled(false);
                }
                else {
                    value2=Long.parseLong(input.getText().toString());
                    if(add) {
                        ans=valua1+value2;
                        add=false;
                    }
                    else if(sub) {
                        ans=valua1-value2;
                        sub=false;
                    }
                    else if(mult) {
                        ans=valua1*value2;
                        mult=false;
                    }
                    else if(divide) {
                        ans=valua1/value2;
                        divide=false;
                    }
                    result.setText(String.valueOf(ans));
                    valua1=(long)ans;
                    button_setEnable(true);
                    btn_results.setEnabled(false);
                }
            }
        });
        }

    public void button_setEnable(boolean bool) {
        btn_add.setEnabled(bool);
        btn_sub.setEnabled(bool);
        btn_multiply.setEnabled(bool);
        btn_divide.setEnabled(bool);
    }

    public void button_focus(Button b){
        operator.setText(b.getText());
        if (valua1==0) {
            valua1=Long.parseLong(input.getText().toString());
        }
        input.setText("");
    }
    public void reset() {
        input.setText("");
        result.setText("");
        operator.setText("");
        button_setEnable(true);
        add=false; sub=false; mult=false; divide=false;
        valua1=0;
        value2=0;
        ans=0;
    }
}