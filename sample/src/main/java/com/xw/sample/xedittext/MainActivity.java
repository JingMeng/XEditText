package com.xw.sample.xedittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xw.repo.XEditText;


public class MainActivity extends AppCompatActivity {

    private XEditText clearXEdit;
    private XEditText customXEdit;
    private XEditText showXEdit;
    private TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clearXEdit = (XEditText) findViewById(R.id.clear_marker_edit_text);
        customXEdit = (XEditText) findViewById(R.id.custom_edit_text);
        showXEdit = (XEditText) findViewById(R.id.show_separator_edit_text);
        textView1 = (TextView) findViewById(R.id.text1);
        textView2 = (TextView) findViewById(R.id.text2);
        Button button = (Button) findViewById(R.id.show_pattern_btn);

        customXEdit.setPattern(new int[]{4, 4, 4, 4});

        clearXEdit.setOnXTextChangeListener(new XEditText.OnXTextChangeListener() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                textView1.setText(clearXEdit.getTrimmedString());
            }
        });
        customXEdit.setOnXTextChangeListener(new XEditText.OnXTextChangeListener() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                textView2.setText(customXEdit.getTrimmedString());
            }
        });

        showXEdit.setSeparator(" ");
        showXEdit.setPattern(new int[]{3, 4, 4});
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showXEdit.setTextToSeparate("13800000000");
                }
            });
        }
    }

}
