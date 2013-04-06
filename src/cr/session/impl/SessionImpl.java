package cr.session.impl;

import cr.data.ObjectsList;
import cr.data.TypeMetadata;
import cr.session.Session;

public class SessionImpl implements Session
{
	
	private final SessionContext context;
	
	
	public SessionImpl(final SessionContext context)
	{
		this.context = context;
		
		// Зарегистрировать сессию
		SessionContextManager.registerSession(this);
	}
	
	
	@Override
	public void commit()
	{
		// Удалить сессию
		SessionContextManager.removeSession(this);
		
		// Если сессия не для чтения, поменять контекст
		if (!this.isReadonly())
		{
			SessionContextManager.getStorageManager().setContext(this.context);
		}
	}
	
	@Override
	public void rollback()
	{
		// Удалить сессию
		SessionContextManager.removeSession(this);
	}

	@Override
	public TypeMetadata createType(final String name)
	{
		// Проверка прав
		this.context.getPermissionChecker().createType();
		return this.context.createType(name);
	}

	@Override
	public TypeMetadata createType(final String name, final TypeMetadata baseType)
	{
		// Проверка прав
		this.context.getPermissionChecker().createType();
		return this.context.createType(name, baseType);
	}

	@Override
	public void removeType(final String name, final boolean removeIfObjectsExist, final boolean removeIfSubtypesExist)
	{
		// Проверка прав
		this.context.getPermissionChecker().removeType();
		this.context.removeType(name, removeIfObjectsExist, removeIfSubtypesExist);
	}

	@Override
	public ObjectsList getObjectsList(final String name)
	{
		return this.context.getObjectsListByName(name);
	}

	@Override
	public TypeMetadata getTypeMetadata(final String name)
	{
		return this.context.getTypeByName(name);
	}

	@Override
	public boolean isReadonly()
	{
		return this.context.getPermissionChecker().isReadonly();
	}
	
	public SessionContext getContext()
	{
		return this.context;
	}
	
	
}
