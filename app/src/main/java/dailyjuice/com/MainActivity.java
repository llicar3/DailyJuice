package dailyjuice.com;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button QOD = (Button) findViewById(R.id.QOD);
        Intent qodIntent = new Intent(this, SecondActivity.class);
        startActivity(qodIntent);
        //intent.getextra("QOD", String);
        QOD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.GREEN);
                Log.d("Daily Juice", "my app");
                Toast.makeText(getApplicationContext(),"Juicing!", Toast.LENGTH_SHORT).show();
                requestQuote("quoteoftheday");
                //startActivity(qodIntent);

            }
        });
        Button funnyButton = (Button) findViewById(R.id.funnyButton);
        Intent funnyIntent = new Intent(this, SecondActivity.class);
        startActivity(funnyIntent);
        funnyButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.GREEN);
                Log.d("Daily Juice", "my app");
                Toast.makeText(getApplicationContext(), "Juicing!", Toast.LENGTH_SHORT).show();
                requestQuote("funny");
            }
        }));
        Button loveButton = (Button) findViewById(R.id.loveButton);
        Intent loveIntent = new Intent(this, SecondActivity.class);
        startActivity(loveIntent);
        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.GREEN);
                Log.d("Daily Juice", "my app");
                Toast.makeText(getApplicationContext(), "Juicing!", Toast.LENGTH_SHORT).show();
                requestQuote("love");
            }
        });
        Button artButton = (Button) findViewById(R.id.artbutton);
        Intent artIntent = new Intent(this, SecondActivity.class);
        startActivity(artIntent);
        artButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.GREEN);
                Log.d("Daily Juice", "my app");
                Toast.makeText(getApplicationContext(), "Juicing!", Toast.LENGTH_SHORT).show();
                requestQuote("art");
            }
        });
        Button natureButton = (Button) findViewById(R.id.natureButton);
        Intent natureIntent = new Intent(this, SecondActivity.class);
        startActivity(natureIntent);
        natureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.GREEN);
                Log.d("Daily Juice", "my app");
                Toast.makeText(getApplicationContext(), "Juicing!", Toast.LENGTH_SHORT).show();
                requestQuote("nature");
            }
        });

    public class QuoteOfTheDay {

        public static void main(String[] args) throws IOException {

        }

        public static requestQuote(String category) {
            try {
                String urlString = "https://quotes.rest/qod?category=" + category;
                URL url = new URL(urlString);
            } catch (Exception e) {
                System.out.println("malformed url");
            }

            try {
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
                StringBuilder response = new StringBuilder(); 
                String currentLine;
                while ((currentLine = in.readLine()) != null) {
                        response.append(currentLine); 
                in.close();
                return response.toString();
                BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
                String l = null;
                while ((l=br.readLine())!=null) {
                    System.out.println(l);
                }
                br.close();
            } catch (Exception e){
                System.out.println("Error occured");
                System.out.println(e.toString());
            }
        }
    }



