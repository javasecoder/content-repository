package cr.data.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import cr.data.ObjectItem;
import cr.data.ObjectsList;
import cr.data.TypeMetadata;
import cr.session.security.impl.PermissionChecker;

public class ObjectsListImpl implements ObjectsList
{
	
	private final TypeMetadataBaseImpl typeMetadata;
	private final PermissionChecker checker;
	private final Map<String, ObjectItem> objects = new HashMap<String, ObjectItem>();
	private Map<String, ObjectItem> lockedObjects = null;
	
	
	public ObjectsListImpl(final TypeMetadataBaseImpl typeMetadata, final PermissionChecker checker)
	{
		this.typeMetadata = typeMetadata;
		this.checker = checker;
	}
	
	@Override
	public ObjectItem createObject(final String name)
	{
		this.checker.createObjectItem();
		
		// TODO Auto-generated method stub
		
		this.lockedObjects = null;
		
		return null;
	}

	@Override
	public void removeObject(final String name)
	{
		this.checker.removeObjectItem();
		
		// TODO Auto-generated method stub
		
		
		this.lockedObjects = null;
	}

	@Override
	public void clear()
	{
		this.checker.removeObjectItem();
		
		// TODO Auto-generated method stub
		
		
		this.lockedObjects = null;
	}

	@Override
	public ObjectItem getObject(String name)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, ObjectItem> getObjects()
	{
		if (this.lockedObjects == null)
		{
			this.lockedObjects = Collections.unmodifiableMap(this.objects);
		}
		
		return this.lockedObjects;
	}

	@Override
	public TypeMetadata getTypeMetadata()
	{
		return this.typeMetadata;
	}
}
