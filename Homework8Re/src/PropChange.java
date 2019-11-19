import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

//Class for Property Change Listener
public class PropChange {
	private String dispText;
	private final PropertyChangeSupport supp = new PropertyChangeSupport(this);
	
	//Method for adding Property Change Listeners
	public void addPropertyChangeListener(PropertyChangeListener evt) {
        supp.addPropertyChangeListener(evt);
    }
	
	//Method for removing Property Change Listeners
	public void removePropertyChangeListener(PropertyChangeListener evt) {
		supp.removePropertyChangeListener(evt);
	}
	 
	public String getData(){
		return this.dispText;
	}
	 
    public void setData(String newVal) {       
    	//replace old vals with new vals
       String oldVal = this.dispText;
       this.dispText = newVal;
       supp.firePropertyChange("Taps", oldVal, newVal);
    }
 
	 
}