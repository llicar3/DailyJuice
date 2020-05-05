package dailyjuice.com;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    public static String category = "";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        category = "";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button QOD = (Button) findViewById(R.id.QOD);
        QOD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.GREEN);
                Log.d("Daily Juice", "my app");
                Toast.makeText(getApplicationContext(), "Juicing!", Toast.LENGTH_SHORT).show();
                Quote q = new Quote(getApplicationContext());
                category = "Quote of the Day";
                q.execute("");
                //String quote = q.requestQuote("QOD");
                //qodIntent.putExtra("quote", quote);
                //startActivity(qodIntent);
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
                Quote q = new Quote(getApplicationContext());
                category = "Funny";
                q.execute("funny");
                //String quote = q.requestQuote("funny");
                //funnyIntent.putExtra("quote", quote);
                //startActivity(funnyIntent);
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
                Quote q = new Quote(getApplicationContext());
                category = "Love";
                q.execute("love");
                //String quote = q.requestQuote("QOD");
                //loveIntent.putExtra("quote", quote);
                //startActivity(loveIntent);
            }
        });

        Button artButton = (Button) findViewById(R.id.artButton);
        artButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent artIntent = new Intent(getApplicationContext(), SecondActivity.class);
                v.setBackgroundColor(Color.GREEN);
                Log.d("Daily Juice", "my app");
                Toast.makeText(getApplicationContext(), "Juicing!", Toast.LENGTH_SHORT).show();
                Quote q = new Quote(getApplicationContext());
                category = "Art";
                q.execute("art");
                //String quote = q.requestQuote("QOD");
                //artIntent.putExtra("quote", quote);
                //startActivity(artIntent);
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
                Quote q = new Quote(getApplicationContext());
                category = "Nature";
                q.execute("nature");
                //String quote = q.requestQuote("QOD");
                //natureIntent.putExtra("quote", quote);
                //startActivity(natureIntent);
            }
        });
    }

    public void startNewActivity(String quote) {
        System.out.println("about to start new activity with quote: " + quote);
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("quote", quote);
        intent.putExtra("category", category);
        startActivity(intent);
    }

    private class Quote extends AsyncTask<String, Void, String> {
        private TextView finalResult;
        private Context context;
        private Quote(Context context) {
            this.context = context.getApplicationContext();
            System.out.println("context: " + context);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... category) {
            System.out.println("category: " + Arrays.toString(category));
            return requestQuote(category[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            System.out.println("quote: " + result);
            try {
                JSONObject json = new JSONObject(result);
                JSONObject contents = json.getJSONObject("contents");
                JSONArray quotes = contents.getJSONArray("quotes");
                JSONObject quote = quotes.getJSONObject(0);
                String q = quote.getString("quote");
                System.out.println("q: " + q);
                startNewActivity(q);

                super.onPostExecute(result);
            } catch (Exception e) {
                System.out.println("threw json exception" + e.toString());
            }
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
                urlc.setRequestProperty("X-TheySaidSo-Api-Secret", "Icw5mQvxNnr5r00_UHKs6geF");
                System.out.println("Connect to: " + url.toString());
                urlc.setAllowUserInteraction(false);
                urlc.connect();

                int responseCode = urlc.getResponseCode();

                //get result
                String currentLine;
                InputStream inputStream;
                if (200 <= responseCode && responseCode <= 299) {
                    inputStream = urlc.getInputStream();
                } else {
                    inputStream = urlc.getErrorStream();
                }

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

};



