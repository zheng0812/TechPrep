package edu.umn.d.umdcs4531.labsimpleandroidmvp;

import android.util.Log;
import android.widget.EditText;

/**
 * Created by willemsn on 2/1/17.
 */

public class MPGPresenter implements ModelViewPresenterComponents.MPGPresenterContract
{
    // presenter needs to talk with his model
    private ModelViewPresenterComponents.Model mModel;
    private ModelViewPresenterComponents.View mView;

    public MPGPresenter(ModelViewPresenterComponents.View mpgView)
    {
        mView = mpgView;
        mModel = new MPGModel(this);
    }

    // setting up recycler adapter
    @Override
    public String getMPG()
    {
        float f = mModel.getMPG();
        Log.d("presenter", Float.toString(f));
        return Float.toString(f);
    }

    // When the view receives input from the user (after the calcMPG button is clicked,
    // this will be called by the view to relay the user data here.  Once here, it can
    // be checked and potentially sent on to the model.
    @Override
    public void clickCalcMPG(EditText gallons, EditText prevOdom, EditText currOdom) {
        float gallonsEntered = Float.valueOf(gallons.getText().toString());
        float odometerPrev = Float.valueOf(prevOdom.getText().toString());
        float odometerCurr = Float.valueOf(currOdom.getText().toString());

        boolean error = false;
        // doing some error checking here on the inputs would be good before we proceed with
        // other calculations...
        if (!error) {
            mModel.setCurrentReadings(gallonsEntered, odometerCurr, odometerPrev);
            mView.notifyMPGUpdated();
        }
    }
}
