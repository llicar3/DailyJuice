package dailyjuice.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, MainActivity.class);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Button backSpace = (Button) findViewById(R.id.QOD);
        //backSpace.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
                //v.setBackgroundColor(Color.GREEN);
                //Log.d("Daily Juice", "my app");
                //Toast.makeText(getApplicationContext(),"Juicing!", Toast.LENGTH_SHORT).show();

    }
}
