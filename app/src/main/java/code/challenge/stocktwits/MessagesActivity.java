package code.challenge.stocktwits;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import code.challenge.stocktwits.model.SymbolStreamLiveData;
import code.challenge.stocktwits.viewModel.SymbolStreamViewModel;
import dagger.android.AndroidInjection;

public class MessagesActivity extends AppCompatActivity {

  private static final String TAG = MessagesActivity.class.getSimpleName();

  @Inject
  SymbolStreamViewModel viewModel;
  private RecyclerView messagesRecyclerView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AndroidInjection.inject(this);
    setContentView(R.layout.activity_messages);
    Intent intent = getIntent();
    String symbol = intent.getStringExtra("symbol");
    messagesRecyclerView = findViewById(R.id.messagesRecyclerView);
    messagesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    SymbolStreamLiveData symbolStreamLiveData = viewModel.getSymbolStreamLiveData(symbol);
    symbolStreamLiveData.observe(this, symbolStream -> {
      Log.i(TAG, "onCreate: received symbolStream");
      messagesRecyclerView.setAdapter(new SymbolStreamAdapter(symbolStream, (name, joinDate, official) -> {
        View v = LayoutInflater.from(MessagesActivity.this).inflate(R.layout.user_info, null, false);
        TextView tv1 = v.findViewById(R.id.textView);
        tv1.setText("Name: " + name);
        TextView tv2 = v.findViewById(R.id.textView2);
        tv2.setText("Join Date: " + joinDate);
        TextView tv3 = v.findViewById(R.id.textView3);
        tv3.setText("Official: " + (official ? "Yes" : "No"));
        AlertDialog.Builder builder = new AlertDialog.Builder(MessagesActivity.this);
        builder.setTitle("User Info")
            .setView(v)
            .setNegativeButton("Dismiss", null)
            .create().show();
      }));
    });
  }
}
