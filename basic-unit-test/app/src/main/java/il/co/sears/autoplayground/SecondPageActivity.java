package il.co.sears.autoplayground;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondPageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);

        Intent intent = getIntent();

        int counter = intent.getIntExtra("counter", 0);

        final TextView text = findViewById(R.id.title_text);
        text.append(String.format("After %d clicks", counter));
        final Button button = findViewById(R.id.close_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
