package edu.umn.d.umdcs4531.labsimpleandroidmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    implements ModelViewPresenterComponents.View {

    private ModelViewPresenterComponents.MPGPresenterContract mPresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupModelViewPresenterComponents();
    }

    /**
     * Called when the user clicks the calc MPG button
     */
    public void onClickCalcMPG(View view) {
        // Extract the Editable text fields
        EditText gallonsEditText = (EditText) findViewById(R.id.textview_gallons);
        EditText prevOdometerText = (EditText) findViewById(R.id.textview_prevodom);
        EditText currOdometerText = (EditText) findViewById(R.id.textview_currodom);

        // Provide this information to the Presenter
        mPresenter.clickCalcMPG(gallonsEditText, prevOdometerText, currOdometerText);
    }

    public void setupModelViewPresenterComponents() {
        // Create the MPGPresenter
        mPresenter = new MPGPresenter(this);
    }

    @Override
    public void notifyMPGUpdated() {
        String mpgData = mPresenter.getMPG();
        TextView mpgTV = (TextView) findViewById(R.id.mpg);
        mpgTV.setText( mpgData );
    }
}
