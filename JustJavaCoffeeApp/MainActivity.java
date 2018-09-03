package com.example.lilia.justjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int quantity=1;
    int totalPrice=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText mytext = (EditText) findViewById(R.id.name_field);
        String name_field = mytext.getText().toString();

        CheckBox creamCheckBox = (CheckBox) findViewById(R.id.check_box_cream);
        boolean hasCream = creamCheckBox.isChecked();

        CheckBox chocoCheckBox = (CheckBox) findViewById(R.id.check_box_chocolate);
        boolean hasChoco = chocoCheckBox.isChecked();

        //Log.v("Main activity", "Has whiped cream: " + hasCream);
        //Log.v("Main activity", "Has chocolate: " + hasChoco);

        totalPrice = calculatePrice(hasCream, hasChoco);
        String priceMessage = createOrderSummary(totalPrice, hasCream, hasChoco, name_field);
        displayMessage(priceMessage);
        sendEmail(priceMessage, name_field);
    }

      /**
      * This method send the order summary by email.
      *
      * @param  priceMessage summary (String), to name (String)
      * */
  public void sendEmail(String priceMessage, String name_field){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps
        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava Coffees order for " + name_field);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
      if (intent.resolveActivity(getPackageManager())!= null) {
            startActivity(intent);
        }
  }
    /** This method creates an order summary
     *
     * @param totalPrice (int), hasCream (boolean), hasChoco (boolean), name (String)
     * @return text for order (String)
     */
    public String createOrderSummary(int totalPrice, boolean addCream, boolean addChoco, String name_field){
        String priceMessage  = getString(R.string.name_input)+" "+ name_field;
        priceMessage += "\n"+ getString(R.string.add_cream) +" " + addCream;
        priceMessage += "\n"+getString(R.string.add_choco)+" " + addChoco;
        priceMessage += "\n"+ getString(R.string.update_quantity)+ " " +quantity;
        priceMessage += "\n"+getString(R.string.update_total)+" "+ totalPrice;
        priceMessage += "\n"+getString(R.string.thanks);
        return (priceMessage);
    }
    /**
     * This method decrements quantity of coffees, minimum 1 coffee.
     */
    public void decrement(View view){
        if (quantity>=2) {
            quantity = quantity -1;
            displayQuantity(quantity);
            return;
        } else {
            Context mycontext = getApplicationContext();
            CharSequence mytext = getText(R.string.min_order);
            int myduration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(mycontext, mytext, myduration);
            toast.show();
            return;
        }
    }
    /**
     * This method increments quantity of coffees, maximum 10 coffees.
     */
    public void increment(View view) {
        if (quantity<=9) {
            quantity = quantity + 1;
            displayQuantity(quantity);
            return;
        } else {
            CharSequence mytext = getText(R.string.max_order);
            int myduration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, mytext, myduration);
            toast.show();
            return;
        }
    }
    /**
     * This method displays the given quantity value on the screen.
     *
     * @param number of coffees (int)
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given text on the screen.
     *
     * @param message text displayed to the user
     */
    private void displayMessage(String message) {
        TextView priceTextView = findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }
    /**
     * This method calculates the price to the client based on the quantity of coffees.
     *
     * @return totalPrice amount to be payed
     */
    private int calculatePrice(boolean hasCream, boolean hasChoco){
        int fullCup = 5;
        if (hasCream && hasChoco) {
            fullCup = 10;
        } else if (hasCream || hasChoco){
            fullCup = 7;
        }
        totalPrice = quantity * fullCup;
        Log.v("MainActivity","Calculate price: " + totalPrice);
        return totalPrice;
    }

}
