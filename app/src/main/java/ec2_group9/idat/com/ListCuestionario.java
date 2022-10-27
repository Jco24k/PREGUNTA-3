package ec2_group9.idat.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import ec2_group9.idat.com.databinding.ActivityCuestionarioBinding;
import ec2_group9.idat.com.databinding.ActivityListCuestionarioBinding;

public class ListCuestionario extends AppCompatActivity {
    private ActivityListCuestionarioBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListCuestionarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //RECUPERNADO ARRAY LISTA DE PERSONAS
        ArrayList<String>  listaCuestionaro = (ArrayList<String>) getIntent().getSerializableExtra("listaCuestionario");

        //DEFINIENDO EL ADAPTADOR
        ArrayAdapter adapter = new ArrayAdapter(
                this, android.R.layout.simple_list_item_1,
                listaCuestionaro
        );
        //SETEAR EL LIST VIEW
        binding.lvlListCuestionario.setAdapter(adapter);
    }
}