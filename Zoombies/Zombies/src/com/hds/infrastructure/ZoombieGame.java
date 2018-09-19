package com.hds.infrastructure;

/**
 * @author bonde_p
 *
 */
public abstract interface ZoombieGame {
	/**
	 * @param entityType : Provide the entityType as Zoombie 
	 * @param startingPosition : startingPostiion as position in the checkboard
	 * @throws Exception
	 */
	public abstract void invokehunting(String entityType, String startingPosition) throws Exception;

	/**
	 * @param enityType : Provide the entityType as human 
	 * @param startingPosition  : startingPostiion as position in the checkboard
	 * @throws Exception
	 */
	public abstract void invokevade(String entityType, String startingPosition) throws Exception;
}
