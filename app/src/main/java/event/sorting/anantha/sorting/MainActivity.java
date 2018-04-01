package event.sorting.anantha.sorting;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        ////// FIXME: 1/4/18
       /* Sort even numbers ascending while leaving the even ones
        on their positions: not getting this logic so i left the odd ones on their positions and sorted even numbers ascending
*/
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
                     List<Integer> newIntegerList = new ArrayList<Integer>();

                     newIntegerList = sortInteger(integerList);
//                     Collections.sort(integerList);
                     outp.setVisibility(View.VISIBLE);
                     info.setVisibility(View.VISIBLE);

                     InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                     imm.hideSoftInputFromWindow(input.getWindowToken(), 0);

                     outp.setText("");
                     for(int i=0;i<newIntegerList.size();i++){
                         if(i==newIntegerList.size()-1){
                             outp.append(newIntegerList.get(i)+"");
                         }
                         else {
                             outp.append(newIntegerList.get(i) + ",");
                         }

                     }


                 }catch (Exception e){
                     InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                     imm.hideSoftInputFromWindow(input.getWindowToken(), 0);
                     Toast.makeText(getApplicationContext(),"Please Enter the numbers properly seperated by (,)",Toast.LENGTH_SHORT).show();
                 }

             }
         });
    }

    public List<Integer> sortInteger(List<Integer> integerList){
        List<Integer> odd = new ArrayList<Integer>();
        List<Integer> even = new ArrayList<Integer>();
        List<Integer> position = new ArrayList<Integer>();

        for(int i=0;i<integerList.size();i++){
            if ((integerList.get(i)%2) == 1 || (integerList.get(i)%2) == -1) {
                odd.add(integerList.get(i));
            } else {
                even.add(integerList.get(i));
                position.add(i);
            }
            Collections.sort(even);

        }
        for(int i=0;i<position.size();i++){
            integerList.set(position.get(i),even.get(i));
        }
    return integerList;
    }

}
