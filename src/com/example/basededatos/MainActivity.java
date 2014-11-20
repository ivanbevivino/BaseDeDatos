package com.example.basededatos;

import com.example.gridview.R;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button botonIngreso;
	private TextView textoCodigo;
	private TextView textoNombre;
	private TextView textoResultado;
	private SQLiteDatabase db;
	private BasedeDatos b;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		botonIngreso = (Button) findViewById(R.id.ingreso);
		textoCodigo = (TextView) findViewById(R.id.codigo);
		textoNombre = (TextView) findViewById(R.id.nombre);
		textoResultado = (TextView) findViewById(R.id.resultado);
		// creamos la base de datos
		b = new BasedeDatos(this, "Ejemplo", null, 2);
		// la abrimos en modo escritura
		db = b.getWritableDatabase();
		
		botonIngreso.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// recuperamos los valores de los campos de texto
				String codigo = textoCodigo.getText().toString();
				String descripcion = textoNombre.getText().toString();
				
				if (!codigo.isEmpty()) {
					// creamos un ContentValue 
					ContentValues nuevoRegistro = new ContentValues();
					// insertamos los datos en el ContentValues
					nuevoRegistro.put("codigo", codigo);
					nuevoRegistro.put("nombre", descripcion);
					
					// insertamos en la base
					db.insert("Ejemplo", null, nuevoRegistro);
				
					// mostramos en el TextView
					textoResultado.append(" " + codigo + " - " + descripcion + "\n");
					
					// limpiamos los TextView
					textoCodigo.setText("");
					textoNombre.setText("");
					}
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
			getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}