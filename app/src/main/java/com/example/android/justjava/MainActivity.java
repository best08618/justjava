package com.example.android.justjava;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    public void SubmitOrder(View view) {
        int total;
        CheckBox whippedCreamCheckbox =(CheckBox)findViewById(R.id.Whipped_Cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox. isChecked();
        CheckBox chocolate =(CheckBox)findViewById(R.id.Chocolate_checkbox);
        boolean hasChocolate = chocolate. isChecked();
        total = calculateprice(hasWhippedCream, hasChocolate);
        EditText edit = (EditText) findViewById(R.id.name_field);
        String name= edit.getText().toString();
        String ordersummary= summary(name,total,hasWhippedCream,hasChocolate);
//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for" + name);
//        intent.putExtra(Intent.EXTRA_TEXT, ordersummary );
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
            displayMessage(ordersummary);
        }
//}



    public void reset(View view) {
        int price =0;
        number = 1;
        String  priceMessage="TOTAL: ";
        displayMessage(priceMessage);
        display(number);
    }
    public String summary(String name,int price, boolean addwhippedCream,boolean addchocolate)
    {
        String summaryMessage="Summary: \n"+ "Orderer: "+ name + "\n";
                summaryMessage +="Add whipped cream? "+addwhippedCream+"\n";
        summaryMessage += "Add Chocolate? "+addchocolate+"\n";
        summaryMessage += "Quantity: "+ number+"\n"+"TOTAL: "+ price+"$"+"\nThank you:)";

        return summaryMessage;
    }
    /**
     * This method is called when the minus button is clicked.
     */
    public int calculateprice( boolean haswhippedcream, boolean haschocolate)
    {
        int total;
        int baseprice=5;
        if(haswhippedcream)
            baseprice= baseprice+ 1;
        if(haschocolate)
            baseprice= baseprice+ 2;
        total= baseprice* number;
        return total;

    }
    public void minusOrder(View view) {
        if(number>1)
        number--;
        else
        number=1;
        display(number);
    }
    /**
     * This method is called when the plus button is clicked.
     */
    public void plusOrder(View view) {
        if(number<100)
        number++;
        else
            number = 100;
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