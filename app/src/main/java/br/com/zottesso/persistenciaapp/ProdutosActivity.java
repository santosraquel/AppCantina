package br.com.zottesso.persistenciaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ProdutosActivity extends AppCompatActivity {

    private TextView textProdutos;
    private ListView listaProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);


        listaProd= (ListView) findViewById(R.id.listaProd);


        // Buscar todos os produtos do banco
        List<Produto> produtos = Produto.listAll(Produto.class);



        //ListView

        ArrayAdapter adapter = new ArrayAdapter (this, android.R.layout.simple_list_item_1, produtos);

         listaProd.setAdapter(adapter);





    }
}
