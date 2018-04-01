package event.sorting.anantha.sorting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView info,outp;
    Button sorter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         input  = (EditText) findViewById(R.id.inputArray);
         info   = (TextView) findViewById(R.id.sorted);
         outp   = (TextView) findViewById(R.id.output);
         sorter =  (Button)  findViewById(R.id.button);
         outp.setVisibility(View.INVISIBLE);
         info.setVisibility(View.INVISIBLE);

         sorter.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 try{
                     List<Integer> integerList = new ArrayList<>();

                     String  inputString = input.getText().toString();

                     String[] inputNumber =  inputString.split(",");

                     for (Object str : inputNumber) {
                         integerList.add(Integer.parseInt((String)str));
                     }
                     outp.setVisibility(View.VISIBLE);
                     info.setVisibility(View.VISIBLE);

                     StringBuilder builder = new StringBuilder();
                     outp.setText("");
                     for(int i=0;i<integerList.size();i++){
                         if(i==integerList.size()-1){
                             outp.append(integerList.get(i)+"");
                         }
                         else {
                             outp.append(integerList.get(i) + ",");
                         }

                     }


                 }catch (Exception e){
                     Toast.makeText(getApplicationContext(),"Enter the numbers properly seperated by (,)",Toast.LENGTH_SHORT).show();
                 }

             }
         });
    }
}
