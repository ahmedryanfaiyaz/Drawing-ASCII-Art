package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

        // TODO -- add your code here
        for(int height=0; height<2*size+1; height++){
            for(int width=0; width<2*size+2; width++){
                if((height==0 || height==2*size)&&(width==0 || width==2*size+1)) {
                    if(width==2*size+1) mOut.println('+');
                    else mOut.print('+');
                }
                else if(height==0||height==2*size) mOut.print('-');
                else if(width==0||width==2*size+1) {
                    if(width==2*size+1) mOut.println('|');
                    else mOut.print('|');
                }
                else if(height==(2*size+1)/2){
                    if(width==1) mOut.print('<');
                    else if(width==2*size) mOut.print('>');
                    else if(size%2==0) mOut.print('-');
                    else if(size%2!=0) mOut.print('=');
                }
                else if(height<(2*size+1)/2){
                    if(width == size+1-height) mOut.print('/');
                    else if(width>size+1-height && width < size+height){
                        if(height%2==0) mOut.print('-');
                        else mOut.print('=');
                    }
                    else if(width == size+height) mOut.print('\\');
                    else mOut.print(' ');
                }
                else if(height>(2*size+1)/2){
                    if(width == (height+1) - size) mOut.print('\\');
                    else if(width>(height+1) - size && width < 3*size-height){
                        if(height%2==0) mOut.print('-');
                        else mOut.print('=');
                    }
                    else if(width == 3*size-height) mOut.print('/');
                    else mOut.print(' ');
                }
            }
        }

    }
}
