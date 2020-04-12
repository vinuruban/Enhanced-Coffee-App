/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.coffee;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Attr;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {

//    Global variable
    int latteCount = 0;
    int cappuCount = 0;
    int mochaCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method displays the increment on the screen.
     */
    public void increment(View view) {
        int incLatte = ((Button) findViewById(R.id.increment1)).getId();
        int incCappu = ((Button) findViewById(R.id.increment2)).getId();
        int incMocha = ((Button) findViewById(R.id.increment3)).getId();

        int clickedView = ((Button)view).getId();

//        for the above, i could have written the following instead:
//            Button incLatte = (Button) findViewById(R.id.increment1);
//            int inLatteCount = incLatte.getId();

        TextView latteText = (TextView) findViewById(R.id.quantity1);
        TextView cappuText = (TextView) findViewById(R.id.quantity2);
        TextView mochaText = (TextView) findViewById(R.id.quantity3);

        if(clickedView == incLatte) {
            latteCount = latteCount + 1;
            latteText.setText("" + latteCount);
            displayPrice();
        }
        else if (clickedView == incCappu) {
            cappuCount = cappuCount + 1;
            cappuText.setText("" + cappuCount);
            displayPrice();
        }
        else if (clickedView == incMocha) {
            mochaCount = mochaCount + 1;
            mochaText.setText("" + mochaCount);
            displayPrice();
        }

    }

    /**
     * This method displays the decrement on the screen.
     */
    public void decrement(View view) {
        int decLatte = ((Button) findViewById(R.id.decrement1)).getId();
        int decCappu = ((Button) findViewById(R.id.decrement2)).getId();
        int decMocha = ((Button) findViewById(R.id.decrement3)).getId();

        int clickedView = ((Button)view).getId();

        TextView latteText = (TextView) findViewById(R.id.quantity1);
        TextView cappuText = (TextView) findViewById(R.id.quantity2);
        TextView mochaText = (TextView) findViewById(R.id.quantity3);

        if(clickedView == decLatte) {
            if(latteCount==0) {
            }
            else {
                latteCount = latteCount - 1;
                latteText.setText("" + latteCount);
                displayPrice();
            }
        }
        else if (clickedView == decCappu) {
            if(cappuCount==0) {
            }
            else {
                cappuCount = cappuCount - 1;
                cappuText.setText("" + cappuCount);
                displayPrice();
            }
        }
        else if (clickedView == decMocha) {
            if(cappuCount==0) {
            }
            else {
                cappuCount = cappuCount - 1;
                mochaText.setText("" + cappuCount);
                displayPrice();
            }
        }
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice() {
        TextView price = (TextView) findViewById(R.id.price);
        int numSum = (latteCount * 3) + (cappuCount * 4) + (mochaCount * 5);
        price.setText(NumberFormat.getCurrencyInstance().format(numSum));
    }

    /**
     * This method displays the confirmation message on the screen.
     */
    public void submitOrder(View view) {
        TextView price = (TextView) findViewById(R.id.price);
        String priceText = (String) price.getText();
        TextView confirm = (TextView) findViewById(R.id.confirm);

        if(latteCount==0 && cappuCount==0 && mochaCount==0) {
            confirm.setText("Please select quantity");
            confirm.setTextColor(Color.BLACK);// We are changing the "state of the object" (attribute of the XML).
        }
        else if (latteCount == 0 && cappuCount == 0) {
            confirm.setText("Your order has been placed! That'd be " + priceText + ".\nOrder Summary: " + mochaCount + " x Café Mocha" );
            confirm.setTextColor(Color.BLUE);
        }
        else if (latteCount == 0 && mochaCount == 0) {
            confirm.setText("Your order has been placed! That'd be " + priceText + ".\nOrder Summary: " + cappuCount + " x Cappucinno" );
            confirm.setTextColor(Color.BLUE);
        }
        else if (cappuCount == 0 && mochaCount == 0) {
            confirm.setText("Your order has been placed! That'd be " + priceText + ".\nOrder Summary: " + latteCount + " x Café Latte" );
            confirm.setTextColor(Color.MAGENTA);
        }
        else if (latteCount == 0) {
                confirm.setText("Your order has been placed! That'd be " + priceText + ".\nOrder Summary: " + cappuCount + " x Cappucinno, " + mochaCount + " x Café Mocha" );
                confirm.setTextColor(Color.BLUE);
            }
        else if (cappuCount == 0){
                confirm.setText("Your order has been placed! That'd be " + priceText + ".\nOrder Summary: " + latteCount + " x Café Latte, " + mochaCount + " x Café Mocha" );
                confirm.setTextColor(Color.BLUE);
            }
        else if (mochaCount == 0) {
                confirm.setText("Your order has been placed! That'd be " + priceText + ".\nOrder Summary: " + latteCount + " x Café Latte, " + cappuCount + " x Cappucinno" );
                confirm.setTextColor(Color.BLUE);
            }

        else {
            confirm.setText("Your order has been placed! That'd be " + priceText + ".\nOrder Summary: " + latteCount + " x Café Latte, " + cappuCount + " x Cappucinno, " + mochaCount + " x Café Mocha");
            confirm.setTextColor(Color.BLUE);
        }

    }

    public void onCheckboxClicked(View view) {
        Button incLatte = (Button) findViewById(R.id.increment1);
        TextView latteText = (TextView) findViewById(R.id.quantity1);
        Button decLatte = (Button) findViewById(R.id.decrement1);

        Button incCappu = (Button) findViewById(R.id.increment2);
        TextView cappuText = (TextView) findViewById(R.id.quantity2);
        Button decCappu = (Button) findViewById(R.id.decrement2);

        Button incMocha = (Button) findViewById(R.id.increment3);
        TextView mochaText = (TextView) findViewById(R.id.quantity3);
        Button decMocha = (Button) findViewById(R.id.decrement3);

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox3);

        TextView price = (TextView) findViewById(R.id.price);

        int clickedView = ((CheckBox)view).getId();


        if(clickedView == checkBox1.getId()) {
            if (checkBox1.isChecked()) {
                incLatte.setEnabled(true);
                decLatte.setEnabled(true);
            }
            else{
                incLatte.setEnabled(false);
                decLatte.setEnabled(false);
                latteCount=0;
                latteText.setText("" + latteCount);
                displayPrice();
            }
        }
        else if (clickedView == checkBox2.getId()) {
            if (checkBox2.isChecked()) {
                incCappu.setEnabled(true);
                decCappu.setEnabled(true);
            }
            else{
                incCappu.setEnabled(false);
                decCappu.setEnabled(false);
                cappuCount=0;
                cappuText.setText("" + cappuCount);
                displayPrice();
            }
        }
        else if (clickedView == checkBox3.getId()) {
            if (checkBox3.isChecked()) {
                incMocha.setEnabled(true);
                decMocha.setEnabled(true);
            }
            else{
                incMocha.setEnabled(false);
                decMocha.setEnabled(false);
                mochaCount=0;
                mochaText.setText("" + mochaCount);
                displayPrice();
            }
        }
    }
}
