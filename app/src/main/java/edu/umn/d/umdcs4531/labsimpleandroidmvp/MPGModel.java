package edu.umn.d.umdcs4531.labsimpleandroidmvp;

import android.util.Log;

/**
 * Created by willemsn on 2/1/17.
 */

public class MPGModel implements ModelViewPresenterComponents.Model {

    // Models need a reference to the MPGPresenter they interact with
    private ModelViewPresenterComponents.MPGPresenterContract mPresenter;

    float mMPG;
    float mPrevOdometer;
    float mCurrentOdometer;
    float mGallons;

    public MPGModel(ModelViewPresenterComponents.MPGPresenterContract presenter)
    {
        this.mPresenter = presenter;

        // would need to initialize any thing in this model that might
        // be considered internal data
        mPrevOdometer = 0.0f;
    }

    public float calcMPG()
    {
        mMPG = (mCurrentOdometer - mPrevOdometer) / mGallons;
        mPrevOdometer = mCurrentOdometer;
        return mMPG;
    }

    @Override
    public float getMPG() {
        return calcMPG();
    }

    @Override
    public void setCurrentReadings( float gallons, float currentOdometer, float previousOdometer )
    {
        mGallons = gallons;
        mCurrentOdometer = currentOdometer;
        mPrevOdometer = previousOdometer;
    }

}
