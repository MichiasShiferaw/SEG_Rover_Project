package rover;

import java.util.Scanner;


/**
 * A class representing a Rover’s mobility implementation. This class has common traits of a Rover such as its current state represented by an enum (a special collection) value as well as another
 *  enum to indicate whether the Rover's engine is running or not. The Rover machine also has a plethora of behaviors like by pressing the left pedal once, it will accelerate forward or press both
 *  pedals simultaneously, the Rover will brake). Each method below represents the behaviour of a Rover.
 *  @author Michias Shiferaw
 *  @version 2.0
 *  @since 2022-05-28
 */

public class Rover{

    //Rover Functional Attributes
    /**Initialize an enum collection that consists of the state a Rover can have*/
    public enum State {
        /**State of when the engine is off*/
        engineOff,
        /** State of when the Rover is on*/
        vehiculeOn}
    /**Initialize an enum collection that consists of the state a Rover can have turn the engine is running*/
    public enum StateVehiculeOn {
        /**Null State*/
        Null,
        /** Park State*/
        park,
        /** Neutral state*/
        neutral,
        /** Accelerating Forward State*/
        accelerateforward,
        /** Constant Speed Forward State*/
        constantspeedforward,
        /** Deaccelerate Forward State*/
        deaccelerateforward,
        /** Turning State*/
        turn,
        /** Braking State*/
        brake,
        /** Deaccelerating Backward State*/
        deacceleratebackwards,
        /** Accelerating Backwards*/
        acceleratebackwards,
        /** Constant Speed Backwards*/
        constantspeedbackwards}
    //Initialize a null state variable
    private State state;
    //Initialize a null-stateVehiculeOn variable
    private StateVehiculeOn stateVehiculeOn;
    //Initialize a String variable that intends to be used as the output source
    private String msg;
    private Rover.StateVehiculeOn prev1 = stateVehiculeOn; //Initialize a StateVehiculeOn variable that holds the previous state of the Rover object

    /**This method CREATE a NEW Rover objects that is set to engine off*/
    public Rover(){
        setStateVehiculeOn(StateVehiculeOn.Null);
        setState(State.engineOff);}


    /** This method is used to take the users input how the number of seconds in order to determine if the change of the state is then successful
     * @return a integer value that corresponds to the users inputs*/
    private static int setTime(int val){
        Scanner sc=null;
        //sc=new Scanner(System.in);
        int time=0;
        System.out.println("How long (in seconds) are you holding the pedals or buttons for?");
        time = val;
        //sc.nextInt();
        //sc = null;
        return time;
    }
    /** This method is used to show that the change of state was unsuccessful
     * @param state1 the current state of the Rover, used to vocalize that the state remains unchanged
     * @return a String that announces the Rover will remain at the current state */
    private String noChange(StateVehiculeOn state1){
        return (" the buggy will remain at "+ stateVehiculeOn) +".";}
    /** This method is used to show that the change of state when the Rover is on was unsuccessful
     * @param state1 the current state of the Rover, used to vocalize that the state remains unchanged
     * @return a String that announces the Rover will remain at the current state */
    //private String noChange(State state1) {return (" the buggy will remain at still, on the" + state1) + " state.";}

    /** This method is getter that converts the state of the Rover into an output string
     * @return a String depicts the current state of the buggy */
    //public String getStateFullName(){String answer = state.toString();if (stateVehiculeOn != StateVehiculeOn.Null) { answer += "." + stateVehiculeOn.toString(); }return answer;}

    /** This method is a getter for the current state of the Rover
     * @return state, the current state of the Rover (i.e. VehiculeOn or engineOff) */
    public State getState(){return state;}

    /** This method is a getter for the current state of the Rover when turned on
     * @return stateVehiculeOn, the current state of the Rover when turned on (i.e. turning or accelerating forward) */
    public StateVehiculeOn getStateVehiculeOn(){return stateVehiculeOn;}

    /**This method illustrates the action of inserting the key and simultaneously applying pressure to the right pedal in hopes to turn the engine on
     * @return a Boolean that expresses if the transfer of state was processed*/
    public boolean turnKeyPressRightPedal(){
        boolean wasEventProcessed = false;
        if (state==state.engineOff){
            msg = ("Initially the buggy was still with the engine off and so the key was turned and the right pedal was pressed so,");
        } else{
            msg = ("Initially the buggy was on with the engine running and so the key was turned and the right pedal was pressed so,");
        }
        State aState = state;
        switch (aState){case engineOff:setState(State.vehiculeOn);exitStateVehiculeOn(); wasEventProcessed = true;break;
            default: msg+=noChange(stateVehiculeOn);

        }
        System.out.println(msg);
        return wasEventProcessed;}


