package com.example.welcome.jsontask4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private String string = "{\n" +
            "    \"glossary\": {\n" +
            "        \"title\": \"example glossary\",\n" +
            "\t\t\"GlossDiv\": {\n" +
            "            \"title\": \"S\",\n" +
            "\t\t\t\"GlossList\": {\n" +
            "                \"GlossEntry\": {\n" +
            "                    \"ID\": \"SGML\",\n" +
            "\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
            "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
            "\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
            "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
            "\t\t\t\t\t\"GlossDef\": {\n" +
            "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
            "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
            "                    },\n" +
            "\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
            "                }\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonload();
    }
    private void jsonload() {

        try {
            JSONObject jObject = new JSONObject(string);
            JSONObject glossobject = jObject.optJSONObject("glossary");
            String titleglo = glossobject.getString("title");
            Log.d("pa", "title: " + titleglo);
            JSONObject divglossobj = glossobject.optJSONObject("GlossDiv");
            String titlediv = divglossobj.getString("title");
            Log.d("pa", "title: " + titlediv);
            JSONObject listglossobj = divglossobj.getJSONObject("GlossList");
            JSONObject enteryglossobj = listglossobj.getJSONObject("GlossEntry");
            String id = enteryglossobj.getString("ID");
            Log.d("pa", "ID: " + id);
            String sort = enteryglossobj.getString("SortAs");
            Log.d("pa", "SortAs: " + sort);
            String termgloss = enteryglossobj.getString("GlossTerm");
            Log.d("pa", "GlossTerm: " + termgloss);
            String acr = enteryglossobj.getString("Acronym");
            Log.d("pa", "Acronym: " + acr);
            String abr = enteryglossobj.getString("Abbrev");
            Log.d("pa", "Abbrev: " + abr);
            JSONObject defglossobj = enteryglossobj.getJSONObject("GlossDef");
            String para = defglossobj.getString("para");
            Log.d("pa", "para: " + para);
            JSONArray glossSeeAlsoArray = defglossobj.getJSONArray("GlossSeeAlso");
            for (int i = 0; i < glossSeeAlsoArray.length(); i++) {

                String strParsedValue = "\n" + glossSeeAlsoArray.getString(i);
                Log.d("pa", "GlossSeeAlso: " + strParsedValue);
            }
            String glossSee = enteryglossobj.getString("GlossSee");
            Log.d("pa", "GlossSee: " + glossSee);
            glossobject.get("Glossary");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    }
