package dailyjuice.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String quote = intent.getStringExtra("quote");
        System.out.println("quote from second activity: " + quote);
        TextView textView = findViewById(R.id.textView);
        textView.setText(quote);
        String c = intent.getStringExtra("category");
        TextView category = findViewById(R.id.category);
        category.setText(c);
    }
}
