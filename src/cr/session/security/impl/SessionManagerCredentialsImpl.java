package cr.session.security.impl;


public class SessionManagerCredentialsImpl extends SessionCredentialsBaseImpl
{

	@Override
	public boolean canChange()
	{
		return true;
	}

}
