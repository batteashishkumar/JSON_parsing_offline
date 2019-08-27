package com.example.json_parsing_offline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;

import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    String json;
    TextView text_id, text_jsonRaw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_id = findViewById(R.id.txt);
        text_jsonRaw = findViewById(R.id.txt1);

        json = "{\n" +
                "    \"0\": {\n" +
                "        \"id\": \"0\",\n" +
                "        \"title\": \"you will never die\"\n" +
                "    },\n" +
                "    \"1\": {\n" +
                "        \"id\": \"1\",\n" +
                "        \"title\": \"Baseball\"\n" +
                "    },\n" +
                "    \"2\": {\n" +
                "        \"id\": \"2\",\n" +
                "        \"title\": \"Two basketball team players earn all state honors\"\n" +
                "    }\n" +
                "}";
    }

    @Override
    public void onStart() {
        super.onStart();
        text_jsonRaw.setMovementMethod(new ScrollingMovementMethod());
        text_id.setMovementMethod(new ScrollingMovementMethod());
        text_jsonRaw.setText(json);
        text_id.setText("");
        try {
            JSONObject mainObject = new JSONObject(json);
            for (int i = 0; i < 3; i++) {
                JSONObject Object = mainObject.getJSONObject(String.valueOf(i));
                String name = Object.getString("id");
                String url = Object.getString("title");
                text_id.append("Id:" + name + "\nTitle:" + url + "\n");
                text_id.append("\n-------------------------------------------------------\n");

            }
        } catch (Exception e) {
        }


    }

}