    /**This method portrays when the LEFT PEDAL is tapped TWICE in hopes to change the state of the Rover
     * @return a Boolean that expresses if the transfer of state was processed*/
    public boolean pressLeftPedalTwice(){
        boolean wasEventProcessed = false;
        msg=("Initially the buggy was at "+ this.stateVehiculeOn + " and so the left pedal was pressed twice so,");
        StateVehiculeOn aStateVehiculeOn = stateVehiculeOn;
        switch (aStateVehiculeOn){case park:setStateVehiculeOn(StateVehiculeOn.neutral);exitStateVehiculeOn(); wasEventProcessed = true;break;
            case acceleratebackwards:setStateVehiculeOn(StateVehiculeOn.deacceleratebackwards);exitStateVehiculeOn(); wasEventProcessed = true;break;
            default: msg+=noChange(stateVehiculeOn);}System.out.println(msg);
        return wasEventProcessed;}

    /** This method REMOVES THE KEY from the key spot in hopes to turn the Rover engine off
     @return a Boolean that expressed if the Rover was successfully turned off*/
    public boolean removeKey(){
        boolean wasEventProcessed = false;
        StateVehiculeOn aStateVehiculeOn = stateVehiculeOn;
        msg=("Initially the buggy was at " + this.stateVehiculeOn + " and so the key was removed so,");
        switch (aStateVehiculeOn){case park:setState(State.engineOff);exitStateVehiculeOn(); wasEventProcessed = true;break;
            //default: msg+=noChange(stateVehiculeOn);
        }
        System.out.println(msg +"\nEngine Off!");
        return wasEventProcessed;}


    /**This method portrays when the RIGHT PEDAL is tapped in hopes to change the state of the Rover
     * @return a Boolean that expresses if the transfer of state was processed*/
    public boolean pressRightPedal(){
        boolean wasEventProcessed = false;
        msg=("Initially the buggy was at " + this.stateVehiculeOn + " and so the right pedal was once so,");
        StateVehiculeOn aStateVehiculeOn = stateVehiculeOn;
        switch (aStateVehiculeOn){case neutral:setStateVehiculeOn(StateVehiculeOn.park);exitStateVehiculeOn(); wasEventProcessed = true;break;
            default: msg+=noChange(stateVehiculeOn);}
        System.out.println(msg);
        return wasEventProcessed;
    }
    /**This method portrays when the LEFT PEDAL is tapped ONCE in hopes to change the state of the Rover
     * @return a Boolean that expresses if the transfer of state was processed*/
    public boolean pressLeftPedalOnce(){
        boolean wasEventProcessed = false;
        msg=("Initially the buggy was at " + this.stateVehiculeOn + " and so the left pedal was pressed once so,");
        StateVehiculeOn aStateVehiculeOn = stateVehiculeOn;
        switch (aStateVehiculeOn){case neutral:setStateVehiculeOn(StateVehiculeOn.accelerateforward);exitStateVehiculeOn(); wasEventProcessed = true;break;
        }
        System.out.println(msg);
        return wasEventProcessed;
    }
    /**This method portrays when the LEFT PEDAL (only) is tapped and depending of the length (>=5 seconds) the pressure on the pedal determine if the state of the Rover will change
     * @return a Boolean that expresses if the transfer of state was processed*/
    public boolean pressLeftPedal(){
        boolean wasEventProcessed = false;
        msg=("Initially the buggy was at " + this.stateVehiculeOn + " and so the left pedal was pressed so,");
        StateVehiculeOn aStateVehiculeOn = stateVehiculeOn;
        switch (aStateVehiculeOn){case neutral:
            int timer=setTime(10);
            if (timer>=5){setStateVehiculeOn(StateVehiculeOn.acceleratebackwards);exitStateVehiculeOn(); wasEventProcessed = true;break;} else {msg += (" since you held it for " + timer + " seconds, the Rover will remain at its current state");}break;
            //default: msg+=noChange(stateVehiculeOn);
        }
        System.out.println(msg);
        return wasEventProcessed;  }

