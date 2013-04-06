package cr.session;

import cr.data.ObjectsList;
import cr.data.TypeMetadata;

/**
 * 
 * @author dgladkov
 *
 */
public interface Session
{
	/**
	 * 
	 * @param name
	 * @return
	 */
	TypeMetadata createType(final String name);
	/**
	 * 
	 * @param name
	 * @param baseType
	 * @return
	 */
	TypeMetadata createType(final String name, final TypeMetadata baseType);
	/**
	 * 
	 * @param name
	 * @param removeIfObjectsExist
	 */
	void removeType(final String name, final boolean removeIfObjectsExist, final boolean removeIfSubtypesExist);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	ObjectsList getObjectsList(final String name);
	/**
	 * 
	 * @param name
	 * @return
	 */
	TypeMetadata getTypeMetadata(final String name);
	
	/**
	 * 
	 * @return
	 */
	boolean isReadonly();
	/**
	 * 
	 */
	void commit();
	/**
	 * 
	 */
	void rollback();
}
