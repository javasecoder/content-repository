package cr.data;

import java.util.Map;

/**
 * 
 * 
 * @author dgladkov
 *
 */
public interface ObjectItem
{
	/**
	 * 
	 * @param name
	 * @param value
	 */
	void setFieldValue(final String name, final Object value);
	/**
	 * 
	 * @param newName
	 */
	void setName(final String newName);
	
	/**
	 * 
	 * @return
	 */
	String getName();
	/**
	 * 
	 * @param name
	 * @return
	 */
	Object getFieldValue(final String name);
	/**
	 * 
	 * @return
	 */
	Map<String, Object> getFields();
	/**
	 * 
	 * @return
	 */
	TypeMetadata getTypeMetadata();
	
}
