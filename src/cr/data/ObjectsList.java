package cr.data;

import java.util.Map;

/**
 * 
 * 
 * @author dgladkov
 *
 */
public interface ObjectsList
{
	/**
	 * 
	 * @param name
	 * @return
	 */
	ObjectItem createObject(final String name);
	/**
	 * 
	 * @param name
	 */
	void removeObject(final String name);
	/**
	 * 
	 */
	void clear();
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	ObjectItem getObject(final String name);
	/**
	 * 
	 * @return
	 */
	Map<String, ObjectItem> getObjects();
	/**
	 * 
	 * 
	 * @return
	 */
	TypeMetadata getTypeMetadata();
	
}