    /**This method portrays when the RIGHT AND LEFT pedals is pressed in order to activate brakes
     * @return a Boolean that expresses if the transfer of state was processed*/
    public boolean pressLeftRightPedal(){
        boolean wasEventProcessed = false;
        msg=("Initially the buggy was at " + this.stateVehiculeOn + " and so the left and right pedal was pressed(braking) so,");
        StateVehiculeOn aStateVehiculeOn = stateVehiculeOn;
        switch (aStateVehiculeOn){
            case accelerateforward:setStateVehiculeOn(StateVehiculeOn.brake);exitStateVehiculeOn(); wasEventProcessed = true;break;
            //case constantspeedforward:setStateVehiculeOn(StateVehiculeOn.brake);exitStateVehiculeOn(); wasEventProcessed = true;break;
            //case deaccelerateforward:setStateVehiculeOn(StateVehiculeOn.brake);exitStateVehiculeOn(); wasEventProcessed = true;break;
            //case turn:setStateVehiculeOn(StateVehiculeOn.brake);exitStateVehiculeOn(); wasEventProcessed = true;break;
            case deacceleratebackwards:setStateVehiculeOn(StateVehiculeOn.brake);exitStateVehiculeOn(); wasEventProcessed = true;break;
            case constantspeedbackwards:setStateVehiculeOn(StateVehiculeOn.brake);exitStateVehiculeOn(); wasEventProcessed = true;break;
            default: msg+=noChange(stateVehiculeOn);
        }
        System.out.println(msg);
        return wasEventProcessed;
    }


    /**This method portrays when the RIGHT PEDAL is tapped TWICE in hopes to change the state of the Rover
     * @return a Boolean that expresses if the transfer of state was processed*/
    public boolean pressRightPedalTwice(){
        boolean wasEventProcessed = false;
        msg=("Initially the buggy was at " + this.stateVehiculeOn + " and so the right pedal was pressed twice so,");
        StateVehiculeOn aStateVehiculeOn = stateVehiculeOn;
        switch (aStateVehiculeOn){case accelerateforward:setStateVehiculeOn(StateVehiculeOn.deaccelerateforward);exitStateVehiculeOn(); wasEventProcessed = true;break;
            //default: msg+=noChange(stateVehiculeOn);
        }
        System.out.println(msg);
        return wasEventProcessed;
    }
    /**This method portrays when the RIGHT PEDAL is tapped ONCE and depending of the length (>=5 seconds) the pressure on the pedal determine if the state of the Rover will change
     * @return a Boolean that expresses if the transfer of state was processed*/
    public boolean pressRightPedalOnce(){
        boolean wasEventProcessed = false;
        msg=("Initially the buggy was at " + this.stateVehiculeOn + " and so the right pedal was pressed once so,");
        StateVehiculeOn aStateVehiculeOn = stateVehiculeOn;
        switch (aStateVehiculeOn){
            case accelerateforward:
                int timer=setTime(10);
                if (timer>=5){
                    setStateVehiculeOn(StateVehiculeOn.constantspeedforward);exitStateVehiculeOn(); wasEventProcessed = true;break;}else {msg += (" since you held it for " + timer + " seconds, the camera will remain at its current state");
                }break;
            case acceleratebackwards:timer=setTime(12);if (timer >= 5){setStateVehiculeOn(StateVehiculeOn.constantspeedbackwards);exitStateVehiculeOn(); wasEventProcessed = true;break;} else {msg += (" since you held it for " + timer + " seconds, the camera will remain at its current state");}break;
            //default: msg+=noChange(stateVehiculeOn);
        }
        System.out.println(msg);
        return wasEventProcessed;
    }
    /**This method portrays when the FIRST BUTTON is pressed while pressure is applied on BOTH PEDALS and in hopes to change the state of the Rover
     * @return a Boolean that expresses if the transfer of state was processed*/
    public boolean pressButton1OnceHoldDownBothPedals(){
        boolean wasEventProcessed = false;
        msg=("Initially the buggy was at " + this.stateVehiculeOn + " and so both pedals were pressed along with pushing button 1 once so,");
        StateVehiculeOn aStateVehiculeOn = stateVehiculeOn;
        switch (aStateVehiculeOn){case constantspeedforward: prev1=stateVehiculeOn; setStateVehiculeOn(StateVehiculeOn.turn);exitStateVehiculeOn(); wasEventProcessed = true;break;
            case constantspeedbackwards:prev1 = stateVehiculeOn; setStateVehiculeOn(StateVehiculeOn.turn);exitStateVehiculeOn(); wasEventProcessed = true;break;
            //default: msg+=noChange(stateVehiculeOn);
        }
        System.out.println(msg);
        return wasEventProcessed;
    }
    /**This method portrays when the Rover releases the pressure from the RIGHT PEDAL (only) and in hopes to change the state of the Rover
     * @return a Boolean that expresses if the transfer of state was processed*/
    public boolean releaseRightPedal() {
        boolean wasEventProcessed = false;
        msg = ("Initially the buggy was at " + this.stateVehiculeOn+ " and so the right pedal was released so,");
        StateVehiculeOn aStateVehiculeOn = stateVehiculeOn;
        switch (aStateVehiculeOn) {
            case turn:if (prev1==StateVehiculeOn.constantspeedforward){setStateVehiculeOn(StateVehiculeOn.constantspeedforward);msg += ("the buggy is set back to driving forward at a constant speed.");
            } else if (prev1 == StateVehiculeOn.constantspeedbackwards) {setStateVehiculeOn(StateVehiculeOn.constantspeedbackwards);msg += ("the buggy is set back to driving backwards at a constant speed.");}wasEventProcessed = true;break;
            //default: msg+=noChange(stateVehiculeOn);
        }
        System.out.println(msg);
        return wasEventProcessed;
    }
    /** This method portrays when the Rover RELEASE the pressure from BOTH PEDALS and changes the state of the Rover
     * @return a Boolean that expresses if the transfer of state was successful*/
    public boolean releasePedals(){boolean wasEventProcessed = false;msg=("Initially the buggy was at " + this.stateVehiculeOn + " and the pedals were released so, ");StateVehiculeOn aStateVehiculeOn = stateVehiculeOn;
        switch (aStateVehiculeOn){case brake:setStateVehiculeOn(StateVehiculeOn.neutral);exitStateVehiculeOn(); wasEventProcessed = true;break;default: msg+=noChange(stateVehiculeOn);}
        System.out.println(msg);
        return wasEventProcessed;}

