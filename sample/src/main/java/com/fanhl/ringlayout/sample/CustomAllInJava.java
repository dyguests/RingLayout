package com.fanhl.ringlayout.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fanhl.ringlayout.RingLayout;


public class CustomAllInJava extends AppCompatActivity {

    private Button circle;
    private Button rect;
    private EditText startAngle;
    private Button clockwise;
    private Button counterclockwise;
    private EditText endAngle;
    private RingLayout circleLayout;
    private Button startAnglePlus;
    private Button endAnglePlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_all_in_java);

        assignViews();
    }

    private void assignViews() {
        circle = (Button) findViewById(R.id.circle);
        rect = (Button) findViewById(R.id.rect);
        startAngle = (EditText) findViewById(R.id.startAngle);
        clockwise = (Button) findViewById(R.id.clockwise);
        counterclockwise = (Button) findViewById(R.id.counterclockwise);
        endAngle = (EditText) findViewById(R.id.endAngle);
        circleLayout = (RingLayout) findViewById(R.id.circleLayout);
        startAnglePlus = (Button) findViewById(R.id.startAnglePlus);
        endAnglePlus = (Button) findViewById(R.id.endAnglePlus);

        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circleLayout.setPathShape(RingLayout.CIRCLE);
            }
        });
        rect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circleLayout.setPathShape(RingLayout.RECTANGLE);
            }
        });
        clockwise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circleLayout.setRotateDirection(RingLayout.CLOCKWISE);
            }
        });
        counterclockwise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circleLayout.setRotateDirection(RingLayout.COUNTERCLOCKWISE);
            }
        });
        startAngle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                circleLayout.setStartAngle(getAngle(startAngle));
            }
        });
        endAngle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                circleLayout.setEndAngle(getAngle(endAngle));
            }
        });
        startAnglePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plus(startAngle);
            }
        });
        endAnglePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plus(endAngle);
            }
        });
    }

    private int getAngle(EditText angle) {
        try {
            return Integer.valueOf(angle.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private void plus(EditText angleEt) {
        int angle = (getAngle(angleEt) + 5) % 360;
        angleEt.setText(String.valueOf(angle));
    }

}
