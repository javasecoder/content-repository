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
		
		// ���������������� ������
		SessionContextManager.registerSession(this);
	}
	
	
	@Override
	public void commit()
	{
		// ������� ������
		SessionContextManager.removeSession(this);
		
		// ���� ������ �� ��� ������, �������� ��������
		if (!this.isReadonly())
		{
			SessionContextManager.getStorageManager().setContext(this.context);
		}
	}
	
	@Override
	public void rollback()
	{
		// ������� ������
		SessionContextManager.removeSession(this);
	}

	@Override
	public TypeMetadata createType(final String name)
	{
		// �������� ����
		this.context.getPermissionChecker().createType();
		return this.context.createType(name);
	}

	@Override
	public TypeMetadata createType(final String name, final TypeMetadata baseType)
	{
		// �������� ����
		this.context.getPermissionChecker().createType();
		return this.context.createType(name, baseType);
	}

	@Override
	public void removeType(final String name, final boolean removeIfObjectsExist, final boolean removeIfSubtypesExist)
	{
		// �������� ����
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
