package com.example.ksoapapi_bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.config.Configure;
import com.example.model.SinhVien;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnNhap;
    ProgressDialog progressDialog;
    ListView lvDS;
    ArrayList<SinhVien>dsSV;
    ArrayAdapter<SinhVien>arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLy();
            }
        });
    }

    private void xuLy() {
        ListTask listTask=new ListTask();
        listTask.execute();
    }
    class ListTask extends AsyncTask<Void,Void,ArrayList<SinhVien>>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            arrayAdapter.clear();
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(ArrayList<SinhVien> sinhViens) {
            super.onPostExecute(sinhViens);
            arrayAdapter.clear();
            arrayAdapter.addAll(sinhViens);
            progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<SinhVien> doInBackground(Void... voids) {
            ArrayList<SinhVien>ds=new ArrayList<SinhVien>();
            try{
                SoapObject request=new SoapObject(Configure.NAME_SPACE,Configure.METHOD_DETAIL_GETLIST);
                SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet=true;
                envelope.setOutputSoapObject(request);
                HttpTransportSE httpTransportSE=new HttpTransportSE(Configure.SERVER_URL);
                httpTransportSE.call(Configure.SOAP_ACTION,envelope);
                SoapObject data= (SoapObject) envelope.getResponse();
                for(int i=0;i<data.getPropertyCount();i++)
                {
                    SoapObject soapObject= (SoapObject) data.getProperty(i);
                    SinhVien sinhVien=new SinhVien();
                    if(soapObject.hasProperty("Ma"))
                    {
                        sinhVien.setMa(Integer.parseInt(soapObject.getPropertyAsString("Ma")));
                    }
                    if(soapObject.hasProperty("Ten"))
                    {
                        sinhVien.setTen(soapObject.getPropertyAsString("Ten"));
                    }
                    if(soapObject.hasProperty("Phone"))
                    {
                        sinhVien.setPhone(soapObject.getPropertyAsString("Phone"));
                    }
                    ds.add(sinhVien);
                }
                return ds;
            }catch (Exception exception)
            {
                Log.e("LOI",exception.toString());
            }
            return null;
        }
    }
    private void addControls() {
        btnNhap=findViewById(R.id.btnNhap);
        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("THONG BAO");
        progressDialog.setMessage("VUI LONG CHO");
        progressDialog.setCanceledOnTouchOutside(false);
        lvDS=findViewById(R.id.lvDS);
        dsSV=new ArrayList<SinhVien>();
        arrayAdapter=new ArrayAdapter<SinhVien>(MainActivity.this, android.R.layout.simple_list_item_1,dsSV);
        lvDS.setAdapter(arrayAdapter);
    }
}