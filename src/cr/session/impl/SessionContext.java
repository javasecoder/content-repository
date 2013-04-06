package cr.session.impl;

import java.util.HashMap;
import java.util.Map;

import cr.data.ObjectsList;
import cr.data.TypeMetadata;
import cr.data.impl.TypeBuilder;
import cr.session.security.impl.PermissionChecker;


public class SessionContext
{
	
	private final long revision;
	private final PermissionChecker checker;
	
	// Кэшированные данные
	
	private final Map<String, TypeMetadata> loadedTypes = new HashMap<String, TypeMetadata>();
	private final Map<String, ObjectsList> loadedLists = new HashMap<String, ObjectsList>();
	
	
	
	public SessionContext(final long revision, final PermissionChecker checker)
	{
		this.revision = revision;
		this.checker = checker;
	}
	
	
	public SessionContext cloneWithIncrementedRevision(final PermissionChecker checker)
	{
		final SessionContext clonedContext = new SessionContext(this.revision + 1, checker);
		
		// TODO copy data to context
		
		return clonedContext;
	}
	
	
	
	public TypeMetadata getTypeByName(final String name)
	{
		return this.loadedTypes.get(name);
	}
	
	public ObjectsList getObjectsListByName(final String name)
	{
		return this.loadedLists.get(name);
	}
	
	public TypeMetadata createType(final String name)
	{
		return this.createType(name, null);
	}
	
	public TypeMetadata createType(final String name, final TypeMetadata baseType)
	{
		if (this.loadedTypes.containsKey(name))
		{
			throw new RuntimeException();
		}
		
		final TypeMetadata newType = TypeBuilder.createStuructureType(name, baseType, this.checker);
		this.loadedTypes.put(name, newType);
		
		return newType;
	}
	
	public void removeType(final String name, final boolean removeIfObjectsExist, final boolean removeIfSubtypesExist)
	{
		// TODO
	}
	
	
	
	public long getRevision()
	{
		return this.revision;
	}
	
	public PermissionChecker getPermissionChecker()
	{
		return this.checker;
	}
	
}
