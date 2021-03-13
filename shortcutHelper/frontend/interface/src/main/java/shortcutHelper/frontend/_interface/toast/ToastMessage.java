package shortcutHelper.frontend._interface.toast;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ToastMessage extends JFrame {
	// *****************************************************************
	/**
	 * Config
	 */

	// *****************************************************************
	public ToastMessage(Component c, final String message) {
		setUndecorated(true);
		setLayout(new GridBagLayout());
		setBackground(new Color(240, 240, 240, 250));
		setLocationRelativeTo(null);
		setLocation(c.getLocation().x, c.getLocation().y + 70);
		setSize(250, 40);
		add(new JLabel(message));
		setAutoRequestFocus(false);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
			}
		});
	}

	public void display() {
		TimerTask toastTask = new TimerTask() {
			
			@Override
			public void run() {
				try {
					final Timer faderTimer = new Timer(true);
					TimerTask fader = new TimerTask() {
						private double opacity = 1.0;
						
						@Override
						public void run() {
							opacity-=0.1;
							if(opacity <= 0.0)
							{
								faderTimer.cancel();
								setVisible(false);
							}else {
								setOpacity((float)opacity);
							}
						}
					};
					faderTimer.schedule(fader, 100, 100);
					// hide the toast message in slow motion
				} catch (Exception e) {
					ShortcutHelperLogging.logError(e);
				}
			}
		};
		
		setOpacity(1);
		setVisible(true);
		
		Timer timer = new Timer(true);
		timer.schedule(toastTask, 1500);
	}
}