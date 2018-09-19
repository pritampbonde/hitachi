package com.hds.utiliy;

import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	
	/**
	 * zombies varibales declaration  
	 */
	private int zombies;
	private int humans;
	private String human_position_1 ;
	private String human_position_2 ;
	private String zombies_position_1 ;
	private String zombies_position_2 ;
	Properties prop = new Properties();
	InputStream input = null;
	
	/**
	 * @return zombies
	 */
	public int getZombies() {
		return zombies;
	}

	/**
	 * @param zombies
	 */
	public void setZombies(int zombies) {
		this.zombies = zombies;
	}



	/**
	 * @return humans
	 */
	public int getHumans() {
		return humans;
	}



	/**
	 * @param humans
	 */
	public void setHumans(int humans) {
		this.humans = humans;
	}



	/**
	 * @return human position 1
	 */
	public String getHuman_position_1() {
		return human_position_1;
	}



	/**
	 * @param human_position_1
	 */
	public void setHuman_position_1(String human_position_1) {
		this.human_position_1 = human_position_1;
	}



	/**
	 * @return human position 2
	 */
	public String getHuman_position_2() {
		return human_position_2;
	}



	/**
	 * @param human_position_2
	 */
	public void setHuman_position_2(String human_position_2) {
		this.human_position_2 = human_position_2;
	}



	/**
	 * @return zombies position 
	 */
	public String getZombies_position_1() {
		return zombies_position_1;
	}



	/**
	 * @param zombies_position_1
	 */
	public void setZombies_position_1(String zombies_position_1) {
		this.zombies_position_1 = zombies_position_1;
	}



	/**
	 * @return zombies position 2
	 */
	public String getZombies_position_2() {
		return zombies_position_2;
	}



	/**
	 * @param zombies_position_2
	 */
	public void setZombies_position_2(String zombies_position_2) {
		this.zombies_position_2 = zombies_position_2;
	}

}