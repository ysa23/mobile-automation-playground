package il.co.sears.autoplayground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.click_me_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView textView = findViewById(R.id.hello_text);
                textView.setText(String.format("Hello. I've been clicked %d times", ++counter));
            }
        });
    }
}
