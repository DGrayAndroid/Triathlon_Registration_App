package dalton.gray.triathlonregistrationapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    final int costPerMember = 725;

    int teamSize;
    double totalCost;
    String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText textTeamSize = (EditText)findViewById(R.id.textTeamSize);
        final Spinner choiceLocation = (Spinner)findViewById(R.id.choiceLocation);

        Button costButton = (Button)findViewById(R.id.buttonCost);
        costButton.setOnClickListener(new View.OnClickListener() {
            final TextView result = (TextView)findViewById(R.id.tvResults);
            @Override
            public void onClick(View view) {
                teamSize = Integer.parseInt(textTeamSize.getText().toString());
                totalCost = teamSize * costPerMember;
                DecimalFormat currencyUSD = new DecimalFormat("$###,###.##");
                location = choiceLocation.getSelectedItem().toString();
                result.setText(location + " race team fee is " + currencyUSD.format(totalCost));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
