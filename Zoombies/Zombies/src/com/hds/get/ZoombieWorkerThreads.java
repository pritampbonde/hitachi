package com.hds.get;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.hds.infrastructure.CreationThreadPool;

/**
 * @author bonde_p
 *
 */
public class ZoombieWorkerThreads implements Runnable, CreationThreadPool {

	private String command;

	/**
	 * @return
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * @param command
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * @return
	 */
	public boolean isSimpleMoveFirst() {
		return isSimpleMoveFirst;
	}

	/**
	 * @param isSimpleMoveFirst
	 */
	public void setSimpleMoveFirst(boolean isSimpleMoveFirst) {
		this.isSimpleMoveFirst = isSimpleMoveFirst;
	}

	/**
	 * @return
	 */
	public int getxAxis() {
		return xAxis;
	}

	/**
	 * @param xAxis
	 */
	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}

	/**
	 * @return
	 */
	public int getyAxis() {
		return yAxis;
	}

	/**
	 * @param yAxis
	 */
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}

	/**
	 * @return
	 */
	public boolean isHuman() {
		return isHuman;
	}

	/**
	 * @param isHuman
	 */
	public void setHuman(boolean isHuman) {
		this.isHuman = isHuman;
	}

	/**
	 * @return
	 */
	public boolean isZoombie() {
		return isZoombie;
	}

	/**
	 * @param isZoombie
	 */
	public void setZoombie(boolean isZoombie) {
		this.isZoombie = isZoombie;
	}

	private boolean isSimpleMoveFirst;
	private int xAxis;
	private int yAxis;
	private boolean isHuman;
	private boolean isZoombie;
	private ThreadPoolExecutor executor;
	private int seconds;
	private boolean run = true;

	/**
	 * @param s
	 * @param isSimpleMoveFirst
	 * @param xAxis
	 * @param yAxis
	 * @param isHuman
	 * @param isZoombie
	 */
	public ZoombieWorkerThreads(String s, boolean isSimpleMoveFirst, int xAxis, int yAxis, boolean isHuman,
			boolean isZoombie) {
		this.command = s;
		this.isSimpleMoveFirst = isSimpleMoveFirst;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.isHuman = isHuman;
		this.isZoombie = isZoombie;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
		processCommand();
		System.out.println(Thread.currentThread().getName() + " End.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hds.infrastructure.CreationThreadPool#processCommand()
	 */
	public synchronized void processCommand() {
		try {
			Thread.sleep(1000);
			int isColourset = 0;
			System.out.println("y: " + this.yAxis + " x: " + this.xAxis);
			if (this.isHuman) {
				int x = this.xAxis / 2;
				if (!this.isSimpleMoveFirst) {
					do {
						for (int i = 0; i < this.yAxis - 1; i++) {
							if (x == i) {
								System.out.println("this is interections ishuman : moveDownwards");
								ZoombieGameWindow.simpleMoveDown(ZoombieGameWindow.getZombiesColor(), x, i);
								isColourset = 1;
							} else {
								if (isColourset == 1) {
									ZoombieGameWindow.simpleMoveDown(ZoombieGameWindow.getZombiesColor(), x, i);
									System.out.println("isHuman(MoveDown): " + " x:" + x + " i:" + i);
								}
							}
							ZoombieGameWindow.simpleMoveDown(ZoombieGameWindow.getHumansColor(), x, i);
						}

						for (int i = this.yAxis - 1; i > 0; i--) {
							if (x == 1) {
								System.out.println("this is interections ishuman : moveUp");
							} else {
								ZoombieGameWindow.simpleMoveUp(ZoombieGameWindow.getHumansColor(), x, i);
								System.out.println("isHuman(MoveUp): " + " x:" + x + " i:" + i);
							}

						}
					} while (true);
				}
			}
			if (this.isZoombie) {
				int y = this.yAxis / 2;
				if (!this.isSimpleMoveFirst) {
					do {
						for (int i = 0; i < this.xAxis - 1; i++) {
							ZoombieGameWindow.simpleMoveRight(ZoombieGameWindow.getZombiesColor(), i, y);
							System.out.println("isZoombie(MoveRight): " + " y:" + y + " i:" + i);
						}
						for (int i = this.xAxis - 1; i > 0; i--) {
							ZoombieGameWindow.simpleMoveLeft(ZoombieGameWindow.getZombiesColor(), i, y);
							System.out.println("isZoombie(MoveDown): " + " y:" + y + " i:" + i);
						}
					} while (true);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "cmd-->" + this.command + "Position-->  " + this.isSimpleMoveFirst + "xAxis-->  " + this.xAxis
				+ "yAxis-->  " + this.yAxis + "isHuman-->  " + this.isHuman + "isZoombie-->  " + this.isZoombie;
	}

	public static void main(String[] args) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			// load a properties file
			prop.load(new FileInputStream(args[0]));
			ZoombieGameWindow mainWindow = new ZoombieGameWindow();

			// ZoombieWorkerThreads(String s, boolean isSimpleMoveFirst, int
			// xAxis, int
			// yAxis, boolean isHuman, boolean isZoombie)
			// concurrent threads creations
			ExecutorService executor = Executors
					.newFixedThreadPool(Integer.parseInt(prop.getProperty("threadToSpoon")));
			for (int i = 0; i < 1; i++) {
				Runnable humanWorkerThread = new ZoombieWorkerThreads("cmd-->" + i,
						Boolean.parseBoolean(prop.getProperty("isSimpleMoveFirst")),
						Integer.parseInt(prop.getProperty("humanXAxis1")),
						Integer.parseInt(prop.getProperty("humanYAxis1")),
						Boolean.parseBoolean(prop.getProperty("isHumanTrue")),
						Boolean.parseBoolean(prop.getProperty("isZoombieFalse")));
				executor.execute(humanWorkerThread);

				Runnable ZoomieWorkerThread = new ZoombieWorkerThreads("cmd-->" + i,
						Boolean.parseBoolean(prop.getProperty("isSimpleMoveFirst")),
						Integer.parseInt(prop.getProperty("zoombieXAxis1")),
						Integer.parseInt(prop.getProperty("zoombieYAxis1")),
						Boolean.parseBoolean(prop.getProperty("isHumanFalse")),
						Boolean.parseBoolean(prop.getProperty("isZoombieTrue")));
				executor.execute(ZoomieWorkerThread);

				Runnable humanWorkerThread1 = new ZoombieWorkerThreads("cmd-->" + i,
						Boolean.parseBoolean(prop.getProperty("isSimpleMoveFirst")),
						Integer.parseInt(prop.getProperty("humanXAxis2")),
						Integer.parseInt(prop.getProperty("humanYAxis2")),
						Boolean.parseBoolean(prop.getProperty("isHumanTrue")),
						Boolean.parseBoolean(prop.getProperty("isZoombieFalse")));
				executor.execute(humanWorkerThread1);

				Runnable ZoomieWorkerThread1 = new ZoombieWorkerThreads("cmd-->" + i,
						Boolean.parseBoolean(prop.getProperty("isSimpleMoveFirst")),
						Integer.parseInt(prop.getProperty("zoombieXAxis2")),
						Integer.parseInt(prop.getProperty("zoombieYAxis2")),
						Boolean.parseBoolean(prop.getProperty("isHumanFalse")),
						Boolean.parseBoolean(prop.getProperty("isZoombieTrue")));
				executor.execute(ZoomieWorkerThread1);

				Runnable humanWorkerThread2 = new ZoombieWorkerThreads("cmd-->" + i,
						Boolean.parseBoolean(prop.getProperty("isSimpleMoveFirst")),
						Integer.parseInt(prop.getProperty("humanXAxis3")),
						Integer.parseInt(prop.getProperty("humanYAxis3")),
						Boolean.parseBoolean(prop.getProperty("isHumanTrue")),
						Boolean.parseBoolean(prop.getProperty("isZoombieFalse")));
				executor.execute(humanWorkerThread2);

			}
			executor.shutdown();
			while (!executor.isTerminated()) {
			}
			System.out.println("Finished all threads");
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}