    /** This method an elementary step when changing gears/state of the Rover. If the Rover is moving, this method will call another method to help change gears, otherwise the Rover remains turned off*/
    //private void exitState(){switch(state){case vehiculeOn:exitStateVehiculeOn();break;case engineOff:break;}}

    /** This method is called to set the state of the Rover, based on if it is parked or not.
     * If the state is null(the object has been just been initialized), the state is set to park.
     * @param aState, a State-based variable that indicates if the car is parked or not
     * @return*/
    private void setState(State aState){state = aState;
        // entry actions and do activities
        switch(state){
            case vehiculeOn:
                if (stateVehiculeOn == StateVehiculeOn.Null) {
                    setStateVehiculeOn(StateVehiculeOn.park);
                }
                break;
            case engineOff:}}
    private void exitStateVehiculeOn(){switch(stateVehiculeOn){
        case park:if(getState()==State.engineOff){msg+=(" the buggy is off. ");}else{
            setStateVehiculeOn(stateVehiculeOn);msg+=(" the buggy will be parked.");}break;
        case neutral:setStateVehiculeOn(stateVehiculeOn);msg+=(" the buggy will be in the neutral gear.");break;
        case accelerateforward:setStateVehiculeOn(stateVehiculeOn);msg+=(" the buggy will be accelerating forward.");break;
        case constantspeedforward:setStateVehiculeOn(stateVehiculeOn);msg+=(" the buggy will be moving at a constant speed forward:)");break;
        case deaccelerateforward: setStateVehiculeOn(stateVehiculeOn);msg+=(" the buggy will be slowing(decelerating) forward. ");break;
        case turn:setStateVehiculeOn(stateVehiculeOn);msg+=(" the buggy is turning :)");break;
        case brake:setStateVehiculeOn(stateVehiculeOn);msg+= ( " the buggy is braking.");break;
        case deacceleratebackwards:setStateVehiculeOn(stateVehiculeOn);msg+=(" the buggy will be slowing(decelerating) backwards.");break;
        case acceleratebackwards:setStateVehiculeOn(stateVehiculeOn);msg+=(" the buggy will be accelerating backwards.");break;
        case constantspeedbackwards:setStateVehiculeOn(stateVehiculeOn);msg+=(" the buggy will be moving at a constant speed backwards. ");break;
        default:break;}}


    /**This method verifies if the state provided in the parameter then sets the state of the Rover object to the parameter provided
     * @param aStateVehiculeOn An StateVeichuleOn value represent the desired new state of the Rover
     * @return*/
    private void setStateVehiculeOn(StateVehiculeOn aStateVehiculeOn){
        stateVehiculeOn = aStateVehiculeOn;
        if (state != State.vehiculeOn && aStateVehiculeOn != StateVehiculeOn.Null) {
            setState(State.vehiculeOn); }
        switch (stateVehiculeOn) {
            default:break;}  }

}


