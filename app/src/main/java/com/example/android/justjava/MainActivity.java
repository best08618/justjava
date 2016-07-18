package com.example.android.justjava;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int number =1;
    /**
     * This method is called when the order button is clicked.
     */
    public void OrderSummary(View view) {
        int price;
        price= calculateprice(number);
        CheckBox whippedCreamCheckbox =(CheckBox)findViewById(R.id.Whipped_Cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox. isChecked();
        if(hasWhippedCream)
            price= price+2*number;
        summary(price, number,hasWhippedCream);

    }
    public void reset(View view) {
        int price =0;
        number = 1;
        String  priceMessage="TOTAL: ";
        displayMessage(priceMessage);
        display(number);
    }
    public void summary(int price, int number, boolean addwhippedCream)
    {
        String  summaryMessage="Summary:\n"+"Add whipped cream?"+addwhippedCream+"\n";
        summaryMessage += "Quantity: "+ number+"\n"+"TOTAL: "+ price+"$"+"\nThank you:)";
        displayMessage(summaryMessage);

    }
    /**
     * This method is called when the minus button is clicked.
     */
    public int calculateprice(int number)
    {
        int price;
        price= number* 5;
        return price;

    }
    public void minusOrder(View view) {
        number--;
        display(number);
    }
    /**
     * This method is called when the plus button is clicked.
     */
    public void plusOrder(View view) {
        number++;
        display(number);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView OrderSummaryTextView = (TextView) findViewById(R.id.OrderSummary_text_view);
        OrderSummaryTextView.setText(message);
    }
}