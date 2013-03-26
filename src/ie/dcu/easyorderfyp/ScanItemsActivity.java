package ie.dcu.easyorderfyp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanItemsActivity extends Activity {
	
	private String tableNumber;
	private Button btnScanItems;
	private int thisRequestCode;
	private int thisResultCode;
	ArrayList<MenuItem> menu;
	
	final Activity returnActivity = this;
	
	private IntentResult activityResultIntent;
	
	// alert dialog manager
	AlertDialogManager alert = new AlertDialogManager();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scan_items);
		
		Bundle b = this.getIntent().getExtras();
		tableNumber = b.getString("tableNumber");
		menu = getIntent().getParcelableArrayListExtra ("downloadedMenuItems");
		
		TextView tvTableNum = (TextView) findViewById(R.id.txtTableNumber);
        tvTableNum.setText("Table: " + tableNumber);
        
        final Activity returnActivity = this;
        
        btnScanItems = (Button) findViewById(R.id.btnScan);
		
		// scan table code intent onClick(btnScan)
		btnScanItems.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View view) {
        	   // Launching scan item Activity
           	   IntentIntegrator integrator = new IntentIntegrator(returnActivity);
			   integrator.initiateScan();
           }
       });
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		activityResultIntent =
				IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		thisRequestCode = requestCode;
		thisResultCode = resultCode;
		
	}
	
	private boolean validateCodeContents(String codeContents) {
		return false;
	}

}
