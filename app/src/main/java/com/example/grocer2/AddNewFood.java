package com.example.grocer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewFood extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.foodlistsql.REPLY";
    public static final String UPC_REPLY = "com.example.android.foodlistsql.REPLY";

    private EditText mEditFoodNameView;
    private EditText mEditFoodUPCView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_food);
        mEditFoodNameView = findViewById(R.id.edit_name);
        mEditFoodUPCView = findViewById(R.id.edit_upc);
        final Button saveButton = findViewById(R.id.button_save);
        final Button cancelButton = findViewById(R.id.button_cancel);
        final Bundle extras = new Bundle();


        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditFoodNameView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String food = mEditFoodNameView.getText().toString();
                    long upc = Long.parseLong(mEditFoodUPCView.getText().toString());
                    extras.putString("FOOD_NAME", food);
                    extras.putLong("UPC_CODE", upc);
                    replyIntent.putExtras(extras);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                setResult(RESULT_CANCELED, replyIntent);
                finish();
            }
        });
    }
}
