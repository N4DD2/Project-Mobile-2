package vn.edu.tdc.cal_week1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtOperator;
    private TextView txtResult;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnResult, btnPoint,
            btnAdd, btnSub, btnMul, btnDiv, btnClean, btnCleanAll;
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal_layout);

        initWidget();
        setEventClickViews();
    }

    public void initWidget(){

        edtOperator = (EditText) findViewById(R.id.edtOperator);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnAdd = (Button) findViewById(R.id.btnCong);
        btnSub = (Button) findViewById(R.id.btnTru);
        btnMul = (Button) findViewById(R.id.btnNhan);
        btnDiv = (Button) findViewById(R.id.btnChia);
        btnClean = (Button) findViewById(R.id.btnClean);
        btnCleanAll = (Button) findViewById(R.id.btnCleanAll);
        btnPoint = (Button) findViewById(R.id.btnPoint);
        btnResult = (Button) findViewById(R.id.btnResult);
    }

    public void setEventClickViews(){
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

        btnPoint.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        btnClean.setOnClickListener(this);
        btnCleanAll.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.btn0:
                edtOperator.append("0");
            break;
            case R.id.btn1:
                edtOperator.append("1");
                break;
            case R.id.btn2:
                edtOperator.append("2");
                break;
            case R.id.btn3:
                edtOperator.append("3");
                break;
            case R.id.btn4:
                edtOperator.append("4");
                break;
            case R.id.btn5:
                edtOperator.append("5");
                break;
            case R.id.btn6:
                edtOperator.append("6");
                break;
            case R.id.btn7:
                edtOperator.append("7");
                break;
            case R.id.btn8:
                edtOperator.append("8");
                break;
            case R.id.btn9:
                edtOperator.append("9");
                break;
            case R.id.btnCong:
                edtOperator.append("+");
                break;
            case R.id.btnTru:
                edtOperator.append("-");
                break;
            case R.id.btnNhan:
                edtOperator.append("*");
                break;
            case R.id.btnChia:
                edtOperator.append("/");
                break;
            case R.id.btnPoint:
                edtOperator.append(".");
                break;
            case R.id.btnResult:
                DecimalFormat df = new DecimalFormat("###.#######");
                double result = 0;
                addOperation(edtOperator.getText().toString());
                addNumber(edtOperator.getText().toString());
                if(arrOperation.size() >= arrNumber.size() || arrOperation.size() < 1)
                {
                    txtResult.setText("Sai dinh dang");
                }else {
                    for (int i = 0; i < arrNumber.size() - 1; i++) {
                        switch (arrOperation.get(i)) {
                            case "+":
                                if (i == 0) {
                                    result = arrNumber.get(i) + arrNumber.get(i + 1);
                                } else {
                                    result = result + arrNumber.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    result = arrNumber.get(i) - arrNumber.get(i + 1);
                                } else {
                                    result = result - arrNumber.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0) {
                                    result = arrNumber.get(i) * arrNumber.get(i + 1);
                                } else {
                                    result = result * arrNumber.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    result = arrNumber.get(i) / arrNumber.get(i + 1);
                                } else {
                                    result = result / arrNumber.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    txtResult.setText(df.format(result) + "");
                }
                break;
            case R.id.btnClean:
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(edtOperator, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btnCleanAll:
                edtOperator.setText("");
                txtResult.setText("");
                break;
            default:
                break;
        }
    }
    public ArrayList<String> arrOperation;
    public ArrayList<Double> arrNumber;
    public int addOperation(String input){
        arrOperation = new ArrayList<>();
        arrNumber = new ArrayList<>();
        char[] chArr = input.toCharArray();
        for(int i = 0; i < chArr.length; i++)
        {
            switch (chArr[i]){
                case '+':
                    arrOperation.add(chArr[i] + "");
                    break;
                case '-':
                    arrOperation.add(chArr[i] + "");
                    break;
                case '*':
                    arrOperation.add(chArr[i] + "");
                    break;
                case '/':
                    arrOperation.add(chArr[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }
    public void addNumber(String input){
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(input);
        while (matcher.find())
        {
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
}
