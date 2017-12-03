package com.beatricefarias.coffii;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * @param quantity is a quantity variable
     * @param whippedCreamState is a state of checkbox, can be true or false
     * @param chocolateState is a state of checkbox, can be true or false
     */

    int quantity = 1;
    boolean whippedCreamState = false;
    boolean chocolateState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayQuantity();
        incrementButton();
        decrementButton();
        addWhippedCream();
        displaySummary();
        addChocolate();
        submitOrder();
    }

    /**
     *  Constants which will not change when changing activity.
     */

    static final String STATE_QUANTITY = "quantity";
    static final String STATE_WHIPPED_CREAM = "whippedCreamState";
    static final String STATE_CHOCOLATE = "chocolateState";

    /**
     * Method saves current state information with a collection of key value pairs.
     */

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(STATE_QUANTITY, quantity);
        savedInstanceState.putBoolean(STATE_WHIPPED_CREAM, whippedCreamState);
        savedInstanceState.putBoolean(STATE_CHOCOLATE, chocolateState);


        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Method restores values from previous activity.
     * @param savedInstanceState
     */

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        quantity = savedInstanceState.getInt(STATE_QUANTITY);
        whippedCreamState = savedInstanceState.getBoolean(STATE_WHIPPED_CREAM);
        chocolateState = savedInstanceState.getBoolean(STATE_CHOCOLATE);

        displayQuantity();
        incrementButton();
        decrementButton();
        addWhippedCream();
        displaySummary();
        addChocolate();
        submitOrder();
    }



    /**
     * Method to display quantity in quantity text view.
     */

    public void displayQuantity() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    /**
     * Method which sets up a listener for increment button and adds quantity + 1.
     */

    public void incrementButton() {
        ImageButton increment = (ImageButton) findViewById(R.id.increment_image_button);
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity >= 99) {

                    Context context = getApplicationContext();
                    CharSequence text = getString(R.string.hundred_message);
                    int duration = Toast.LENGTH_SHORT;

                    Toast hundredCoffeeToast = Toast.makeText(context, text, duration);
                    hundredCoffeeToast.setGravity(Gravity.TOP, 0, 76);
                    hundredCoffeeToast.show();

                    return;
                }

                quantity += 1;
                displayQuantity();
                displayPrice();
                displaySummary();
            }
        });
    }

    /**
     * Method which sets up a listener for decrement button and decrements quantity by - 1.
     */

    public void decrementButton() {
        ImageButton decrement = (ImageButton) findViewById(R.id.decrement_image_button);
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity <= 1) {

                    Context context = getApplicationContext();
                    CharSequence text = getString(R.string.one_message);
                    int duration = Toast.LENGTH_SHORT;

                    Toast oneCoffeeToast = Toast.makeText(context, text, duration);
                    oneCoffeeToast.setGravity(Gravity.TOP, 0, 76);
                    oneCoffeeToast.show();

                    return;
                }
                quantity -= 1;
                displayQuantity();
                displayPrice();
                displaySummary();
            }
        });
    }

    /**
     * Method which sets up a listener for whipped cream checkbox.
     */

    public void addWhippedCream() {

        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        whippedCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whippedCreamState = !whippedCreamState;
                displayPrice();
                displaySummary();
            }
        });
    }

    /**
     * Method which sets up a listener for chocolate checkbox.
     */

    public void addChocolate() {

        final CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        chocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chocolateState = !chocolateState;
                displayPrice();
                displaySummary();
            }
        });
    }

    /**
     * A method to calculate and display price according to all inputs user gave
     * @return final price for all coffee, with whipped cream or chocolate, depending of what user specified
     */

    public int displayPrice() {
        int chocolatePrice = 0;
        if (chocolateState){
            chocolatePrice = 2;
        }

        int whippedCreamPrice = 0;
        if (whippedCreamState){
            whippedCreamPrice = 1;
        }

        int totalPrice = quantity * (3 + chocolatePrice + whippedCreamPrice);
        TextView price = (TextView) findViewById(R.id.price_text_view);
        price.setText(totalPrice + getString(R.string.currency_sign));
        return totalPrice;
    }

    /**
     * Displays summary in summary text view according to what user specified
     * @return order summary string which can be later used for email
     */

    public String displaySummary() {

        String chocolateMessage = getString(R.string.status_no);
        if (chocolateState){
            chocolateMessage = getString(R.string.status_yes);
        }

        String whippedCreamMessage = getString(R.string.status_no);
        if (whippedCreamState){
            whippedCreamMessage = getString(R.string.status_yes);
        }

        TextView summary = (TextView) findViewById(R.id.summary_text_view);

        String orderSummary = getString(R.string.quantity_summary)+ quantity;
        orderSummary += getString(R.string.whipped_cream_summary) + whippedCreamMessage;
        orderSummary += getString(R.string.chocolate_summary) + chocolateMessage;

        summary.setText(orderSummary);
        return orderSummary;
    }

    /**
     * Methods which sends data to a preferred email app
     */

    public void submitOrder() {
        Button submitButton = (Button) findViewById(R.id.submit_order);
        submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent sendOrder = new Intent(Intent.ACTION_SENDTO);
                    sendOrder.setData(Uri.parse("mailto:"));
                    sendOrder.putExtra(Intent.EXTRA_EMAIL, new String[]{"coffeeTimeApp@example.com"});
                    sendOrder.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
                    sendOrder.putExtra(Intent.EXTRA_TEXT, displaySummary() + getString(R.string.price) + displayPrice()
                            + getString(R.string.currency_sign) + getString(R.string.thank_you));

                    if (sendOrder.resolveActivity(getPackageManager()) != null) {
                        startActivity(sendOrder);
                    }
                }
            }
        );
    }

}
