package com.beatricefarias.singlescreenappproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makePhoneActive();
        makeEmailActive();
        makeWebsiteActive();
    }

    /**
     * This method sets on click listener to phone information.
     * When pressed intent is sent to a phone.
     */

    public void makePhoneActive() {
        final String uri = "tel:"+ getString(R.string.phoneNumberLt);
        TextView phoneNumber = (TextView) findViewById(R.id.phoneNumber);
        Log.v("Phase 1", "Phase 1");
        phoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("Phase 1", "Phase 2");
                Intent callPhone = new Intent(Intent.ACTION_DIAL);
                callPhone.setData(Uri.parse(uri));
                if (callPhone.resolveActivity(getPackageManager()) != null) {
                    startActivity(callPhone);
                }
            }
        });
    }

    /**
     * This method sets on click listener to email information.
     * When pressed intent is sent to an email application.
     */

    public void makeEmailActive() {
        final TextView email = (TextView) findViewById(R.id.email);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent writeEmail = new Intent(Intent.ACTION_SENDTO);
                writeEmail.setType("plain/text");
                writeEmail.setData(Uri.parse("mailto:"));
                writeEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.email)});
                writeEmail.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.emailSubject));
                if (writeEmail.resolveActivity(getPackageManager()) != null) {
                    startActivity(writeEmail);
                }
            }
        });
    }

    /**
     * This method sets on click listener to webpage information.
     * When pressed intent is sent to an web browser application.
     */

    public void makeWebsiteActive() {

        final Uri webpage = Uri.parse(getString(R.string.webpageLt));

        TextView website = (TextView) findViewById(R.id.website);

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openWebsite = new Intent(Intent.ACTION_VIEW, webpage);
                if (openWebsite.resolveActivity(getPackageManager()) != null) {
                    startActivity(openWebsite);
                }
            }
        });
    }

}
