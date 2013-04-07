package cr.data;

import java.util.Map;

/**
 * 
 * 
 * 
 * @author dgladkov
 *
 */
public interface TypeMetadata
{
	/**
	 * 
	 * @param name
	 * @param type
	 */
	void setField(final String name, final TypeMetadata type);
	/**
	 * 
	 * @param name
	 */
	void removeField(final String name);
	
	/**
	 * 
	 * @param newName
	 */
	void setName(final String newName);
	/**
	 * 
	 * @param newParent
	 */
	void setBaseType(final TypeMetadata newParent);
	
	/**
	 * 
	 * @return
	 */
	String getName();
	/**
	 * 
	 * @return
	 */
	TypeMetadata getBaseType();
	/**
	 * 
	 * @param name
	 * @return
	 */
	TypeMetadata getField(final String name);
	/**
	 * 
	 * @return
	 */
	Map<String, TypeMetadata> getFields();
	/**
	 * 
	 * @return
	 */
	boolean isPredefined();
	/**
	 * 
	 * @return
	 */
	long getTypeId();
}
