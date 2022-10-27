package ec2_group9.idat.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

import ec2_group9.idat.com.databinding.ActivityCuestionarioBinding;
import ec2_group9.idat.com.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnCuestionario.setOnClickListener(this);
    }


    private void cuestionarioActivity(){
        Intent intentLista = new Intent(this,CuestionarioActivity.class);
        startActivity(intentLista);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCuestionario: cuestionarioActivity(); break;

        }
    }
}