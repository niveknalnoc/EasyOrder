package ie.dcu.easyorderfyp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class EasyOrderERROR extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.easyorder_error);
	}
	
	@Override
	public void onBackPressed() {
		Intent i = new Intent(getApplicationContext(),
				LoggedInActivity.class);
		startActivity(i);
	}
}
