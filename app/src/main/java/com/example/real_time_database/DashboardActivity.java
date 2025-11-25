package com.example.real_time_database;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Find all cards by ID
        LinearLayout cardProfile = findViewById(R.id.cardProfile);
        LinearLayout cardSettings = findViewById(R.id.cardSettings);
        LinearLayout cardAnalytics = findViewById(R.id.cardAnalytics);
        LinearLayout cardAlerts = findViewById(R.id.cardAlerts);
        Button btnLogout = findViewById(R.id.btnLogout);

        // 1. View Profile
        cardProfile.setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));

        // 2. Edit Profile (Firebase Task)
        cardSettings.setOnClickListener(v -> startActivity(new Intent(this, EditProfileActivity.class)));

        // 3. Analytics (NEW)
        cardAnalytics.setOnClickListener(v -> startActivity(new Intent(this, AnalyticsActivity.class)));

        // 4. Alerts (NEW)
        cardAlerts.setOnClickListener(v -> startActivity(new Intent(this, AlertsActivity.class)));

        // 5. Logout
        btnLogout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
            // Clear history so they can't go back
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
    }
}