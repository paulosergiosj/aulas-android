package factorysolution.com.br.faculdade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editReal;
    private EditText editvDolar;
    private TextView texttDolar;
    private TextView texttEuro;
    private EditText editvEuro;
    private Button buttonCalculate;
    private Button buttonClean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Insere o layout na activity
        setContentView(R.layout.activity_main);

        // Busca os elementos da interface
        this.editReal = (EditText) this.findViewById(R.id.edit_valor);
        this.editvDolar = (EditText) this.findViewById(R.id.edit_vDolar);
        this.editvEuro = (EditText) this.findViewById(R.id.edit_vEuro);
        this.texttDolar = (TextView) this.findViewById(R.id.text_tDolar);
        this.texttEuro = (TextView) this.findViewById(R.id.text_tEuro);
        this.buttonCalculate = (Button) this.findViewById(R.id.btn_calcular);
        this.buttonClean = (Button) this.findViewById(R.id.btn_limpar);

        // Limpa os valores iniciais
        this.clearValues();

        // Adiciona evento de click no elemento
        this.buttonCalculate.setOnClickListener(this);
        this.buttonClean.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btn_limpar) {
            this.texttDolar.setText("");
            this.texttEuro.setText("");
            this.editReal.setText("");
        }
        // Verifica se o elemento clicado é o que nos interessa
        if (view.getId() == R.id.btn_calcular) {

            // Obtém o valor do EditText
            String valor = this.editReal.getText().toString();
            String valor2 = this.editvDolar.getText().toString();
            String valor3 = this.editvEuro.getText().toString();

            if (valida(valor) && valida(valor2) && valida(valor3)) {

                Double mReal = Double.valueOf(valor);
                Double mDolar = Double.valueOf(valor2);
                Double mEuro = Double.valueOf(valor3);
                // Converte valores
                this.texttDolar.setText(String.format("%.2f", mReal * mDolar));
                this.texttEuro.setText(String.format("%.2f", mReal * mEuro));
            }
            else {
                    Toast.makeText(this, "Todos os campos precisam estar preenchidos corretamente!", Toast.LENGTH_LONG).show();
                }


        }
    }

    /**
     * Limpa os valores iniciais
     */
    private void clearValues() {
        this.texttDolar.setText("");
        this.texttEuro.setText("");
    }

    private Boolean valida(String valor)
    {
        Boolean valida = false;
        if(valor.length() == 0 || valor == "." )
        {
            valida = false;
        }
        else
        {
            valida = true;
        }
        return valida;
    }


}
