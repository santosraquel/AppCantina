package br.com.zottesso.persistenciaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText valor;
    private Button salvar;
    private DecimalFormat df;
    private Button listarProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        df = new DecimalFormat("#0.00");

        // Configura as variáveis daqui para manipular os elementos da tela
        nome = (EditText) findViewById(R.id.editNome);
        valor = (EditText) findViewById(R.id.editValor);
        salvar = (Button) findViewById(R.id.btnSalvar);
        listarProdutos = (Button) findViewById(R.id.btnListar);

        // Evento de clique no botão salvar
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Tenta executar o código abaixo
                try {
                    // Criar objeto para salvar os valores dos campos
                    Produto p = new Produto();

                    // Definir o nome do produto, buscando o valor digitado no campo e convertendo para String
                    p.setNome( nome.getText().toString() );

                    // Busca o valor e converte para Double
                    p.setValor( Double.parseDouble( valor.getText().toString() ) );

                    // Salvar objeto no banco
                    p.save();

                    // Exibe uma mensagem para o usuário
                    Toast.makeText(MainActivity.this, p.getNome() + " cadastrado!", Toast.LENGTH_SHORT).show();

                    // Limpa os campos
                    nome.setText("");
                    valor.setText("");


                    // Da foco no campo nome
                    nome.requestFocus();



                // Caso o código acima apresente algum erro, faz o código abaixo
                } catch (Exception e){

                    // Apresenta uma mensagem na tela
                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();

                }

            }
        });


        // Chama a outra tela ao clicar no listar
        listarProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Chama a outra tela
                startActivity( new Intent(MainActivity.this, ProdutosActivity.class) );

            }
        });

        // Executar o projeto com este código uma vez só para criar o banco
        // Depois pode deixar comentado
        //SugarContext.init(getApplicationContext());
        //SchemaGenerator schemaGenerator = new SchemaGenerator(this);
        //schemaGenerator.createDatabase(new SugarDb(this).getDB());

        // Exemplo de uso do SugarORM para salvar objetos no banco
        //Produto p = new Produto();
        //p.setNome("Salgado");
        //p.setValor(3.80);
        // chamar o método save()
        //p.save();

    }
}
