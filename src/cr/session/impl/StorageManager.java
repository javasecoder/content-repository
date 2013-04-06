package cr.session.impl;


public class StorageManager
{
	
	private volatile SessionContext context = null;
	
	
	
	public void read()
	{
		// TODO
	}
	
	public void write()
	{
		// TODO
	}
	
	
	public void setContext(final SessionContext newContext)
	{
		this.context = newContext;
		
		this.write();
	}
	
	public SessionContext getContext()
	{
		return this.context;
	}
	
	
	
	
}
