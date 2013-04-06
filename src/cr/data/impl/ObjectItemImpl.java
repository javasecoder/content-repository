package cr.data.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import cr.data.ObjectItem;
import cr.data.TypeMetadata;
import cr.session.security.impl.PermissionChecker;

public class ObjectItemImpl implements ObjectItem
{
	public ObjectItemImpl(final String name, final TypeMetadata typeMetadata, final PermissionChecker checker)
	{
		this.checkName(name);
		
		this.name = name;
		this.typeMetadata = typeMetadata;
		this.checker = checker;
	}
	
	@Override
	public void setFieldValue(final String name, final Object value)
	{
		this.checker.setObjectItemFieldValue();
		
		this.checkName(name);
		
		// TODO check field type
		
		this.fields.put(name, value);
		
		this.lockedFields = null;
	}

	@Override
	public void setName(final String newName)
	{
		this.checker.setObjectItemName();
		
		this.checkName(name);
		
		this.name = newName;
	}

	
	@Override
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public Object getFieldValue(final String name)
	{
		this.checkName(name);
		
		return this.fields.get(name);
	}
	
	@Override
	public Map<String, Object> getFields()
	{
		if (this.lockedFields == null)
		{
			this.lockedFields = Collections.unmodifiableMap(this.fields);
		}
		
		return this.lockedFields;
	}

	@Override
	public TypeMetadata getTypeMetadata()
	{
		return this.typeMetadata;
	}
	
	
	
	private void checkName(final String name)
	{
		if (name == null ||
			name.matches("^[a-zA-Z0-9_-]+$"))	throw new IllegalArgumentException("Field name must consist of alphabets, numbers, underline and minus sign");
		if (!this.fields.containsKey(name))		throw new NoSuchElementException(String.format("Field '%s' not exists", name));
	}
	
	
	private final TypeMetadata typeMetadata;
	private final Map<String, Object> fields = new HashMap<String, Object>();
	private Map<String, Object> lockedFields = null;
	private final PermissionChecker checker;
	
	private String name;
	
}
