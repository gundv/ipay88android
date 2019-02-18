package ipayplay1.example.neath.ipay111;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ipay.IPayIH;
import com.ipay.IPayIHPayment;
import com.ipay.IPayIHResultDelegate;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements IPayIHResultDelegate,Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IPayIHPayment payment = new IPayIHPayment();
        payment.setMerchantKey("");//From IPay88 when merchant registered
        payment.setMerchantCode("");//From IPay88 when merchant registered
        payment.setPaymentId("123");//payment method 1=VISA USD, 9=eMoney Metfone (USD), 10=eMoney Metfone (KHR), 123= E-Wings eWallet (USD), and 12`4= E-Wings eWallet (KHR)
        payment.setCurrency("USD");// valid only 'USD' or 'KHR'
        payment.setRefNo("ORD1189");
        payment.setAmount("1.00");//Must be decimal 2 digit at the end
        payment.setProdDesc("Phone");
        payment.setUserName("Nexus");
        payment.setUserEmail("email@email.com");
        payment.setUserContact("012345678");
        payment.setRemark("20181013749PM");
        payment.setCountry("KH");
        payment.setBackendPostURL("http://backend_url/ipay_response.php");

        Intent checkoutIntent = IPayIH.getInstance().checkout(payment, this,this, IPayIH.PAY_METHOD_CREDIT_CARD);
        startActivityForResult(checkoutIntent, 200);
    }

    @Override
    public void onPaymentSucceeded(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
        Log.e("onPaymentSucceeded","");
    }

    @Override
    public void onPaymentFailed(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
        Log.e("onPaymentFailed","error:"+s+s1+s2+s3+s4+s5);
    }

    @Override
    public void onPaymentCanceled(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
        Log.e("onPaymentCanceled","error:"+s+s1+s2+s3+s4+s5);
    }

    @Override
    public void onRequeryResult(String s, String s1, String s2, String s3) {
        Log.e("onRequeryResult","");
    }

    @Override
    public void onConnectionError(String s, String s1, String s2, String s3, String s4, String s5, String s6) {
        Log.e("onConnectionError","");
    }
}
