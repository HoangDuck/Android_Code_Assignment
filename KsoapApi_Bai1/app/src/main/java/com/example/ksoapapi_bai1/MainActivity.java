package com.example.ksoapapi_bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.config.Configuration;

import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class MainActivity extends AppCompatActivity {
    EditText txtC;
    Button btnNhap;
    TextView txtKQ;
    ProgressDialog progressDialog;
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
            public void onClick(View view) {
                xuLy();
            }
        });
    }

    private void xuLy() {
        String c=txtC.getText().toString();
        CToFTask cToFTask=new CToFTask();
        cToFTask.execute(c);
    }
    class CToFTask extends AsyncTask<String,Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtKQ.setText("");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtKQ.setText(s);
            progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(String... strings) {
            try{
                String c=strings[0];
                //tao yeu cau gui len server
                SoapObject request=new SoapObject(Configuration.NAME_SPACE,Configuration.METHOD_C_TO_F);
                //neu yeu cau nay co doi so(parameter)
                request.addProperty(Configuration.PARAMETER_CELSIOUS,c);
                //tao envelope
                SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapSerializationEnvelope.VER11);
                envelope.dotNet=true;
                //gan request cho envelope
                envelope.setOutputSoapObject(request);
                //neu co truyen du lieu kieu float, double qua lai thi  phai dki
                MarshalFloat marshalFloat=new MarshalFloat();
                marshalFloat.register(envelope);
                /*
                * neu truyen date qua lai
                * MarshalDate marshalDate=new MarshalDate();
                * marshalDate.register(envelope);
                */
                //tao loai ket noi len server
                HttpTransportSE se=new HttpTransportSE(Configuration.SERVER_URL);
                //goi lenh thuc hien ham(xu ly tren server)
                se.call(Configuration.SOAP_ACTION_C_TO_F,envelope);
                //vi ket qua tra ve la kieu chuoi (cach lay kq sau xu ly)
                //voi du lieu don dung soap primitive
                SoapPrimitive result= (SoapPrimitive) envelope.getResponse();
                return result.toString();
            }catch (Exception ex)
            {
                Log.e("LOI",ex.toString());
            }
            return null;
        }
    }
    private void addControls() {
        txtC=findViewById(R.id.txtC);
        btnNhap=findViewById(R.id.btnNhap);
        txtKQ=findViewById(R.id.txtKQ);
        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("THONG BAO");
        progressDialog.setMessage("VUI LONG CHO");
        progressDialog.setCanceledOnTouchOutside(false);
    }
}