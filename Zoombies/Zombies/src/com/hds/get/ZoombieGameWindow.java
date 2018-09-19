package com.hds.get;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
/*import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
*/
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author bonde_p
 *
 */
public class ZoombieGameWindow extends JFrame {
	private static final long serialVersionUID = 798241596994493961L;
	private static final int DIM_X = 50;
	private static final int DIM_Y = 50;
	private static final Color BACKGROUND_COLOR = Color.lightGray;
	private static final Color HUMANS_COLOR = Color.blue;
	private static final Color ZOMBIES_COLOR = Color.red;
	private static final int STEP_MILLIS = 500;
	private static JPanel[][] squares = new JPanel[DIM_X][DIM_Y];
	private static JPanel mainPanel = new JPanel(new GridLayout(DIM_X, DIM_Y));

	
	/**
	 *  MAIN constructor 
	 */
	public ZoombieGameWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.init();
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * @return
	 */
	public JPanel[][] getSquares() {
		return squares;
	}

	/**
	 * @param squares
	 */
	public void setSquares(JPanel[][] squares) {
		this.squares = squares;
	}

	/**
	 * @return
	 */
	public static int getDimX() {
		return DIM_X;
	}

	/**
	 * @return
	 */
	public static int getDimY() {
		return DIM_Y;
	}

	/**
	 * @return
	 */
	public static Color getBackgroundColor() {
		return BACKGROUND_COLOR;
	}

	/**
	 * @return
	 */
	public static Color getHumansColor() {
		return HUMANS_COLOR;
	}

	/**
	 * @return
	 */
	public static Color getZombiesColor() {
		return ZOMBIES_COLOR;
	}

	/**
	 * @return
	 */
	public static int getStepMillis() {
		return STEP_MILLIS;
	}

	/**
	 * Initialization of the elements
	 */
	private void init() {
		Container c = getContentPane();

		for (int y = 0; y < DIM_Y; y++) {
			for (int x = 0; x < DIM_X; x++) {
				squares[x][y] = new JPanel();
				squares[x][y].setPreferredSize(new Dimension(10, 10));
				squares[x][y].setBackground(BACKGROUND_COLOR);
				squares[x][y].setBorder(BorderFactory.createLineBorder(Color.white));
				mainPanel.add(squares[x][y]);
			}
		}
		c.add(mainPanel);
	}

	/**
	 * @param color
	 * @param currentX
	 * @param currentY
	 */
	public static void simpleMoveRight(Color color, int currentX, int currentY) {
		try {
			Thread.sleep(STEP_MILLIS);
		} catch (InterruptedException e) {
		}
		// paint previous cell with background color
		// this effectively "erases" whatever was there
		squares[currentX][currentY].setBackground(BACKGROUND_COLOR);
		squares[currentX + 1][currentY].setBackground(color);
	}

	/**
	 * @param color
	 * @param currentX
	 * @param currentY
	 */
	public static void simpleMoveLeft(Color color, int currentX, int currentY) {
		try {
			Thread.sleep(STEP_MILLIS);
		} catch (InterruptedException e) {
		}
		// paint previous cell with background color
		// this effectively "erases" whatever was there
		squares[currentX][currentY].setBackground(BACKGROUND_COLOR);
		squares[currentX - 1][currentY].setBackground(color);
	}
	
	/**
	 * @param color
	 * @param currentX
	 * @param currentY
	 */
	public static void simpleMoveUp(Color color, int currentX, int currentY) {
		try {
			Thread.sleep(STEP_MILLIS);
		} catch (InterruptedException e) {
		}
		// paint previous cell with background color
		// this effectively "erases" whatever was there
		squares[currentX][currentY].setBackground(BACKGROUND_COLOR);
		squares[currentX][currentY - 1].setBackground(color);
	}

	/**
	 * @param color
	 * @param currentX
	 * @param currentY
	 */
	public static void simpleMoveDown(Color color, int currentX, int currentY) {
		try {
			Thread.sleep(STEP_MILLIS);
		} catch (InterruptedException e) {
		}
		// paint previous cell with background color
		// this effectively "erases" whatever was there
		squares[currentX][currentY].setBackground(BACKGROUND_COLOR);
		squares[currentX][currentY + 1].setBackground(color);
	}
	
	/**
	 * @param color
	 * @param currentX
	 * @param currentY
	 */
	public static void simpleMoveFirst(Color color, int currentX, int currentY) {
		try {
			Thread.sleep(STEP_MILLIS);
		} catch (InterruptedException e) {
		}
		// paint previous cell with background color
		// this effectively "erases" whatever was there
		squares[currentX][currentY].setBackground(BACKGROUND_COLOR);
	}
	
	/**
	 * @param color
	 * @param currentX
	 * @param currentY
	 */
	public static void simpleMovediagonal(Color color, int currentX, int currentY) {
		try {
			Thread.sleep(STEP_MILLIS);
		} catch (InterruptedException e) {
		}
		// paint previous cell with background color
		// this effectively "erases" whatever was there
		squares[currentX][currentY].setBackground(BACKGROUND_COLOR);
		squares[currentX + 1 ][currentY - 1].setBackground(color);
	}
}
