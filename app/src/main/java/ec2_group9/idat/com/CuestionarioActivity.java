package ec2_group9.idat.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ec2_group9.idat.com.databinding.ActivityCuestionarioBinding;

public class CuestionarioActivity extends AppCompatActivity implements View.OnClickListener  {

    private ActivityCuestionarioBinding binding;
    private List<String> listSkills = new ArrayList<>();
    private List<String> listCuestionarioTotal = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCuestionarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.chkAutoconocimiento.setOnClickListener(this);
        binding.chkEmpatia.setOnClickListener(this);
        binding.chkCAsertiva.setOnClickListener(this);
        binding.chkTDesiciones.setOnClickListener(this);
        binding.chkPCritico.setOnClickListener(this);
        binding.chkNinguno.setOnClickListener(this);
        binding.btnResolver.setOnClickListener(this);
        binding.btnListar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnResolver:addCuestionario();  break;
            case R.id.btnListar: irListarActivity(); break;
            case R.id.chkAutoconocimiento:
                addskills(view); break;
            case R.id.chkEmpatia:
                addskills(view); break;
            case R.id.chkCAsertiva:
                addskills(view); break;
            case R.id.chkTDesiciones:
                addskills(view); break;
            case R.id.chkPCritico:
                addskills(view); break;
            case R.id.chkNinguno:
                addskills(view); break;
        }
    }

    private void addskills(View view){
        CheckBox chkSelected = (CheckBox)view;
        if(!chkSelected.getText().toString().toUpperCase().equals("Ninguno".toUpperCase())){
            if(chkSelected.isChecked()){
                listSkills.add(chkSelected.getText().toString().toUpperCase());
                listSkills.remove("ninguno".toUpperCase());
                binding.chkNinguno.setChecked(false);
            }
            else
                listSkills.remove(chkSelected.getText().toString().toUpperCase());
        }else{
            if(chkSelected.isChecked()) listSkills.add(chkSelected.getText().toString().toUpperCase());
            else listSkills.remove(chkSelected.getText().toString().toUpperCase());
            listSkills = new ArrayList<>();
            binding.chkAutoconocimiento.setChecked(false);
            binding.chkCAsertiva.setChecked(false);
            binding.chkEmpatia.setChecked(false);
            binding.chkPCritico.setChecked(false);
            binding.chkTDesiciones.setChecked(false);
            listSkills.add(chkSelected.getText().toString().toUpperCase());
        }

        System.out.println(listSkills);
    }


    private Boolean validarQuestion2(){
        Boolean respuesta = true;
        if(binding.rgQuestion2.getCheckedRadioButtonId() == -1){
            respuesta = false;
        }
        return respuesta;
    }

    private Boolean validarQuestion3(){
        Boolean respuesta = true;
        if(binding.rgQuestion3.getCheckedRadioButtonId() == -1){
            respuesta = false;
        }
        return respuesta;
    }
    private Boolean validarQuestion4(){
        Boolean respuesta = true;
        if(binding.rgQuestion4.getCheckedRadioButtonId() == -1){
            respuesta = false;
        }
        return respuesta;
    }
    private Boolean validarQuestion5(){
        Boolean respuesta = true;
        if(binding.rgQuestion5.getCheckedRadioButtonId() == -1){
            respuesta = false;
        }
        return respuesta;
    }
    private Boolean validarFormulario(){
        Boolean respuesta = false;
        String mensaje = "" ;
        if(!validateSkills()){
            mensaje = "Debe seleccionar una habilidad";
        }else if(!validarQuestion2()){
            mensaje = "Pregunta 2 oblidatorio";
        }else if(!validarQuestion3()){
            mensaje = "Pregunta 3 oblidatorio";
        }else if(!validarQuestion4()){
            mensaje = "Pregunta 4 oblidatorio";
        }else if(!validarQuestion5()){
            mensaje = "Pregunta 5 oblidatorio";
        }else{
            respuesta = true;
        }
        Toast.makeText(this,mensaje, Toast.LENGTH_LONG).show();
        return respuesta;
    }


    private Boolean validateSkills(){
        Boolean respuesta = false;
        if(binding.chkAutoconocimiento.isChecked() || binding.chkCAsertiva.isChecked() ||
                binding.chkEmpatia.isChecked() || binding.chkTDesiciones.isChecked()
                || binding.chkPCritico.isChecked() || binding.chkNinguno.isChecked()){
            respuesta = true;
        }
        return respuesta;
    }

    private String getQuestionSelected2(){
        String selected = "";
        switch (binding.rgQuestion2.getCheckedRadioButtonId()){
            case R.id.rbtMucho:
                selected = binding.rbtMucho.getText().toString(); break;
            case R.id.rbtMasoMenos:
                selected = binding.rbtMasoMenos.getText().toString(); break;
            case R.id.rbtPoco:
                selected = binding.rbtPoco.getText().toString(); break;
        }
        return selected;
    }

    private String getQuestionSelected3(){
        String selected = "";
        switch (binding.rgQuestion3.getCheckedRadioButtonId()){
            case R.id.rbtBien:
                selected = binding.rbtBien.getText().toString(); break;
            case R.id.rbtRegular:
                selected = binding.rbtRegular.getText().toString(); break;
            case R.id.rbtMal:
                selected = binding.rbtMal.getText().toString(); break;
        }
        return selected;
    }
    private String getQuestionSelected4(){
        String selected = "";
        switch (binding.rgQuestion4.getCheckedRadioButtonId()){
            case R.id.rbt4Si:
                selected = binding.rbt4Si.getText().toString(); break;
            case R.id.rbt4No:
                selected = binding.rbt4No.getText().toString(); break;
        }
        return selected;
    }
    private String getQuestionSelected5(){
        String selected = "";
        switch (binding.rgQuestion5.getCheckedRadioButtonId()){
            case R.id.rbt5Si:
                selected = binding.rbt5Si.getText().toString(); break;
            case R.id.rbt5No:
                selected = binding.rbt5No.getText().toString(); break;
        }
        return selected;
    }

    private String getSkills(){
        String skillsToString = "";
        for (String skills : listSkills){
            skillsToString += skills+"-";
        }
        return skillsToString;
    }


    private void addCuestionario(){
        if(validarFormulario()){
            StringBuilder infoCuestion = new StringBuilder();
            infoCuestion.append(getSkills());
            infoCuestion.append(getQuestionSelected2());
            infoCuestion.append(getQuestionSelected3());
            infoCuestion.append(getQuestionSelected4());
            infoCuestion.append(getQuestionSelected5());
            listCuestionarioTotal.add(infoCuestion.toString());
            Toast.makeText(this,"Persona registrada", Toast.LENGTH_LONG).show();
            cleanControls();
        }


    }

    private void cleanControls(){
        listSkills.clear();
        binding.chkAutoconocimiento.setChecked(false);
        binding.chkEmpatia.setChecked(false);
        binding.chkCAsertiva.setChecked(false);
        binding.chkPCritico.setChecked(false);
        binding.chkTDesiciones.setChecked(false);
        binding.chkNinguno.setChecked(false);
        binding.rbtBien.setChecked(false);
        binding.rbtMucho.setChecked(false);
        binding.rbtMasoMenos.setChecked(false);
        binding.rbtPoco.setChecked(false);
        binding.rbtBien.setChecked(false);
        binding.rbtRegular.setChecked(false);
        binding.rbtMal.setChecked(false);
        binding.rbt4Si.setChecked(false);
        binding.rbt4No.setChecked(false);
        binding.rbt5Si.setChecked(false);
        binding.rbt5No.setChecked(false);


    }

    private void irListarActivity(){
        Intent intentLista = new Intent(this,ListCuestionario.class);
        intentLista.putStringArrayListExtra("listaCuestionario", (ArrayList<String>) listCuestionarioTotal);
        startActivity(intentLista);
    }
}





