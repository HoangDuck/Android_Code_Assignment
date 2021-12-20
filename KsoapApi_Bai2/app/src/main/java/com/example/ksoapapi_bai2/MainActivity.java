package com.example.ksoapapi_bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.configure.Configure;
import com.example.model.SinhVien;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class MainActivity extends AppCompatActivity {
    EditText txtNhap;
    Button btnNhap;
    TextView txtMa,txtTen,txtPhone;
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
        int ma= Integer.parseInt(txtNhap.getText().toString());
        SinhVienTask sinhVienTask=new SinhVienTask();
        sinhVienTask.execute(ma);
    }
    class SinhVienTask extends AsyncTask<Integer,Void, SinhVien>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtMa.setText("");
            txtTen.setText("");
            txtPhone.setText("");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(SinhVien sinhVien) {
            super.onPostExecute(sinhVien);
            txtMa.setText(sinhVien.getMa()+"");
            txtTen.setText(sinhVien.getTen());
            txtPhone.setText(sinhVien.getPhone());
            progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected SinhVien doInBackground(Integer... integers) {
            try{
                //input
                int ma=integers[0];
                SoapObject request=new SoapObject(Configure.NAME_SPACE,Configure.METHOD_LAY_THONG_TIN);
                request.addProperty(Configure.PARAMETER_DETAIL_MA,ma);
                SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet=true;
                envelope.setOutputSoapObject(request);
                HttpTransportSE httpTransportSE=new HttpTransportSE(Configure.SERVER_URL);
                httpTransportSE.call(Configure.SOAP_ACTION,envelope);
                //output
                SoapObject data= (SoapObject) envelope.getResponse();
                SinhVien sinhVien=new SinhVien();
                if(data.hasProperty("Ma"))
                {
                    sinhVien.setMa(Integer.parseInt(data.getPropertyAsString("Ma")));
                }
                if(data.hasProperty("Ten"))
                {
                    sinhVien.setTen(data.getPropertyAsString("Ten"));
                }
                if(data.hasProperty("Phone"))
                {
                    sinhVien.setPhone(data.getPropertyAsString("Phone"));
                }
                return sinhVien;
            }catch (Exception ex)
            {
                Log.e("LOI",ex.toString());
            }
            return null;
        }
    }
    private void addControls() {
        txtNhap=findViewById(R.id.txtNhap);
        btnNhap=findViewById(R.id.btnNhap);
        txtMa=findViewById(R.id.txtMa);
        txtTen=findViewById(R.id.txtTen);
        txtPhone=findViewById(R.id.txtPhone);
        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("THONG BAO");
        progressDialog.setMessage("Vui long cho");
        progressDialog.setCanceledOnTouchOutside(false);
    }
}