package com.example.lab_rmp_4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {
    DatePicker datePicker;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Извлечение имени пользователя из Intent и вывод в TextView
        String userName = getIntent().getStringExtra("userName");
        TextView tvUserName = findViewById(R.id.tvUserName);
        tvUserName.setText(userName);

        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);

        Button btnOk = findViewById(R.id.btnOk);
        btnOk.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            calendar.set(datePicker.getYear(),
                    datePicker.getMonth(),
                    datePicker.getDayOfMonth(),
                    timePicker.getCurrentHour(),
                    timePicker.getCurrentMinute());
            long millis = calendar.getTimeInMillis();

            // Передача выбранной даты в виде милисекунд
            Intent resultIntent = new Intent();
            resultIntent.putExtra("selectedDate", millis);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}