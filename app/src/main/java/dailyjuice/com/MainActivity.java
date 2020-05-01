package dailyjuice.com;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button QOD = (Button) findViewById(R.id.QOD);
        QOD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent qodIntent = new Intent(getApplicationContext(), SecondActivity.class);
                v.setBackgroundColor(Color.GREEN);
                Log.d("Daily Juice", "my app");
                Toast.makeText(getApplicationContext(), "Juicing!", Toast.LENGTH_SHORT).show();
                Quote QOD = new Quote();
                String quote = QOD.requestQuote("QOD");
                qodIntent.putExtra("quote", quote);
                startActivity(qodIntent);
                //startActivity(qodIntent);

            }
        });

        Button funnyButton = (Button) findViewById(R.id.funnyButton);
        funnyButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent funnyIntent = new Intent(getApplicationContext(), SecondActivity.class);
                v.setBackgroundColor(Color.GREEN);
                Log.d("Daily Juice", "my app");
                Toast.makeText(getApplicationContext(), "Juicing!", Toast.LENGTH_SHORT).show();
                Quote q = new Quote();
                String quote = q.requestQuote("funny");
                funnyIntent.putExtra("quote", quote);
                startActivity(funnyIntent);
            }
        }));

        Button loveButton = (Button) findViewById(R.id.loveButton);
        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loveIntent = new Intent(getApplicationContext(), SecondActivity.class);
                v.setBackgroundColor(Color.GREEN);
                Log.d("Daily Juice", "my app");
                Toast.makeText(getApplicationContext(), "Juicing!", Toast.LENGTH_SHORT).show();
                Quote q = new Quote();
                String quote = q.requestQuote("love");
                loveIntent.putExtra("quote", quote);
                startActivity(loveIntent);
            }
        });

        Button artButton = (Button) findViewById(R.id.artbutton);
        artButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent artIntent = new Intent(getApplicationContext(), SecondActivity.class);
                v.setBackgroundColor(Color.GREEN);
                Log.d("Daily Juice", "my app");
                Toast.makeText(getApplicationContext(), "Juicing!", Toast.LENGTH_SHORT).show();
                Quote q = new Quote();
                String quote = q.execute("funny");
                artIntent.putExtra("quote", quote);
                startActivity(artIntent);
            }
        });

        Button natureButton = (Button) findViewById(R.id.natureButton);
        natureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent natureIntent = new Intent(getApplicationContext(), SecondActivity.class);
                v.setBackgroundColor(Color.GREEN);
                Log.d("Daily Juice", "my app");
                Toast.makeText(getApplicationContext(), "Juicing!", Toast.LENGTH_SHORT).show();
                Quote q = new Quote();
                String quote = q.requestQuote("nature");
                natureIntent.putExtra("quote", quote);
                startActivity(natureIntent);
            }
        });
    }
};

class Quote extends AsyncTask<String, String, String> {

    protected String doInBackground(String category) {
        requestQuote(category);
    }

    public String requestQuote(String category){
        StringBuilder response = new StringBuilder();
        try {
            String urlString = "https://quotes.rest/qod?category=" + category;
            URL url = new URL(urlString);
            //make connection
            HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
            urlc.setRequestMethod("GET");
            // set the content type
            urlc.setRequestProperty("Content-Type", "application/json");
            urlc.setRequestProperty("X-TheySaidSo-Api-Secret", "YOUR API KEY HERE");
            System.out.println("Connect to: " + url.toString());
            urlc.setAllowUserInteraction(false);
            urlc.connect();

            //get result
            String currentLine;
            InputStream inputStream = null;
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            inputStream));
            while ((currentLine = in.readLine()) != null) {
                response.append(currentLine);
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return response.toString();
    }
};


