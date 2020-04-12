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
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
            Toast.makeText(this, "Please select quantity", Toast.LENGTH_SHORT).show();
        }
        else if (latteCount == 0 && cappuCount == 0) {
            confirm.setText("Your order has been placed! That'd be " + priceText + ".\nOrder Summary: " + mochaCount + " x Café Mocha" );
        }
        else if (latteCount == 0 && mochaCount == 0) {
            confirm.setText("Your order has been placed! That'd be " + priceText + ".\nOrder Summary: " + cappuCount + " x Cappucinno" );
        }
        else if (cappuCount == 0 && mochaCount == 0) {
            confirm.setText("Your order has been placed! That'd be " + priceText + ".\nOrder Summary: " + latteCount + " x Café Latte" );
        }
        else if (latteCount == 0) {
                confirm.setText("Your order has been placed! That'd be " + priceText + ".\nOrder Summary: " + cappuCount + " x Cappucinno, " + mochaCount + " x Café Mocha" );
            }
        else if (cappuCount == 0){
                confirm.setText("Your order has been placed! That'd be " + priceText + ".\nOrder Summary: " + latteCount + " x Café Latte, " + mochaCount + " x Café Mocha" );
            }
        else if (mochaCount == 0) {
                confirm.setText("Your order has been placed! That'd be " + priceText + ".\nOrder Summary: " + latteCount + " x Café Latte, " + cappuCount + " x Cappucinno" );
            }

        else {
            confirm.setText("Your order has been placed! That'd be " + priceText + ".\nOrder Summary: " + latteCount + " x Café Latte, " + cappuCount + " x Cappucinno, " + mochaCount + " x Café Mocha");
        }

    }

    public void onCheckboxClicked(View view) {

//        To control the visibilty of the layout as a whole
        LinearLayout layout1 = (LinearLayout) findViewById(R.id.layout1);
        LinearLayout layout2 = (LinearLayout) findViewById(R.id.layout2);
        LinearLayout layout3 = (LinearLayout) findViewById(R.id.layout3);

        TextView latteText = (TextView) findViewById(R.id.quantity1);
        TextView cappuText = (TextView) findViewById(R.id.quantity2);
        TextView mochaText = (TextView) findViewById(R.id.quantity3);

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox3);

        TextView price = (TextView) findViewById(R.id.price);

        int clickedView = ((CheckBox)view).getId();


        if(clickedView == checkBox1.getId()) {
            if (checkBox1.isChecked()) {
                layout1.setVisibility(view.VISIBLE);
            }
            else{
                layout1.setVisibility(view.GONE);
                latteCount=0;
                latteText.setText("" + latteCount);
                displayPrice();
            }
        }
        else if (clickedView == checkBox2.getId()) {
            if (checkBox2.isChecked()) {
                layout2.setVisibility(view.VISIBLE);
            }
            else{
                layout2.setVisibility(view.GONE);
                cappuCount=0;
                cappuText.setText("" + cappuCount);
                displayPrice();
            }
        }
        else if (clickedView == checkBox3.getId()) {
            if (checkBox3.isChecked()) {
                layout3.setVisibility(view.VISIBLE);
            }
            else{
                layout3.setVisibility(view.GONE);
                mochaCount=0;
                mochaText.setText("" + mochaCount);
                displayPrice();
            }
        }
    }
}
