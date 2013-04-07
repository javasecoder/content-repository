package cr.data.impl;

import cr.data.ObjectItem;
import cr.data.TypeMetadata;
import cr.session.security.impl.PermissionChecker;

public abstract class TypeMetadataBaseImpl implements TypeMetadata
{
	
	static private long idCounter = 0;
	
	private final long id;
	private String name;
	private TypeMetadata baseType;
	private final PermissionChecker checker;
	
	
	public TypeMetadataBaseImpl(final String name, final TypeMetadata baseType, final PermissionChecker checker)
	{
		this.id = ++idCounter;
		this.name = name;
		this.baseType = baseType;
		this.checker = checker;
	}
	
	
	abstract public ObjectItem generateNewObject(final String name);
	
	
	@Override
	public void setName(final String newName)
	{
		if (this.checker != null)
		{
			this.checker.setTypeName();
		}
		
		this.name = newName;
	}
	
	@Override
	public void setBaseType(final TypeMetadata newBaseType)
	{
		if (this.checker != null)
		{
			this.checker.setBaseType();
		}
		
		this.baseType = newBaseType;
	}
	
	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public TypeMetadata getBaseType()
	{
		return this.baseType;
	}
	
	@Override
	public long getTypeId()
	{
		return this.id;
	}
	
	
	protected PermissionChecker getChecker()
	{
		return this.checker;
	}
}
