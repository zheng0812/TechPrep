package edu.umn.d.umdcs4531.labsimpleandroidmvp;

import android.widget.EditText;


public interface ModelViewPresenterComponents {

    // View
    interface View
    {
        void notifyMPGUpdated();
    }

    /** MPGPresenter operations are meant for the views that deal with presenting MPG information.
     * This interface contains a "contract" of the functions that will be implemented by any
     * Presenters that can work with MPG data.
     */
    interface MPGPresenterContract
    {
        // Called by the view when user clicks the MPG calc button
        // provides access to the info the user entered
        // - in this way, the views communicate data entered by the user
        //   for the MPG calculations
        void clickCalcMPG(final EditText gallons, final EditText prevOdom, final EditText currOdom);
        String getMPG();
    }

    /** Model Operations
     * Interface for Models that Presenters will need to use to acquire and set data about the model. In this case,
     * the model is our MPG Calculations and data, such as odometer readings
     */
    interface Model
    {
        float getMPG();
        void setCurrentReadings( float gallons, float currOdom, float prevOdom );
    }

}
