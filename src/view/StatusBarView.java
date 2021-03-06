package view;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import model.StatusBar;
/**
 * 
 * @author Josefin, Martin, Sara, Kino
 *
 */
public class StatusBarView {
	final private Image[] heart;
	final private Rectangle fixedBar;
	final private Rectangle timeBar;
	
	public StatusBarView() throws SlickException {
		heart = new Image[3];
		heart[0] = new Image("pics/heart.png");
		heart[1] = heart[0].copy();
		heart[2] = heart[0].copy();
		fixedBar = new Rectangle(StatusBar.FIXED_BAR_POSX, StatusBar.HEART_POSY,
				StatusBar.FIXED_BAR_WIDTH, StatusBar.FIXED_BAR_HEIGHT);
				timeBar = new Rectangle(fixedBar.getX()+5, fixedBar.getY()+5,
				fixedBar.getWidth()-10, fixedBar.getHeight()-10);
	}
	
	public void updateTimeBar (final float levelTime, final float remainingTime) {
		this.timeBar.setWidth((fixedBar.getWidth()-10)*(remainingTime/levelTime));
	}

	public Image[] getHeart() {
		return heart;
	}

	public Shape getFixedBar() {
		return fixedBar;
	}

	public Rectangle getTimeBar() {
		return timeBar;
	}
}