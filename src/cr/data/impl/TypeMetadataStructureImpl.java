package cr.data.impl;

import java.util.Map;

import cr.data.TypeMetadata;
import cr.session.security.impl.PermissionChecker;

public class TypeMetadataStructureImpl extends TypeMetadataBaseImpl
{

	public TypeMetadataStructureImpl(final String name, final TypeMetadata baseType, final PermissionChecker checker)
	{
		super(name, baseType, checker);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setField(final String name, final TypeMetadata type)
	{
		this.getChecker().setFieldType();
	
		// TODO
	}

	@Override
	public void removeField(final String name)
	{
		this.getChecker().removeField();
		
		// TODO
	}

	@Override
	public TypeMetadata getField(final String name)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, TypeMetadata> getFields()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isPredefined()
	{
		return false;
	}

}
