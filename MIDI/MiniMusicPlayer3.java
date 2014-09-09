import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer3{

	static JFrame f = new JFrame("My First Music Video");
	static MyDrawPanel ml;
	
	public static final void main(String[] args){
		MiniMusicPlayer3 mini = new MiniMusicPlayer3();
		mini.go();
	}
	
	public void setUpGUI(){
		ml = new MyDrawPanel();
		f.setContentPane(ml);
		f.setBounds(30,30,300,300);
		f.setVisible(true);
	}
	
	public void go(){
		setUpGUI();
		
		try{
		
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			int[] eventsIWant = {127};
			sequencer.addControllerEventListener(ml,new int[]{127});
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();
			
			int r = 0;
			for(int i = 5;i<60;i+=4){
				r = (int)((Math.random()*50)+1);
				
				
				track.add(makeEvent(144,1,r,100,i));
				
				track.add(makeEvent(128,1,r,100,i+2));
				
				track.add(makeEvent(176,1,127,0,i));
				
			}
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
			
			Thread.sleep(5000); /////////new
			sequencer.close(); /////////new
			System.exit(0); ////////new
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
		MidiEvent event = null;
		
		try{
			ShortMessage a = new ShortMessage();
			a.setMessage(comd,chan,one,two);
			event = new MidiEvent(a,tick);
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return event;
	}
	
	class MyDrawPanel extends JPanel implements ControllerEventListener{
	
	boolean msg = false;
	
	public void controlChange(ShortMessage event){
		msg = true;
		repaint();
	}
	public void paintComponent(Graphics g){
	
	if(msg){
		Graphics2D g2d = (Graphics2D)g;
		
		int red = (int)(Math.random()*255);
		int green = (int)(Math.random()*255);
		int blue = (int)(Math.random()*255);
		
		Color color =  new Color(red,green,blue);
		g.setColor(color);
		
		int ht = (int) ((Math.random()*120)+10);
		int width = (int)((Math.random()*120)+10);
		int x = (int)((Math.random()+40)+10);
		int y = (int)((Math.random()+40)+10);
		g.fillRect(x,y,ht,width);		
		msg = false;
	}
		
	}
}

}