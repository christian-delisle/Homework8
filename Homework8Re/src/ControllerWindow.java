import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ControllerWindow extends ObserverWindow{
	private int nTaps;
	private JButton tapButton;
	private JFrame subjectFrame;
	//private ObservableSubject observableSubject; --Removed class
	private PropChange propChange;	//Replaced removed class
	
	ControllerWindow(ObserverWindow Obs){
		//Initialize the action that will be observed, create PropChange listener, and change text field
		nTaps = 0;
		propChange = new PropChange();
		propChange.addPropertyChangeListener(e -> label.setText((String) e.getNewValue()));
		
		
		// Build the window frame for the observed subject.
		buildWindowFrame();

		// Register the action that will be observed.
		registerTapObservedAction();
	}
	
	private void buildWindowFrame() {
		subjectFrame = new JFrame("Subject being Observed");
		tapButton = new JButton("Tap me");
		subjectFrame.add(tapButton);
		subjectFrame.setSize(250, 150);
		subjectFrame.setLocation(600, 200);
		subjectFrame.setVisible(true);
	}

	private void registerTapObservedAction() {
		tapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "   Subject was tapped: " + ++nTaps;
				propChange.setData(data); //Changed class and method 
			}
		});
	}

}