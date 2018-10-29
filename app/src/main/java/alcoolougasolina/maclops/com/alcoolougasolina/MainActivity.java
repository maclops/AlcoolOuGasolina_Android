package alcoolougasolina.maclops.com.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);

    }

    public void calcularPreco(View view) {

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        Boolean camposValidados = this.validarCampos(precoAlcool, precoGasolina);
        if (camposValidados) {
            this.calcularMelhorPreco(precoAlcool, precoGasolina);
        } else {
            textResultado.setText("Preencha os preços primeiro!");
        }

    }

    public void calcularMelhorPreco(String pAlcool, String pGasolina) {
        Double precoAlcool = Double.parseDouble(pAlcool);
        Double precoGasolina = Double.parseDouble(pGasolina);

        Double resultado = precoAlcool/precoGasolina;
        if(resultado >= 0.7) {
            textResultado.setText("Melhor utilizado Gasolina!");
        } else {
            textResultado.setText("Melhor utilizar Álcool!");
        }

    }

    public boolean validarCampos(String pAlcool, String pGasolina) {

        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }

        return camposValidados;
    }

}