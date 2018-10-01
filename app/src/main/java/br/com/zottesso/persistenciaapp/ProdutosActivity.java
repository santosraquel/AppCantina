package br.com.zottesso.persistenciaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ProdutosActivity extends AppCompatActivity {

    private TextView textProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        textProdutos = (TextView) findViewById(R.id.textProdutos);

        // Buscar todos os produtos do banco
        List<Produto> produtos = Produto.listAll(Produto.class);

        // Guardar um texto com todos os produtos e valores
        String texto = "";

        // Percorrer a lista de produtos para montar o texto da tela
        for(Produto p : produtos){

            // Exemplo:
            // Salgado - R$3.80 e \n para quebrar a linha do TextView
            // texto = texto + "";
            texto += p.getNome() + " - R$" + p.getValor() + "\n";

        }

        // Define o texto no textview
        textProdutos.setText(texto);
    }
}
