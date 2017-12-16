package com.e.s.wordplay;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener,View.OnDragListener {
    private TextView text1,text2,text3,text4,text5,text6,text7,text8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1=(TextView)findViewById(R.id.option_1);
        text2=(TextView)findViewById(R.id.option_2);
        text3=(TextView)findViewById(R.id.option_3);
        text4=(TextView)findViewById(R.id.option_4);
        text5=(TextView)findViewById(R.id.choice_1);
        text6=(TextView)findViewById(R.id.choice_2);
        text7=(TextView)findViewById(R.id.choice_3);
        text8=(TextView)findViewById(R.id.choice_4);

        text8.setOnTouchListener(this);
        text7.setOnTouchListener(this);
        text6.setOnTouchListener(this);
        text5.setOnTouchListener(this);
        text1.setOnDragListener(this);
        text2.setOnDragListener(this);
        text3.setOnDragListener(this);
        text4.setOnDragListener(this);
    }
    @Override
    public  boolean onTouch(View v, MotionEvent event){
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(null, shadowBuilder, v, 0);
            return true;
        }
        else return false;
    }
    @Override
    public boolean onDrag(View v, DragEvent event) {
        if (event.getAction()==DragEvent.ACTION_DROP)

        {
            TextView dropped = (TextView)event.getLocalState();
            TextView dropTarget = (TextView) v;
            if(text1.getText().toString().equals(text6.getText().toString())){
                dropTarget.setText(dropped.getText());
                dropTarget.setTextColor(Color.rgb(255,192,203));
            }
        }
        return true;
    }

}
