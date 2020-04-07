/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.coffee;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Attr;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {

//    Global variable
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * These methods are called when the buttons in the XML file are clicked.
     * REMEMBER - these are public and can be accessed in other classes. These public classes can call the private classes within this file. However, private classes can't be directed called by other classes.
     * REMEMBER - Add "View view" for these public classes that are called
     */
    public void callGoUp(View view) {
        goUp();
    }

    public void callGoDown(View view) {
        goDown();
    }

    public void submitOrder(View view) {
        confirmation();
    }

    /**
     * This method displays the increment on the screen.
     */
    private void goUp() {
        TextView quant = (TextView) findViewById(R.id.quant);
        quantity = quantity + 1;
        quant.setText("" + quantity);
//        the "" above is a shortcut to change numbers to STRING!
        displayPrice();
    }

    /**
     * This method displays the decrement on the screen.
     */
    private void goDown() {
        TextView quant = (TextView) findViewById(R.id.quant);
        quantity = quantity - 1;
        quant.setText("" + quantity);
//        the "" above is a shortcut to change numbers to STRING!
        displayPrice();
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice() {
        TextView price = (TextView) findViewById(R.id.price);
        int numSum = quantity * 5;
        price.setText(NumberFormat.getCurrencyInstance().format(numSum));
    }

    /**
     * This method displays the confirmation message on the screen.
     */
    private void confirmation() {
        TextView price = (TextView) findViewById(R.id.price);
        String priceText = (String) price.getText();
        TextView quant = (TextView) findViewById(R.id.confirm);
        quant.setText("Your order has been replaced! That'd be " + priceText + ".");
    }
}
