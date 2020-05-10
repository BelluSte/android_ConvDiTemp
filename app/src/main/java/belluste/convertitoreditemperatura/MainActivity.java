package belluste.convertitoreditemperatura;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button converti, inverti;
    private TextView output, tipo, in, out;
    private EditText input;
    private boolean inv = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        converti = findViewById(R.id.converti);
        inverti = findViewById(R.id.inverti);
        in = findViewById(R.id.origine);
        out = findViewById(R.id.risultato);
        tipo = findViewById(R.id.tipo);
        output = findViewById(R.id.output);
        input = findViewById(R.id.input);
    }

    public void doConverti(View view) {
        if (inv) {
            String fahrenheit = input.getText().toString();
            int f = 0;
            if (fahrenheit.contains(".") || fahrenheit.contains(",")) {
                double prov = Double.parseDouble(fahrenheit);
                f = (int)prov;
            } else {
                f = Integer.parseInt(fahrenheit);
            }
            double c = (double)(f - 32) / 1.8;
            output.setText(Double.toString(c));
        } else {
            String celsius = input.getText().toString();
            double c = Double.parseDouble(celsius);
            int f = (int)(c * 1.8 + 32);
            output.setText(Integer.toString(f));
        }
    }

    public void doInverti(View view) {
        if (!inv) {
            input.getText().clear();
            output.setText("");
            tipo.setText("da °F a °C");
            in.setText("°F");
            out.setText("°C");
            inv = true;
        } else {
            input.getText().clear();
            output.setText("");
            tipo.setText("da °C a °F");
            in.setText("°C");
            out.setText("°F");
            inv = false;
        }
    }
}
