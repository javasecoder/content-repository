package cr.data.impl;

import java.util.Map;

import cr.data.TypeMetadata;

public class TypeMetadataPredefinedImpl extends TypeMetadataBaseImpl
{

	public TypeMetadataPredefinedImpl(final String name)
	{
		super(name, null, null);
	}
	
	@Override
	public void setName(final String newName)
	{
		throw new RuntimeException();
	}
	
	@Override
	public void setBaseType(final TypeMetadata newBaseType)
	{
		throw new RuntimeException();
	}

	@Override
	public void setField(final String name, final TypeMetadata type)
	{
		throw new RuntimeException();
	}

	@Override
	public void removeField(final String name)
	{
		throw new RuntimeException();
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
		return true;
	}

}
